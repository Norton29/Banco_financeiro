package br.com.nff.bancofinanceirospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.nff.bancofinanceirospring.domain.Client;
import br.com.nff.bancofinanceirospring.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {

	private final ClienteRepository clientRepository;
	
	public List<Client> findAll(){
		return clientRepository.findAll();
		
	}
	
	public Client insert(Client client){
		return clientRepository.save(client);
	}
	
	public void delete(Long id) {
		clientRepository.deleteById(id);
		
		
	}
	
}
