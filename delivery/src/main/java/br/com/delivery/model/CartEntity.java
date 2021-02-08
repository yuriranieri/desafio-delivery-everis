package br.com.delivery.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class CartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "total")
	private double total;
	
	@Column(name = "creationDate")
	private LocalDateTime creationDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private CartStatus status;

	@OneToOne
	@JoinColumn(name = "client_id")
	private ClientEntity client;

	@OneToMany(mappedBy = "cart", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	private List<ItemEntity> items;

	public CartEntity() {
	}
	
	public CartEntity(ClientEntity client, LocalDateTime creationDate, CartStatus status) {
		this.client = client;
		this.creationDate = creationDate;
		this.status = status;
	}
	
	public CartEntity(double total, LocalDateTime creationDate, CartStatus status, ClientEntity client,
			List<ItemEntity> items) {
		this.total = total;
		this.creationDate = creationDate;
		this.status = status;
		this.client = client;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public CartStatus getStatus() {
		return status;
	}

	public void setStatus(CartStatus status) {
		this.status = status;
	}

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

	public List<ItemEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}

}
