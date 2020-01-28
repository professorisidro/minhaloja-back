package br.org.generation.minhaloja.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.org.generation.minhaloja.model.Produto;

public interface IProdutoRepo extends CrudRepository<Produto, Integer>{
	public List<Produto> findAllByDepartamento(int departamento_id);

}
