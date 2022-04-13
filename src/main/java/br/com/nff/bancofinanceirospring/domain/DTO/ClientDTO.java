package br.com.nff.bancofinanceirospring.domain.DTO;

import java.util.List;

import br.com.nff.bancofinanceirospring.domain.Account;
import br.com.nff.bancofinanceirospring.domain.Card;
import br.com.nff.bancofinanceirospring.domain.Client;
import lombok.Data;

@Data
public class ClientDTO {

	private String name;
	private String lastName;
	private String sexo;
	private List<Account> accountLists;
	private List<Card> cardLists;
	
	public ClientDTO(Client obj) {
		name = obj.getName();
		lastName = obj.getLastName();
		sexo = obj.getSexo();
		accountLists = obj.getAccountLists();
		cardLists = obj.getCardLists();
	}
	
}
