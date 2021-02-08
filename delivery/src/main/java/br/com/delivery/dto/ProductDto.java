package br.com.delivery.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.delivery.model.ProductEntity;

public class ProductDto {

	private Long id;
	
	@NotNull
	@NotEmpty
	private String description;
	
	@NotNull
	private double price;
	
	public ProductDto() {
	}

	public ProductDto(Long id, String description, double price) {
		this.id = id;
		this.description = description;
		this.price = price;
	}
	
	public ProductDto(ProductEntity product) {
		this.id = product.getId();
		this.description = product.getDescription();
		this.price = product.getPrice();
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}
	
	public static List<ProductDto> convertToList(List<ProductEntity> products) {
		return products.stream().map(ProductDto::new).collect(Collectors.toList());
	}

	public ProductEntity convertToEntity(ProductDto dto) {
		return new ProductEntity(dto.getDescription(), dto.getPrice());
	}

	public ProductDto convertToDto(ProductEntity entity) {
		return new ProductDto(entity);
	}

}
