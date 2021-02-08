package br.com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.delivery.model.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

}
