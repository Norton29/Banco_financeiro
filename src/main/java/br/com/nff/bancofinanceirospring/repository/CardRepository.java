package br.com.nff.bancofinanceirospring.repository;

import br.com.nff.bancofinanceirospring.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

//Herança entre interfaces
public interface CardRepository extends JpaRepository<Card, Long> {
}
