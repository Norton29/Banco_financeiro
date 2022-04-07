package br.com.nff.bancofinanceirospring.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nff.bancofinanceirospring.domain.Client;
import br.com.nff.bancofinanceirospring.service.ClientService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
	
	private final ClientService service;
	
//	@Value("${start_time}")
//	public String startTime() {
//		return this.startTime();
//	}
//	
//	@Value("${end_time}")
//	public String endTime() {	
//		return this.endTime();
//	}

	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> list = service.findAll();
		for(Client client : list) {
			client.add(linkTo(methodOn(ClientController.class).findById(client.getId())).withSelfRel());
		}
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		Client client = service.findById(id);		
		client.add(linkTo(methodOn(ClientController.class).findAll()).withRel("Lista de Clientes"));
		return ResponseEntity.ok().body(client);
	}
	
	
	
	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody @Valid Client client){
				client = service.insert(client);
				return ResponseEntity.ok().body(client);
	}
	
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}
	