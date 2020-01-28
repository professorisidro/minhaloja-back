package br.org.generation.minhaloja.servico;

import java.util.List;

import br.org.generation.minhaloja.model.Produto;

public interface IProdutoService {
	public Produto recuperaPorId(int id);
	public List<Produto> recuperaTodos();
	public List<Produto> recuperaPorDepartamento(int id);

}
