package br.com.nff.bancofinanceirospring.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;

import br.com.nff.bancofinanceirospring.domain.enums.CardType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="tb_card")
public class Card implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@NotNull(message = "Card Type is mandatory")
	private CardType cardType;	
	
	@NotNull(message = "Account Number is mandatory")
	private Integer accountNumber;
	
	@NotNull(message = "Card Number is mandatory")
	private Integer cardNumber;
	
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	
//	public CardDTO(Long id, CardType cardType, Integer accountNumber, Integer cardNumber) {
//		super();
//		this.id = id;
//		setCardType(cardType);
//		this.accountNumber = accountNumber;
//		this.cardNumber = cardNumber;
//	}
//
//	public CardType getCardType() {
//		return cardType;
//	}
//
//	public void setCardType(CardType cardType) {
//		this.cardType = cardType;
//	}
//	
	

}
