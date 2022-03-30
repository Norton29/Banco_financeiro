package br.com.nff.bancofinanceirospring.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nff.bancofinanceirospring.domain.CardDTO;
import br.com.nff.bancofinanceirospring.service.CardService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {
	
	private final CardService service;

	@GetMapping
	public ResponseEntity<List<CardDTO>> findAll(){
		List<CardDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<CardDTO> insert(@RequestBody CardDTO card){
		card = service.insert(card);
		return ResponseEntity.ok().body(card);
	}
}
	