package br.com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.model.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

}
