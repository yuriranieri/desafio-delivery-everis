package br.com.delivery.dto;

import java.util.List;

import br.com.delivery.model.AddressEntity;
import br.com.delivery.model.ClientEntity;
import br.com.delivery.model.PaymentType;

public class ClientDetailsDto {

	private Long id;
	private String name;
	private String phone;
	private String email;
	private String cpf;
	private PaymentType payment;
	private List<AddressEntity> address;
	
	public ClientDetailsDto(ClientEntity client) {
		this.id = client.getId();
		this.name = client.getName();
		this.address = client.getAddress();
		this.phone = client.getPhone();
		this.email = client.getEmail();
		this.cpf = client.getCpf();
		this.payment = client.getPayment();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<AddressEntity> getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public PaymentType getPayment() {
		return payment;
	}

}
