package br.com.delivery.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class CreateCartDto {
	
	@NotNull
	private long clientId;
	@NotNull
	private List<ItemDto> products;
	
	public CreateCartDto() {
	}

	public CreateCartDto(long clientId, List<ItemDto> products) {
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

}
