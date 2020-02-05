package br.org.generation.minhaloja.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;

@Entity
@Table(name="tbl_pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpedido")
	private int idPedido;
	@Column(name="total")
	private float total;
	
	@ManyToOne
	@JsonIgnoreProperties("pedidos")
	private Usuario usuario;

	@OneToMany(mappedBy = "pedido")
	@JsonIgnoreProperties("pedido")
	private List<ItemPedido> itens;
	
	
	public int getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}


	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<ItemPedido> getItens() {
		return itens;
	}


	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}


	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
