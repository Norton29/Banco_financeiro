package br.com.nff.bancofinanceirospring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
		Optional<Client> client = clientRepository.findById(id);
		return client.orElseThrow(() -> new ResourceNotFoundException(id));
		
	}
	
	public Client findByName(String name) {
		Client client = clientRepository.findByName(name);
		return client;
		
	}
	
	
	public Client insert(Client client){
		return clientRepository.save(client);
	}
	
	public void delete(Long id) {
		clientRepository.deleteById(id);
		
		
	}	
	
	public Client update(Long id, Client obj) {
		try {
		Client entity = clientRepository.getReferenceById(id);
		updateData(entity, obj);
		return clientRepository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
	
	private void updateData(Client entity, Client client) {
		entity.setName(client.getName());
		entity.setLastName(client.getLastName());
		entity.setBirthDate(client.getBirthDate());
		entity.setSexo(client.getSexo());
		entity.setIdDoc(client.getIdDoc());
		entity.setMaritalStatus(client.getMaritalStatus());
		entity.setNationality(client.getNationality());
	}
	
}
