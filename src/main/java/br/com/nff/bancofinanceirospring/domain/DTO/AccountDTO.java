package br.com.nff.bancofinanceirospring.domain.DTO;

import java.util.List;

import br.com.nff.bancofinanceirospring.domain.Account;
import br.com.nff.bancofinanceirospring.domain.Card;
import br.com.nff.bancofinanceirospring.domain.Client;
import br.com.nff.bancofinanceirospring.domain.enums.AccountType;
import lombok.Data;

@Data
public class AccountDTO {

	private AccountType accountType;
	private Integer accountNumber;
	private Double balance;
	private Client client;
	private List<Card> cardLists;
	
	public AccountDTO(Account obj) {
		accountType = obj.getAccountType();
		accountNumber = obj.getAccountNumber();
		balance = obj.getBalance();
		client = obj.getClient();
		cardLists = obj.getCardLists();
	}
}
