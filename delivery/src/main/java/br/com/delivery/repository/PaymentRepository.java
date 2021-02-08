package br.com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.model.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
