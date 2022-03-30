package br.com.nff.bancofinanceirospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.time.Instant;
import java.util.Properties;

@Service
public class ValidadorDeJanela {

    //Expression language
    @Value("${spring.jpa.hibernate.janela-inicio}")
    private String janelaInicio;

    @Value("${spring.jpa.hibernate.janela-fim}")
    private String janelaFim;

    private void validarJanela(){
        Instant now = Instant.now();


    }
}
