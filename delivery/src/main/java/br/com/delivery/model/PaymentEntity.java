package br.com.delivery.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class PaymentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "date")
	private LocalDateTime date;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private PaymentType type;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cart_id")
	private CartEntity cart;
	
	public PaymentEntity() {
	}

	public PaymentEntity(LocalDateTime date, PaymentType type, CartEntity cart) {
		this.date = date;
		this.type = type;
		this.cart = cart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}
	

}
