package br.com.nff.bancofinanceirospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.nff.bancofinanceirospring.domain.Account;
import br.com.nff.bancofinanceirospring.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

	private final AccountRepository accountRepository;
	
	public List<Account> findAll(){
		return accountRepository.findAll();
		
	}
	
	public Account insert(Account account){
		return accountRepository.save(account);
	}
	
}
