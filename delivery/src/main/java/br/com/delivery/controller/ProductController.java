package br.com.delivery.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.delivery.dto.ProductDto;
import br.com.delivery.model.ProductEntity;
import br.com.delivery.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping
	public List<ProductDto> listProducts() {
		List<ProductEntity> products = productRepository.findAll();
		return ProductDto.convertToList(products);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> listProduct(@PathVariable Long id) {
		Optional<ProductEntity> product = productRepository.findById(id);
		
		if(product.isPresent()) {
			return ResponseEntity.ok(new ProductDto(product.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductDto dto) {
		ProductEntity product = dto.convertToEntity(dto);
		productRepository.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDto(product));
	}
	
	@PutMapping
	public ResponseEntity<ProductDto> updateProduct(@RequestBody @Valid ProductEntity entity, ProductDto dto) {
		Optional<ProductEntity> optional = productRepository.findById(entity.getId());
		
		if (optional.isPresent()) {
			productRepository.save(entity);
			ProductDto dto2 = dto.convertToDto(entity);
			return ResponseEntity.ok(dto2);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		Optional<ProductEntity> optional = productRepository.findById(id);

		if (optional.isPresent()) {
			productRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	

}
