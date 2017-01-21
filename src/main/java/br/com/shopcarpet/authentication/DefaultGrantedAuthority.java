/*
 * @(#)CMSGrantedAuthority.java 1.0 22/03/2016
 *
 * Copyright (c) 2016,  All rights reserved.  S/A
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.authentication;


import org.springframework.security.core.GrantedAuthority;

import br.com.shopcarpet.domain.user.RoleCarpet;


/**
 * A classe <code>CMSGrantedAuthority</code> representa uma autoridade (em nivel
 * de Spring Security) de um usuario na aplicacao. Um objeto
 * <code>CMSGrantedAuthority</code> contem um objeto <code>Authority</code>, que
 * e o que determina a area e o perfil do usuario.
 *
 * @author Roberto Perillo
 * @version 1.0 22/03/2016
 */
public class DefaultGrantedAuthority implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private final RoleCarpet role;

    public DefaultGrantedAuthority(final RoleCarpet role) {
        super();
        this.role = role;
    }

    /** {@inheritDoc} */
    @Override
    public String getAuthority() {
        return "ROLE_" + role.name();
    }

    public boolean isAdmin() {
        return role.isAdmin();
    }
}