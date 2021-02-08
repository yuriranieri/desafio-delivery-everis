package br.com.delivery.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.delivery.model.AddressEntity;
import br.com.delivery.model.ClientEntity;
import br.com.delivery.model.PaymentType;

public class CreateClientDto {

	@NotNull
	@NotEmpty
	private String name;
	
	@NotNull
	private List<AddressEntity> address;
	
	@NotNull 
	@NotEmpty
	private String phone;
	
	@NotNull 
	@NotEmpty
	private String email;
	
	@NotNull 
	@NotEmpty
	private String cpf;
	
	@NotNull
	private PaymentType payment;
	
	public CreateClientDto() {
	}
	
	public CreateClientDto(ClientEntity client) {
		this.name = client.getName();
		this.address = client.getAddress();
		this.phone = client.getPhone();
		this.email = client.getEmail();
		this.cpf = client.getCpf();
		this.payment = client.getPayment();
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

	public ClientEntity convert(CreateClientDto form) {
		return new ClientEntity(form.getName(), form.getAddress(), form.getPhone(), form.getEmail(), form.getCpf(), form.getPayment());
	}

}
