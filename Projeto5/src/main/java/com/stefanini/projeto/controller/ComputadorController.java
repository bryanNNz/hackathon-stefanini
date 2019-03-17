package com.stefanini.projeto.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Computador;
import com.stefanini.projeto.service.ComputadorService;

@CrossOrigin
@Controller
@RequestMapping(value="/computador")
public class ComputadorController {
	
	@Autowired
	private ComputadorService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Computador>> findAll() throws TreinaException{
		List<Computador> computadores = service.findAll();
		return new ResponseEntity<>(computadores, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Computador> findById(@PathVariable("id") Long idComputador) throws TreinaException{
		Computador resp = service.findById(idComputador);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void save(@RequestBody Computador computador) throws TreinaException {	
		service.save(computador);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void update(@RequestBody Computador computador) throws TreinaException {
		service.update(computador);			
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void delete(@PathVariable("id") Long idComputador) throws TreinaException {
		service.deleteById(idComputador);
	}
}
