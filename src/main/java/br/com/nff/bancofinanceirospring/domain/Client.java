package br.com.nff.bancofinanceirospring.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_client")
public class Client extends RepresentationModel<Client> implements Serializable{
	
	


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@NotNull(message = "Name is mandatory")
	@NotBlank
	@Column(unique = true)
	private String name;
	
	@NotNull(message = "Last name is mandatory")
	@NotBlank
	private String lastName;
	
	@NotNull(message = "Birth Date is mandatory")
	private Instant birthDate;
	
	@NotNull(message = "Sex orientation is mandatory")
	@NotBlank
	private String sexo;		

	@NotNull(message = "ID Documentation is mandatory")	
	private Integer idDoc;
	
	@NotNull(message = "Marital Status is mandatory")
	@NotBlank
	private String maritalStatus;
	
	@NotNull(message = "Nationality is mandatory")
	@NotBlank
	private String nationality;
	
	
	@OneToMany(mappedBy = "client")
	private List<Account> accountLists;
	
	
	@OneToMany(mappedBy = "client")
	private List<Card> cardLists;
	
	
	@JsonIgnore
	public List<Account> getAccountLists() {
		return accountLists;
	}


	public void setAccountLists(List<Account> accountLists) {
		this.accountLists = accountLists;
	}


	@JsonIgnore
	public List<Card> getCardLists() {
		return cardLists;
	}


	public void setCardLists(List<Card> cardLists) {
		this.cardLists = cardLists;
	}
	
	
}
