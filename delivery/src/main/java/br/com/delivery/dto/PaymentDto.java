package br.com.delivery.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import br.com.delivery.model.CartEntity;
import br.com.delivery.model.PaymentEntity;
import br.com.delivery.model.PaymentType;

public class PaymentDto {
	
	private Long id;
	private PaymentType type;
	private LocalDateTime date;
	
	@NotNull
	private CartEntity cart;
	
	public PaymentDto() {
	}
	
	public PaymentDto(Long id, CartEntity cart, PaymentType type, LocalDateTime date) {
		this.id = id;
		this.type = type;
		this.cart = cart;
		this.date = date;
	}
	
	public PaymentDto(PaymentEntity entity) {
		this.id = entity.getId();
		this.type = entity.getCart().getClient().getPayment();
		this.cart = entity.getCart();
		this.date = entity.getDate();
	}

	public Long getId() {
		return id;
	}

	public CartEntity getCart() {
		return cart;
	}

	public PaymentType getType() {
		return type;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	
	public static List<PaymentDto> convertToList(List<PaymentEntity> payments) {
		return payments.stream().map(PaymentDto::new).collect(Collectors.toList());
	}

}
