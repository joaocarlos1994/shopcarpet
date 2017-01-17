/*
 * shopcarpet 1.0 10 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.infrastructure.persist;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import br.com.shopcarpet.domain.carpet.Carpet;
import br.com.shopcarpet.domain.carpet.CarpetNotFoundException;
import br.com.shopcarpet.domain.carpet.ShopCarpetRepository;

/**
 * A <code>ShopCarpetPersist</code> e um classe que
 * segue o pattern adapter, onde ela implementa a 
 * <code>ShopCarpetRepository</code> e compoe a 
 * <code>CarpetRepository</code>.
 * 
 * @author João Batista
 * @version 1.0 10 de jan de 2017
 */
@Repository
public class ShopCarpetPersist implements ShopCarpetRepository {

	@Autowired
	private CarpetRepository repositoryJpa;

	@Override
	public void delete(final Carpet entity) {
		repositoryJpa.delete(entity);
	}

	@Override
	public void update(final Carpet entity) {
	}

	@Override
	public void save(final Carpet entity) {
		repositoryJpa.save(entity);
	}

	@Override
	public List<Carpet> listAll() {
		final List<Carpet> listCarpet = repositoryJpa.findAll();
		return Collections.unmodifiableList(listCarpet);
	}

	@Override
	public Carpet get(final long id) {
		final Carpet carpet = repositoryJpa.findOne(Long.valueOf(id));
		if (carpet == null) throw new CarpetNotFoundException();
		return carpet;
	}
}
