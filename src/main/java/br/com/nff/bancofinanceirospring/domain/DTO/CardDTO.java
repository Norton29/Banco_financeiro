package br.com.nff.bancofinanceirospring.domain.DTO;

import br.com.nff.bancofinanceirospring.domain.Card;
import br.com.nff.bancofinanceirospring.domain.enums.CardType;
import lombok.Data;

@Data
public class CardDTO {

	private CardType cardType;
	private Integer cardNumber;
	private Integer accountNumber;
	
	public CardDTO(Card obj) {
		cardType = obj.getCardType();
		cardNumber = obj.getCardNumber();
		accountNumber = obj.getAccountNumber();
	}
}
