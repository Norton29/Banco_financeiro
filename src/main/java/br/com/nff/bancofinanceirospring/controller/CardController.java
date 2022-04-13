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

import br.com.nff.bancofinanceirospring.domain.Card;
import br.com.nff.bancofinanceirospring.domain.DTO.CardDTO;
import br.com.nff.bancofinanceirospring.service.CardService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController{
	
	private final CardService service;

	@GetMapping
	public ResponseEntity<List<CardDTO>> findAll(){
		List<Card> list = service.findAll();
		List<CardDTO> listDTO = list.stream().map(x -> new CardDTO(x)).collect(Collectors.toList());
		for(Card card : list) {
			card.add(linkTo(methodOn(CardController.class).findById(card.getId())).withSelfRel());
		}
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Card> findById(@PathVariable Long id){
		Card card = service.findById(id);
		card.add(linkTo(methodOn(CardController.class).findAll()).withRel("Lista de Cartões"));
		return ResponseEntity.ok().body(card);
	}
	
	@PostMapping
	public ResponseEntity<Card> insert(@RequestBody @Valid Card card){
		card = service.insert(card);
		card.add(linkTo(methodOn(CardController.class).findById(card.getId())).withSelfRel());
		return ResponseEntity.ok().body(card);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Card> update(@PathVariable Long id, @RequestBody Card card){
		card = service.update(id, card);
		card.add(linkTo(methodOn(CardController.class).findById(card.getId())).withSelfRel());
		return ResponseEntity.ok().body(card);
	}
	
	
	
	
}
	