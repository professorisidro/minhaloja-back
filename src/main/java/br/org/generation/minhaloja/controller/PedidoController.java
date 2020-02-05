package br.org.generation.minhaloja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.minhaloja.model.Pedido;
import br.org.generation.minhaloja.servico.IPedidoService;
import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
@CrossOrigin("*")
public class PedidoController {
	@Autowired
	private IPedidoService srv;
	
	@PostMapping("/pedido/novo")
	public ResponseEntity<Pedido> inserirNovo(@RequestBody Pedido pedido){
		
		System.out.println("Info do Pedido");
		System.out.println(pedido);
		System.out.println("------------");
		srv.addNewPedido(pedido);
		return ResponseEntity.ok(pedido);
	}
	
	@GetMapping("/pedido/todos")
	public ResponseEntity<List<Pedido>> recuperarTudo(){
		return ResponseEntity.ok(srv.getAllPedidos());
	}

}
