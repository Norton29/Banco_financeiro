package br.com.nff.bancofinanceirospring.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_client")
public class ClientDTO {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@NotNull(message = "Name is mandatory")
	private String name;
	private String lastName;
	
	@NotNull(message = "Birth Date is mandatory")
	private Date birthDate;
	private String sexo;
		
	@NotNull(message = "ID Documentation is mandatory")
	private Integer idDoc;
	private String maritalStatus;
	private String nationality;
	
	@OneToMany(mappedBy = "idCard.client")
	private Set<CardDTO> cards = new HashSet<>();
	
	
}
