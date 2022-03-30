package br.com.nff.bancofinanceirospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nff.bancofinanceirospring.domain.ClientDTO;

public interface ClienteRepository extends JpaRepository<ClientDTO, Long> {
	
	

}
