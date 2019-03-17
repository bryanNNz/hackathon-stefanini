package com.stefanini.projeto.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	public @ResponseBody List<Computador> findAll() throws TreinaException{
		return service.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Computador> findById(@PathVariable("id") Long idComputador) throws TreinaException{
		Computador resp = service.findById(idComputador);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void save(Computador computador) throws TreinaException {
		service.save(computador);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void update(Computador computador) {
		service.update(computador);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long idComputador) {
		try {
			service.deleteById(idComputador);
			return ResponseEntity.status(202).build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
