package br.org.generation.minhaloja.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.org.generation.minhaloja.dao.IUsuarioRepo;
import br.org.generation.minhaloja.model.Usuario;

@Component
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	IUsuarioRepo repo;
	
	
	@Override
	public void inserirNovoUsuario(Usuario usuario) {
		try {
		    repo.save(usuario);
		}
		catch(Exception ex) {
			throw new RuntimeException("Email duplicado!");
		}
	}

	@Override
	public Usuario autenticarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return repo.findUsuarioByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
	}

}
