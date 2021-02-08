package br.com.delivery.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.delivery.dto.CartDto;
import br.com.delivery.dto.CreateCartDto;
import br.com.delivery.model.CartEntity;
import br.com.delivery.model.CartStatus;
import br.com.delivery.model.ClientEntity;
import br.com.delivery.model.ItemEntity;
import br.com.delivery.model.ProductEntity;
import br.com.delivery.repository.CartRepository;
import br.com.delivery.repository.ClientRepository;
import br.com.delivery.repository.ProductRepository;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public List<CartDto> listCarts() {
		List<CartEntity> carts = cartRepository.findAll();
		return CartDto.converToList(carts);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CartDto> listCart(@PathVariable Long id) {
		Optional<CartEntity> optional = cartRepository.findById(id);

		if (optional.isPresent()) {
			return ResponseEntity.ok(new CartDto(optional.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<CartDto> createCart(@RequestBody @Valid CreateCartDto dto) {
		Optional<ClientEntity> optional = clientRepository.findById(dto.getClientId());

		if (optional.isPresent()) {
			ClientEntity client = optional.get();
			CartEntity cart = new CartEntity(client, LocalDateTime.now(), CartStatus.PENDING);

			List<ItemEntity> items = buildItemsList(dto, cart);

			double total = calculateTotal(items);

			cart.setTotal(total);
			cart.setItems(items);

			cartRepository.save(cart);
			return ResponseEntity.status(HttpStatus.CREATED).body(new CartDto(cart));
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCart(@PathVariable Long id) {
		Optional<CartEntity> optional = cartRepository.findById(id);

		if (optional.isPresent()) {
			cartRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	private List<ItemEntity> buildItemsList(CreateCartDto dto, CartEntity cart) {
		return dto.getProducts().stream().map(item -> {
			ProductEntity product = productRepository.findById(item.getProductId()).get();
			return new ItemEntity(product.getDescription(), product.getPrice(), item.getQuantity(), cart);
		}).collect(Collectors.toList());
	}
	
	private double calculateTotal(List<ItemEntity> items) {
		return items.stream().filter(item -> item.getQuantity() > 0)
				.mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
	}

//	@PutMapping("/{id}") 
//	public ResponseEntity<CartDto> updateCart(@PathVariable Long id, @RequestBody UpdateCartForm form) {
//		Optional<CartEntity> optional = cartRepository.findById(id);
//
//		if (optional.isPresent()) {
//			CartEntity cart = form.updateCart(id, cartRepository, itemDto);
//			return
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}

}
