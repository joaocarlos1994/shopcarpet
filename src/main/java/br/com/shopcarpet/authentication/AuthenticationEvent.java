/*
 * @(#)AccountAuthenticationEvent.java 1.0 05/02/2016
 *
 * Copyright (c) 2016, Embraer. All rights reserved. Embraer S/A
 * proprietary/confidential. Use is subject to license terms.
 */

package br.com.shopcarpet.authentication;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;

import br.com.shopcarpet.domain.user.UserCarpet;

/**
 * A classe <code>AccountAuthenticationEvent</code> representa o evento de
 * autentica��o realizada com sucesso na aplica��o. Pelo fato de que os
 * <i>listeners</i> desse evento podem lidar com a requisi��o HTTP, inst�ncias
 * dessa classe tamb�m tem os objetos que representam a requisi��o e a resposta
 * HTTP.
 *
 * @author Roberto Perillo
 * @version 1.0 05/02/2016
 */
public class AuthenticationEvent extends AuthenticationSuccessEvent {

    private static final long serialVersionUID = 1L;
    private final HttpServletResponse response;

    public AuthenticationEvent(final HttpServletResponse response, final Authentication authentication) {
        super(authentication);
        this.response = response;
    }

    @Override
    public PreAuthenticatedAuthentication getAuthentication() {
        return (PreAuthenticatedAuthentication) super.getAuthentication();
    }

    public String getUsername() {
        return getUser().getName();
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    private UserCarpet getUser() {
        return getAuthentication().getPrincipal();
    }
}