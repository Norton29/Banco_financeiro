package br.com.nff.bancofinanceirospring.repository;

import br.com.nff.bancofinanceirospring.domain.Card;
import br.com.nff.bancofinanceirospring.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

//Herança entre interfaces
public interface ClientRepository extends JpaRepository<Client, Long> {
}
