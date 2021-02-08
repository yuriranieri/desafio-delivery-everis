package br.com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.model.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

}
