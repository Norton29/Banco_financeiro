package br.com.nff.bancofinanceirospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.nff.bancofinanceirospring.domain.Client;


public interface ClienteRepository extends JpaRepository<Client, Long> {
	
	@Query(value = "select * from client where name = @name" , nativeQuery = true )
	Client findByName(@Param("name") String name);

}
