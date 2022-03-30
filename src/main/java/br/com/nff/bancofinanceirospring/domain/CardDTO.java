package br.com.nff.bancofinanceirospring.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.nff.bancofinanceirospring.domain.PK.CardPK;
import br.com.nff.bancofinanceirospring.domain.enums.CardType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="card_dto")
public class CardDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private CardType cardType;	
	private Integer accountNumber;
	private Integer cardNumber;
	
	@EmbeddedId
	private CardPK idCard= new CardPK();
	
	@ManyToOne
	@JoinColumn(name = "Client_DTO_id")
	private ClientDTO client;
	
	public CardDTO(Long id, CardType cardType, Integer accountNumber, Integer cardNumber) {
		super();
		this.id = id;
		setCardType(cardType);
		this.accountNumber = accountNumber;
		this.cardNumber = cardNumber;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}
	
	

}
