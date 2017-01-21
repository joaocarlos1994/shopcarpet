/*
 * shopcarpet 1.0 19 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.infrastructure.persist.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.shopcarpet.domain.user.UserCarpet;

/**
 * 
 * 
 * @author João Batista
 * @version 1.0 19 de jan de 2017
 */
public interface UserRepositoryJpa extends JpaRepository<UserCarpet, Long> {
	
	@Query("SELECT u FROM UserCarpet u WHERE LOWER(u.name) = LOWER(:name)")
	public UserCarpet loadByUsername(@Param("name") final String name);
	
}
