package br.org.generation.minhaloja.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.org.generation.minhaloja.dao.IProdutoRepo;
import br.org.generation.minhaloja.model.Produto;

@Component
public class ProdutoServiceImpl implements IProdutoService {

	@Autowired
	private IProdutoRepo repo;
	@Override
	public Produto recuperaPorId(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Produto> recuperaTodos() {
		// TODO Auto-generated method stub
		return (List<Produto>)repo.findAll();
	}

	@Override
	public List<Produto> recuperaPorDepartamento(int id) {
		// TODO Auto-generated method stub
		return (List<Produto>)repo.findAllByDepartamento(id);
	}

}
