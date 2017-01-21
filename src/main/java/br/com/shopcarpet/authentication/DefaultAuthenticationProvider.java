/*
 * @(#)DefaultAuthenticationProvider.java 1.0 3 de out de 2016
 *
 * Copyright (c) 2016,  Ltda. All rights reserved. 
 * proprietary/confidential. Use is subject to license terms.
 */

package br.com.shopcarpet.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.shopcarpet.domain.user.UserCarpet;
import br.com.shopcarpet.util.RepositoryShopCarpet;



/**
 * Class comments go here...
 *
 * @author Roberto Perillo
 * @version 1.0 3 de out de 2016
 */
@Component
public class DefaultAuthenticationProvider extends DaoAuthenticationProvider {

    private final RepositoryShopCarpet<UserCarpet> repository;

    @Autowired
    public DefaultAuthenticationProvider(@Qualifier("userPersist") final RepositoryShopCarpet<UserCarpet> repository, final UserDetailsService service, final PasswordEncoder encoder) {
        super();
        setUserDetailsService(service);
        setPasswordEncoder(encoder);
        this.repository = repository;
    }

    @Override
    protected Authentication createSuccessAuthentication(final Object principal, final Authentication authentication, final UserDetails userDetails) {
        final UserDetails principalContext = (UserDetails) principal;
    	return new PreAuthenticatedAuthentication(repository.loadByUserName(principalContext.getUsername()));
    }
}