/*
 * shopcarpet 1.0 19 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.infrastructure.persist.user;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.shopcarpet.domain.user.UserCarpet;
import br.com.shopcarpet.util.RepositoryShopCarpet;

/**
 * 
 * 
 * @author João Batista
 * @version 1.0 19 de jan de 2017
 */
@Repository
public class UserPersist implements RepositoryShopCarpet<UserCarpet> {

	private final UserRepositoryJpa userRepositoryJpa;
	
	@Autowired
	public UserPersist(final UserRepositoryJpa userRepositoryJpa) {
		super();
		this.userRepositoryJpa = userRepositoryJpa;
	}

	@Override
	public void delete(final UserCarpet entity) {
		userRepositoryJpa.delete(entity);
	}

	@Override
	public void update(final UserCarpet entity) {
		userRepositoryJpa.saveAndFlush(entity);
	}

	@Override
	public void save(final UserCarpet entity) {
		userRepositoryJpa.save(entity);
	}

	@Override
	public List<UserCarpet> listAll() {
		return Collections.unmodifiableList(userRepositoryJpa.findAll());
	}

	@Override
	public UserCarpet get(final long id) {
		final UserCarpet user = userRepositoryJpa.findOne(id);
		return user;
	}

	@Override
	public UserCarpet loadByUserName(final String name) {
		final UserCarpet user = userRepositoryJpa.loadByUsername(name);
		return user;
	}

}
