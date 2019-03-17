package com.stefanini.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Computador;
import com.stefanini.projeto.repository.ComputadorRepository;

@Service
public class ComputadorService {
	
	@Autowired
	private ComputadorRepository repository;
	
	public List<Computador> findAll(){
		return (List<Computador>) repository.findAll();
	}
	
	public Computador save(Computador computador) throws TreinaException {
		boolean cp = repository.existsById(computador.getId());
		
		if(!cp) {
			throw new TreinaException("COMPUTADOR EXISTENTE");
		}
		
		return repository.save(computador);
	}
	
	public Computador findById(Long idComputador) {
		return repository.findById(idComputador).orElse(null);
	}
	
	public Computador update(Computador computador) {
		return repository.save(computador);
	}
	
	public void deleteById(Long idComputador) {
		
		repository.deleteById(idComputador);
	}
}
