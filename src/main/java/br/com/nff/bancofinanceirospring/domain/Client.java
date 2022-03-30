package br.com.nff.bancofinanceirospring.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client {

    //CHAVE PRIMARIA
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String surName;

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;

    @OneToMany(mappedBy = "client")
    private List<Card> cards;


}
