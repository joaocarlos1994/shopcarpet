/*
 * shopcarpet 1.0 8 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.shopcarpet.domain.Carpet;
import br.com.shopcarpet.domain.ShopCarpetRepository;
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
	public String save(final @RequestBody CarpertWrapper carpertWrapper) {
		final Carpet carpet = carpertWrapper.getCarpet();
		repository.save(carpet);
		return "Sucess";
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String delete(final @RequestBody CarpertWrapper carpertWrapper) {
		final Carpet carpet = carpertWrapper.getCarpet();
		repository.delete(carpet);
		return "Sucess";
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String update(final @RequestBody CarpertWrapper carpertWrapper) {
		final Carpet carpet = carpertWrapper.getCarpet();
		repository.update(carpet);
		return "Sucess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CarpertWrapper carpetId(final @PathVariable("id") Integer id) {
		final Carpet carpet = repository.get(id);
		return new CarpertWrapper(carpet);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CarpetsWrapper allCarpet() {
		return new CarpetsWrapper(repository.listAll());
	}

}
