/*
 * @(#)DefaultUserDetails.java 1.0 1 de out de 2016
 *
 * Copyright (c) 2016, VoxPMO Ltda. All rights reserved. VoxPMO
 * proprietary/confidential. Use is subject to license terms.
 */

package br.com.shopcarpet.authentication;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.shopcarpet.domain.user.UserCarpet;
import br.com.shopcarpet.util.RepositoryShopCarpet;

/**
 * Class comments go here...
 *
 * @author Joao Carlos
 * @version 1.0 19 de jan de 2017
 */
@Component
public class DefaultUserDetails implements UserDetailsService {
	
	private final RepositoryShopCarpet<UserCarpet> repository;
	
	@Autowired
	public DefaultUserDetails(@Qualifier("userPersist") final RepositoryShopCarpet<UserCarpet> repository) {
		super();
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(final String name) throws UsernameNotFoundException {
		
		final UserCarpet user = repository.loadByUserName(name);
		final Collection<GrantedAuthority> authorities = new ArrayList<>(1);
		
		if (user != null) {
			authorities.add(new DefaultGrantedAuthority(user.getRole()));
		}
		
		
		return new User(user.getName(), user.getPassword(), authorities);
	}

}