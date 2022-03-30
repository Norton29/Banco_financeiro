package br.com.nff.bancofinanceirospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.nff.bancofinanceirospring.domain.enums.AccountType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name= "account_dto")
public class AccountDTO {
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private AccountType accountType;
	
	private Integer accountNumber;
	private Double balance;
	
	@ManyToOne
	@JoinColumn(name = "Client_DTO_id")
	private ClientDTO client;
	
	
	public AccountDTO(Long id, AccountType accountType, Integer accountNumber, Double balance) {
		super();
		this.id = id;
		setAccountType(accountType);
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	
	public AccountType getAccountType() {
		return accountType;
	}
	
	
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	
	
	
}
