package br.com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
