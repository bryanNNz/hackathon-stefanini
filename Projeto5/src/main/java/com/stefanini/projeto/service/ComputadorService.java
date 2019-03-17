package com.stefanini.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Computador;
import com.stefanini.projeto.model.Monitor;
import com.stefanini.projeto.repository.ComputadorRepository;

@Service
public class ComputadorService {
	
	@Autowired
	private ComputadorRepository repository;
	
	public List<Computador> findAll(){
		return (List<Computador>) repository.findAll();
	}
	
	public Computador save(Computador computador) throws TreinaException {
		if(computador.getNome().length() > 20) {
			throw new TreinaException("EXCESSO DE CARACTERES");
		}
		if(findByNome(computador.getNome()) == 1) {
			throw new TreinaException("NOME JÁ UTILIZADO");
		}
		
		List<Monitor> monitores = computador.getMonitores();

		if(monitores != null) {
			for (Monitor monitor : monitores) {
				monitor.setComputador(computador);
			}
		}
		
		return repository.save(computador);			
	}
	
	public Integer findByNome(String nome) {
		return repository.findByNome(nome);
	}
	
	public Computador findById(Long idComputador) {
		return repository.findById(idComputador).orElse(null);
	}
	
	public Computador update(Computador computador) throws TreinaException {
		Computador cp = findById(computador.getId());
		if(cp == null) {
			throw new TreinaException("REGISTRO NAO EXISTE NO BANCO");
		}
		if(computador.getNome().length() > 20) {
			throw new TreinaException("EXCESSO DE CARACTERES");
		}

		List<Monitor> monitores = computador.getMonitores();

		if(monitores != null) {
			for (Monitor monitor : monitores) {
				computador.addMonitores(monitor);
			}
		}
		
		return repository.save(computador);
	}
	
	public void deleteById(Long idComputador) throws TreinaException {
		Computador cp = findById(idComputador);
		if(cp == null) {
			throw new TreinaException("REGISTRO NAO EXISTE NO BANCO");
		}

		repository.deleteById(idComputador);
	}
}
