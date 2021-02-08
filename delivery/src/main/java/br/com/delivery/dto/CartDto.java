package br.com.delivery.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.delivery.model.CartEntity;
import br.com.delivery.model.CartStatus;
import br.com.delivery.model.ClientEntity;
import br.com.delivery.model.ItemEntity;

public class CartDto {
	
	private Long id;
	private double total;
	private CartStatus status;
	private LocalDateTime creationDate;
	private ClientEntity client;
	private List<ItemEntity> items;
	
	public CartDto() {
	}
	
	public CartDto(CartEntity cart) {
		this.id = cart.getId();
		this.total = cart.getTotal();
		this.status = cart.getStatus();
		this.creationDate = cart.getCreationDate();
		this.client = cart.getClient();
		this.items = cart.getItems();
	}

	public CartDto(Long id, double total, CartStatus status, LocalDateTime creationDate, ClientEntity client,
			List<ItemEntity> items) {
		this.id = id;
		this.total = total;
		this.status = status;
		this.creationDate = creationDate;
		this.client = client;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public double getTotal() {
		return total;
	}

	public CartStatus getStatus() {
		return status;
	}
	
	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public ClientEntity getClient() {
		return client;
	}

	public List<ItemEntity> getItems() {
		return items;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setStatus(CartStatus status) {
		this.status = status;
	}
	
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}

	public static List<CartDto> converToList(List<CartEntity> carts) {
		return carts.stream().map(CartDto::new).collect(Collectors.toList());
	}

	public CartDto convertToDto(CartEntity entity) {
		return new CartDto(entity);
	}

}
