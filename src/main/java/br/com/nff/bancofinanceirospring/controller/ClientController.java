package br.com.nff.bancofinanceirospring.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nff.bancofinanceirospring.domain.Client;
import br.com.nff.bancofinanceirospring.domain.DTO.ClientDTO;
import br.com.nff.bancofinanceirospring.service.ClientService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

	private final ClientService service;
	private Client client;
	
	@Value("${start_time}")
	private String startTime;
	private String endTime;

		
	@Value("${end_time}")
	public String endTime() {	
		return this.endTime;
	}

	@GetMapping	
	public ResponseEntity<List<ClientDTO>> findAll() {
		List<Client> list = service.findAll();
		List<ClientDTO> listDTO = list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
		for (Client client : list) {
			client.add(linkTo(methodOn(ClientController.class).findById(client.getId())).withSelfRel());
		}
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		Client client = service.findById(id);
		client.add(linkTo(methodOn(ClientController.class).findAll()).withRel("Lista de Clientes"));
		return ResponseEntity.ok().body(client);
	}
	
	@GetMapping(value = "/find/{name}")
	public ResponseEntity<Client> findByName(@PathVariable String name) {
		Client client = service.findByName(name);
		client.add(linkTo(methodOn(ClientController.class).findAll()).withRel("Lista de Clientes"));
		return ResponseEntity.ok().body(client);
	}

	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody @Valid Client client) {
		client = service.insert(client);
		client.add(linkTo(methodOn(ClientController.class).findById(client.getId())).withSelfRel());
		return ResponseEntity.ok().body(client);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
		client = service.update(id, client);
		client.add(linkTo(methodOn(ClientController.class).findById(client.getId())).withSelfRel());
		return ResponseEntity.ok().body(client);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Client> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().body(client);

	}
}
