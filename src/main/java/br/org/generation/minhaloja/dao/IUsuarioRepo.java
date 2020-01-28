package br.org.generation.minhaloja.dao;

import org.springframework.data.repository.CrudRepository;

import br.org.generation.minhaloja.model.Usuario;

public interface IUsuarioRepo extends CrudRepository<Usuario, Integer>{
	public Usuario findUsuarioByEmailAndSenha(String email, String senha);
}
