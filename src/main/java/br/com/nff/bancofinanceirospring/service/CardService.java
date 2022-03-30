package br.com.nff.bancofinanceirospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.nff.bancofinanceirospring.domain.CardDTO;
import br.com.nff.bancofinanceirospring.domain.ClientDTO;
import br.com.nff.bancofinanceirospring.repository.CardRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardService {

	private final CardRepository cardRepository;
	
	public List<CardDTO> findAll(){
		return cardRepository.findAll();
		
	}
	
	public CardDTO insert(CardDTO card){
		return cardRepository.save(card);
	}
	
}
