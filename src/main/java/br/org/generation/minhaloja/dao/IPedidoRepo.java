package br.org.generation.minhaloja.dao;

import org.springframework.data.repository.CrudRepository;

import br.org.generation.minhaloja.model.Pedido;

public interface IPedidoRepo extends CrudRepository<Pedido, Integer>{

}
