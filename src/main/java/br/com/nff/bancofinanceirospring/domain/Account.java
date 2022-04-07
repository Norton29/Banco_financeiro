package br.com.nff.bancofinanceirospring.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import br.com.nff.bancofinanceirospring.domain.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "tb_account", uniqueConstraints = {@UniqueConstraint(columnNames = {"accountType" , "client_id"})})
public class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "Account Type is mandatory")
	private AccountType accountType;	
	
	@NotNull(message = "Account Number is mandatory")
	private Integer accountNumber;
	
	@NotNull(message = "Balance is mandatory")
	private Double balance;
	
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	
	@OneToMany(mappedBy = "account")
	private List<Card> cardLists;
	


	
//	public AccountDTO(Long id, AccountType accountType, Integer accountNumber, Double balance) {
//		super();
//		this.id = id;
//		setAccountType(accountType);
//		this.accountNumber = accountNumber;
//		this.balance = balance;
//	}
//	
//	
//	public AccountType getAccountType() {
//		return accountType;
//	}
//	
//	
//	public void setAccountType(AccountType accountType) {
//		this.accountType = accountType;
//	}

	
	
	
}
