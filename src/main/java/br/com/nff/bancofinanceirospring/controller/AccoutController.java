package br.com.nff.bancofinanceirospring.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nff.bancofinanceirospring.domain.Account;
import br.com.nff.bancofinanceirospring.service.AccountService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accouts")
@RequiredArgsConstructor
public class AccoutController {
	
	private final AccountService service;

	@GetMapping
	public ResponseEntity<List<Account>> findAll(){
		List<Account> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Account> insert(@RequestBody Account account){
		account = service.insert(account);
		return ResponseEntity.ok().body(account);
	}	

}
	