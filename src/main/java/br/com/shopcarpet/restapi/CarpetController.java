/*
 * shopcarpet 1.0 8 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.shopcarpet.domain.carpet.Carpet;
import br.com.shopcarpet.domain.carpet.CarpetNotFoundException;
import br.com.shopcarpet.domain.carpet.ShopCarpetRepository;
import br.com.shopcarpet.domain.error.Error;
import br.com.shopcarpet.restapi.wrapper.CarpertWrapper;
import br.com.shopcarpet.restapi.wrapper.CarpetsWrapper;

/**
 * A <code>CarpetController</code> representa todos os servicos disponiveis
 * dentro do aplicacao, ela contem servicos como adicionar, deletar, atualizar e
 * consulta os carpet disponivel.
 * 
 * @author João Batista
 * @version 1.0 8 de jan de 2017
 */
@RestController
public class CarpetController {

	private final ShopCarpetRepository repository;

	@Autowired
	public CarpetController(final ShopCarpetRepository repository) {
		super();
		this.repository = repository;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String home() {
		return "Olá Spring";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CarpertWrapper> save(final @RequestBody CarpertWrapper carpertWrapper) {
		final Carpet carpet = carpertWrapper.getCarpet();
		repository.save(carpet);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CarpertWrapper> delete(final @RequestBody CarpertWrapper carpertWrapper) {
		final Carpet carpet = carpertWrapper.getCarpet();
		repository.delete(carpet);
		return new ResponseEntity<CarpertWrapper>(HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CarpertWrapper> update(final @RequestBody CarpertWrapper carpertWrapper) {
		final Carpet carpet = carpertWrapper.getCarpet();
		repository.update(carpet);
		return new ResponseEntity<CarpertWrapper>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CarpertWrapper> carpetId(final @PathVariable("id") Integer id, final UriComponentsBuilder ucb)
			throws CarpetNotFoundException {
		final Carpet carpet = repository.get(id);
		return new ResponseEntity<CarpertWrapper>(new CarpertWrapper(carpet), HttpStatus.OK);
	}

	@ExceptionHandler(CarpetNotFoundException.class)
	public ResponseEntity<Error> carpetNotFound(final CarpetNotFoundException carpetNotFoundException) {
		return new ResponseEntity<Error>(carpetNotFoundException.getError(), HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CarpetsWrapper> allCarpet() {
		return new ResponseEntity<CarpetsWrapper>(new CarpetsWrapper(repository.listAll()), HttpStatus.OK);
	}

}
