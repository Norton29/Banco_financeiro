package br.com.nff.bancofinanceirospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nff.bancofinanceirospring.domain.Client;

public interface ClienteRepository extends JpaRepository<Client, Long> {
	
	

}
