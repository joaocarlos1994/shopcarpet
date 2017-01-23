/*
 * @(#)PreAuthenticatedAuthenticationWithToken.java 1.0 04/12/2015
 *
 * Copyright (c) 2015, . All rights reserved.  S/A
 * proprietary/confidential. Use is subject to license terms.
 */

package br.com.shopcarpet.authentication;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import br.com.shopcarpet.domain.user.UserCarpet;

/**
 * A classe <code>PreAuthenticatedAuthentication</code> representa um usu�rio
 * preautenticado na aplica��o. Ela difere da classe
 * <code>PreAuthenticatedAuthenticationToken</code> provida pelo Spring no fato
 * de que ela n�o precisa de senha nos m�todos construtores.
 *
 * @author Roberto Perillo
 * @version 1.0 04/12/2015
 */
public class PreAuthenticatedAuthentication extends PreAuthenticatedAuthenticationToken {

    private static final long serialVersionUID = 1L;

    public PreAuthenticatedAuthentication(final UserCarpet user) {
        super(user, user.getPassword(), Arrays.asList(new DefaultGrantedAuthority(user.getRole())));
        setAuthenticated(true);
    }

    @Override
    public UserCarpet getPrincipal() {
        return (UserCarpet) super.getPrincipal();
    }

    public boolean isAdmin() {
        final Collection<GrantedAuthority> authorities = getAuthorities();
        final Iterator<GrantedAuthority> it = authorities.iterator();
        while (it.hasNext()) {
            final DefaultGrantedAuthority auth = (DefaultGrantedAuthority) it.next();
            if (auth.isAdmin()) {
                return true;
            }
        }
        return false;
    }
}