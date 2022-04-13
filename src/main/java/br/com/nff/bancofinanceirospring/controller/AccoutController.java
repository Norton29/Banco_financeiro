package br.com.nff.bancofinanceirospring.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nff.bancofinanceirospring.domain.Account;
import br.com.nff.bancofinanceirospring.domain.DTO.AccountDTO;
import br.com.nff.bancofinanceirospring.service.AccountService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accouts")
@RequiredArgsConstructor
public class AccoutController {
	
	private final AccountService service;
	private Account account;

	@GetMapping
	public ResponseEntity<List<AccountDTO>> findAll(){
		List<Account> list = service.findAll();
		List<AccountDTO> listDTO = list.stream().map(x -> new AccountDTO(x)).collect(Collectors.toList());
		for(Account account : list) {
			account.add(linkTo(methodOn(AccoutController.class).findById(account.getId())).withSelfRel());
		}
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Account> findById(@PathVariable Long id){
		Account account = service.findById(id);
		account.add(linkTo(methodOn(AccoutController.class).findAll()).withRel("Lista de contas"));
		return ResponseEntity.ok().body(account);
	}
	
	@PostMapping
	public ResponseEntity<Account> insert(@RequestBody @Valid Account account){
		account = service.insert(account);
		account.add(linkTo(methodOn(AccoutController.class).findById(account.getId())).withSelfRel());
		return ResponseEntity.ok().body(account);
	}	
	
	@PutMapping(value= "/{id}")
	public ResponseEntity<Account> update(@PathVariable Long id, @RequestBody Account account){
		account = service.update(id, account);
		account.add(linkTo(methodOn(AccoutController.class).findById(id)).withSelfRel());
		return ResponseEntity.ok().body(account);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Account> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.ok().body(account);
	}
	
	

}
	