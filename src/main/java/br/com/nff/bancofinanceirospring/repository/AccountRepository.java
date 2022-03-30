package br.com.nff.bancofinanceirospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nff.bancofinanceirospring.domain.AccountDTO;

public interface AccountRepository extends JpaRepository<AccountDTO, Long> {
	
	

}
