package br.com.nff.bancofinanceirospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nff.bancofinanceirospring.domain.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
	
	

}
