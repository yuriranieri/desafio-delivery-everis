package br.com.delivery.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class UpdateCartDto {
	
	@NotNull
	private Long id;
	
	@NotNull
	private long clientId;
	@NotNull
	private List<ItemDto> products;
	
	public UpdateCartDto() {
	}
	
	public UpdateCartDto(Long id, long clientId, List<ItemDto> products) {
		this.id = id;
		this.clientId = clientId;
		this.products = products;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public List<ItemDto> getProducts() {
		return products;
	}

	public void setProducts(List<ItemDto> products) {
		this.products = products;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
}
