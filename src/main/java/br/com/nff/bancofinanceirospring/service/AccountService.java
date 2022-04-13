package br.com.nff.bancofinanceirospring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.nff.bancofinanceirospring.domain.Account;
import br.com.nff.bancofinanceirospring.repository.AccountRepository;
import br.com.nff.bancofinanceirospring.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

	private final AccountRepository accountRepository;

	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	public Account findById(Long id) {
		Optional<Account> account = accountRepository.findById(id);
		return account.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Account insert(Account account) {
		return accountRepository.save(account);
	}

	public void deleteById(Long id) {
		accountRepository.deleteById(id);
	}

	public Account update(Long id, Account account) {
		try {
			Account entity = accountRepository.getReferenceById(id);
			updateData(entity, account);
			return accountRepository.save(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);

		}

	}

	private void updateData(Account entity, Account account) {
		entity.setAccountType(account.getAccountType());
		entity.setAccountNumber(account.getAccountNumber());
		entity.setBalance(account.getBalance());
	}

}
