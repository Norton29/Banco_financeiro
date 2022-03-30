package br.com.nff.bancofinanceirospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.nff.bancofinanceirospring.domain.AccountDTO;
import br.com.nff.bancofinanceirospring.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

	private final AccountRepository accountRepository;
	
	public List<AccountDTO> findAll(){
		return accountRepository.findAll();
		
	}
	
	public AccountDTO insert(AccountDTO account){
		return accountRepository.save(account);
	}
	
}
