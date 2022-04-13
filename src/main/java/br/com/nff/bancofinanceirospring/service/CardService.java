package br.com.nff.bancofinanceirospring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.nff.bancofinanceirospring.domain.Card;
import br.com.nff.bancofinanceirospring.repository.CardRepository;
import br.com.nff.bancofinanceirospring.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardService {

	private final CardRepository cardRepository;
	
	public List<Card> findAll(){
		return cardRepository.findAll();
		
	}
	
	public Card findById(Long id) {
		Optional<Card> card = cardRepository.findById(id);
		return card.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Card insert(Card card){
		return cardRepository.save(card);
	}
	
	public void delete(Long id) {
		cardRepository.deleteById(id);
				
	}	
	
	public Card update(Long id, Card card) {
		try {
			Card entity = cardRepository.getReferenceById(id);
			updateData(entity, card);
			return cardRepository.save(entity);
		}catch(EntityNotFoundException e){
			throw new ResourceNotFoundException(id);
			
		}
	}

	private void updateData(Card entity, Card card) {
		entity.setCardNumber(card.getCardNumber());
		entity.setCardType(card.getCardType());
		entity.setAccountNumber(card.getAccountNumber());
	}
	
	
	
}
