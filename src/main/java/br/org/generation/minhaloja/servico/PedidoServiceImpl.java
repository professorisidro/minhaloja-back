package br.org.generation.minhaloja.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.org.generation.minhaloja.dao.IItemPedidoRepo;
import br.org.generation.minhaloja.dao.IPedidoRepo;
import br.org.generation.minhaloja.model.ItemPedido;
import br.org.generation.minhaloja.model.Pedido;

@Component
public class PedidoServiceImpl implements IPedidoService{

	@Autowired
	private IPedidoRepo pedidoRepo;
	
	@Autowired
	private IItemPedidoRepo itemRepo;
	
	@Override
	public void addNewPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		pedidoRepo.save(pedido);
		for (ItemPedido item: pedido.getItens()) {
			item.setPedido(pedido);
			itemRepo.save(item);
			pedido.setTotal(pedido.getTotal()+item.getPreco()*item.getQtde());;
		}
		pedidoRepo.save(pedido);
		
	}

	@Override
	public List<Pedido> getAllPedidos() {
		// TODO Auto-generated method stub
		return (ArrayList<Pedido>) pedidoRepo.findAll();
	}

}
