package br.com.nff.bancofinanceirospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.nff.bancofinanceirospring.domain.ClientDTO;
import br.com.nff.bancofinanceirospring.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {

	private final ClienteRepository clientRepository;
	
	public List<ClientDTO> findAll(){
		return clientRepository.findAll();
		
	}
	
	public ClientDTO insert(ClientDTO client){
		return clientRepository.save(client);
	}
	
}
