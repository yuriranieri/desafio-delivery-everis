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

import br.com.delivery.dto.ClientDetailsDto;
import br.com.delivery.dto.ClientDto;
import br.com.delivery.dto.CreateClientDto;
import br.com.delivery.model.ClientEntity;
import br.com.delivery.repository.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public List<ClientDto> listClients() {
		List<ClientEntity> clients= clientRepository.findAll();
        return ClientDto.convert(clients);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientDetailsDto> listClientDetails(@PathVariable Long id) {
		Optional<ClientEntity> client = clientRepository.findById(id);

		if (client.isPresent()) {
			return ResponseEntity.ok(new ClientDetailsDto(client.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<ClientDto> createClient(@RequestBody @Valid CreateClientDto form) {
		ClientEntity client = form.convert(form); 
		clientRepository.save(client);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ClientDto(client));
	}
	
	@PutMapping
	public ResponseEntity<ClientDto> updateClient(@RequestBody @Valid ClientEntity entity, ClientDto clientDto) {
		Optional<ClientEntity> optional = clientRepository.findById(entity.getId());
		
		if (optional.isPresent()) {
			clientRepository.save(entity);
			ClientDto dto = clientDto.convertToDto(entity);
			return ResponseEntity.ok(dto); 
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteClient(@PathVariable Long id) {
		Optional<ClientEntity> optional = clientRepository.findById(id);

		if (optional.isPresent()) {
			clientRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}




