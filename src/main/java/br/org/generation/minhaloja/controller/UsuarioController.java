package br.org.generation.minhaloja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.minhaloja.model.Usuario;
import br.org.generation.minhaloja.security.Autenticador;
import br.org.generation.minhaloja.security.Token;
import br.org.generation.minhaloja.servico.IUsuarioService;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService uSrv;
	
    @PostMapping("/usuario/novo")
    public ResponseEntity<Usuario> newUser(@RequestBody Usuario usuario){
    	try {
    		uSrv.inserirNovoUsuario(usuario);
    		return ResponseEntity.ok(usuario);
    	}
    	catch(Exception ex) {
    		return ResponseEntity.badRequest().build();
    	}
    }
    
    @PostMapping("/usuario/login")
    public ResponseEntity<Token> loginUser(@RequestBody Usuario usuario){
    	Usuario user = uSrv.autenticarUsuario(usuario);
    	if (user != null) {
    		Token token = Autenticador.generateToken(usuario);
    		return ResponseEntity.ok(token);
    	}
    	else {
    		return ResponseEntity.status(403).build();
    	}
    }

}
