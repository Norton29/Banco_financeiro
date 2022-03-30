package br.com.nff.bancofinanceirospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nff.bancofinanceirospring.domain.CardDTO;

public interface CardRepository extends JpaRepository<CardDTO, Long> {
	
	

}
