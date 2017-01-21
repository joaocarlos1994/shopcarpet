/*
 * shopcarpet 1.0 19 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.shopcarpet.domain.user.RoleCarpet;
import br.com.shopcarpet.domain.user.UserCarpet;
import br.com.shopcarpet.util.RepositoryShopCarpet;

/**
 * 
 * 
 * @author João Batista
 * @version 1.0 19 de jan de 2017
 */
@RestController
public class UserController {

	private final RepositoryShopCarpet<UserCarpet> repository;

	@Autowired
	public UserController(@Qualifier("userPersist") final RepositoryShopCarpet<UserCarpet> repository) {
		super();
		this.repository = repository;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String save() {
		final UserCarpet userCarpet = new UserCarpet(new Long(0), "joao_nad@hotmail.com", "$2a$04$AFuyRcqkesyz2pdfSCM89.bd1BkeIGRAdDalx0zxzXUkPFyCFhmya", RoleCarpet.ADMIN);
		repository.update(userCarpet);
		return HttpStatus.CREATED.name();
	}

}
