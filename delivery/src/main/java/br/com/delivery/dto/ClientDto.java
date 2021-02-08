package br.com.delivery.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import br.com.delivery.model.ClientEntity;

public class ClientDto {

	private Long id;
	private String name;
	private String phone;
	private String email;
	
	public ClientDto() {
	}

	public ClientDto(Long id, String name, String phone, String email) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public ClientDto(ClientEntity client) {
		this.id = client.getId();
		this.name = client.getName();
		this.phone = client.getPhone();
		this.email = client.getEmail();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static List<ClientDto> convert(List<ClientEntity> clients) {
		return clients.stream().map(ClientDto::new).collect(Collectors.toList());
	}
	
	public ClientDto convertToDto(@Valid ClientEntity entity) {
		return new ClientDto(entity);
	}

}
