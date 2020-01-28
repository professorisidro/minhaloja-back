package br.org.generation.minhaloja.servico;

import br.org.generation.minhaloja.model.Usuario;

public interface IUsuarioService {
	public void inserirNovoUsuario(Usuario usuario);
	public Usuario autenticarUsuario(Usuario usuario);

}
