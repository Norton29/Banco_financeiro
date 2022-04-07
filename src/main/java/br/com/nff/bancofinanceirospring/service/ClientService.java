package br.com.nff.bancofinanceirospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.nff.bancofinanceirospring.domain.Client;
import br.com.nff.bancofinanceirospring.repository.ClienteRepository;
import br.com.nff.bancofinanceirospring.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {

	private final ClienteRepository clientRepository;
	
	public List<Client> findAll(){
		return clientRepository.findAll();
		
	}
	public Client findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		
	}
	
	public Client insert(Client client){
		return clientRepository.save(client);
	}
	
	public void delete(Long id) {
		clientRepository.deleteById(id);
		
		
	}
	
}
