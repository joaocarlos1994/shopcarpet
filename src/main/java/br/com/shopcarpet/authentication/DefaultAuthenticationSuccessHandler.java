/*
 * @(#)DefaultAuthenticationSuccessHandler.java 1.0 03/09/2015
 *
 * Copyright (c) 2015, Embraer. All rights reserved. Embraer S/A
 * proprietary/confidential. Use is subject to license terms.
 */

package br.com.shopcarpet.authentication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * A classe <code>DefaultAuthenticationSuccessHandler</code> � respons�vel por
 * invocar os <i>listeners</i> do evento de autentica��o com sucesso do usu�rio
 * na aplica��o.
 *
 * @author Roberto Perillo
 * @version 1.0 03/09/2015
 */
@Component
public class DefaultAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    /** Lista de <i>handlers</i> a atuarem ap�s o <i>login</i> com sucesso */
    private final List<AuthenticationListener> authenticationListeners = new ArrayList<>();

    /**
     * Itera a lista de objetos <code>AuthenticationSuccessHandler</code>,
     * invocando o m�todo <code>onAuthenticationSuccess</code> de cada objeto.
     * Cada objeto far� uma opera��o de login com sucesso.
     * 
     * @param request
     *            O objeto que representa a requisi��o HTTP.
     * @param response
     *            O objeto que representa a resposta (onde o valor da
     *            <code>String</code> randômica ser� colocada como cabe�alho).
     * @param authentication
     *            O objeto que representa o usu�rio autenticado.
     */
    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication auth)
            throws IOException, ServletException {
        final AuthenticationEvent event = new AuthenticationEvent(response, auth);
        for (final AuthenticationListener listener : authenticationListeners) {
            listener.onAuthenticationSuccess(event);
        }
    }

    @Resource
    public void setAuthenticationListeners(final List<AuthenticationListener> authenticationListeners) {
        this.authenticationListeners.addAll(authenticationListeners);
    }
}