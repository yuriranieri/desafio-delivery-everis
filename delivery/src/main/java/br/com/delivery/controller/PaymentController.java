package br.com.delivery.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.delivery.dto.PaymentDto;
import br.com.delivery.model.CartEntity;
import br.com.delivery.model.CartStatus;
import br.com.delivery.model.PaymentEntity;
import br.com.delivery.repository.CartRepository;
import br.com.delivery.repository.PaymentRepository;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private CartRepository cartRepository;

	@GetMapping
	public List<PaymentDto> listPayments() {
		List<PaymentEntity> payments = paymentRepository.findAll();
		return PaymentDto.convertToList(payments);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PaymentDto> getPayment(@PathVariable Long id) {
		Optional<PaymentEntity> optional = paymentRepository.findById(id);

		if (optional.isPresent()) {
			PaymentEntity paymentEntity = optional.get();
			return ResponseEntity.ok(new PaymentDto(paymentEntity));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<PaymentDto> createPayment(@RequestBody @Valid PaymentDto dto) {
		Optional<CartEntity> optional = cartRepository.findById(dto.getCart().getId());

		if (optional.isPresent()) {
			CartEntity cart = optional.get();
			cart.setStatus(CartStatus.CONCLUDED);

			PaymentEntity paymentEntity = new PaymentEntity(LocalDateTime.now(), cart.getClient().getPayment(), cart);
			paymentEntity.setDate(LocalDateTime.now());
			paymentEntity.setCart(cart);

			paymentRepository.save(paymentEntity);

			return ResponseEntity.status(HttpStatus.CREATED).body(new PaymentDto(paymentEntity));
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
