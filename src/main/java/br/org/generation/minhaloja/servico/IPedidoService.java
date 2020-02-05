package br.org.generation.minhaloja.servico;

import java.util.List;

import br.org.generation.minhaloja.model.Pedido;

public interface IPedidoService {
    public void addNewPedido(Pedido pedido);
    public List<Pedido> getAllPedidos();
}
