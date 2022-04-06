package br.com.nff.bancofinanceirospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.nff.bancofinanceirospring.domain.Card;
import br.com.nff.bancofinanceirospring.repository.CardRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardService {

	private final CardRepository cardRepository;
	
	public List<Card> findAll(){
		return cardRepository.findAll();
		
	}
	
	public Card insert(Card card){
		return cardRepository.save(card);
	}
	

	public void delete(Long id) {
		cardRepository.deleteById(id);
		
		
	}		
	
}
