package br.com.delivery.dto;

import javax.validation.constraints.NotNull;

public class ItemDto {

	@NotNull
	private long productId;
	@NotNull
	private int quantity;
	
	public ItemDto() {
	}
	
	public ItemDto(long productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	public long getProductId() {
		return productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
