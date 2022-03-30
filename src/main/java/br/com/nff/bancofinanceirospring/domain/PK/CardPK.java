package br.com.nff.bancofinanceirospring.domain.PK;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.nff.bancofinanceirospring.domain.ClientDTO;
import lombok.Data;

@Embeddable
@Data
public class CardPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private ClientDTO client;
	
	
	
	
		
	
}
