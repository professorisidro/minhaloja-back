package br.org.generation.minhaloja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.minhaloja.model.Produto;
import br.org.generation.minhaloja.security.Autenticador;
import br.org.generation.minhaloja.servico.IProdutoService;

@RestController
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private IProdutoService prodSrv;

	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> getProdutoById(@PathVariable int id, @RequestParam String token) {
		System.out.println("TOKEN RECEBIDO= "+token);
		try {
			if (token != null && Autenticador.isValid(token)) {
				Produto p = prodSrv.recuperaPorId(id);
				if (p != null) {
					return ResponseEntity.ok(p);
				}
				return ResponseEntity.notFound().build();
			}
			else {
				return ResponseEntity.status(403).build();
			}
		} catch (Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/produto/departamento/{id}")
	public ResponseEntity<List<Produto>> getAllByDepartamento(@PathVariable int id) {
		return ResponseEntity.ok(null);
	}

	@GetMapping("/produto")
	public ResponseEntity<List<Produto>> getAll(@RequestParam String token) {
		try {
			if (token != null && Autenticador.isValid(token)) {
				return ResponseEntity.ok(prodSrv.recuperaTodos());
			}
			else {
				return ResponseEntity.status(403).build();
			}
		} catch (Exception ex) {
			return ResponseEntity.badRequest().build();
		}
		
		
	}

}
