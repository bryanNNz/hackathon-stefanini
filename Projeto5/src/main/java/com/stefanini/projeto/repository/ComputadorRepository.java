package com.stefanini.projeto.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.stefanini.projeto.model.Computador;

public interface ComputadorRepository extends CrudRepository<Computador, Long>{
	
	@Query("SELECT COUNT(c.nome) FROM Computador c WHERE c.nome = :nome")
	public Integer findByNome(@Param("nome") String nome);
	
}
