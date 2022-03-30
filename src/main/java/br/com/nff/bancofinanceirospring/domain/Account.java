package br.com.nff.bancofinanceirospring.domain;

import javax.persistence.*;
import java.util.List;

@Entity//ENTIDADE MAIS FRACA
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long number;

    private String type;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "account")
    private List<Card> cards;

}
