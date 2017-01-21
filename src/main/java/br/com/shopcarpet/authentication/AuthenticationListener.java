/*
 * @(#)AuthenticationListener.java 1.0 05/02/2016
 *
 * Copyright (c) 2016, Embraer. All rights reserved. Embraer S/A
 * proprietary/confidential. Use is subject to license terms.
 */

package br.com.shopcarpet.authentication;

import java.io.IOException;

import javax.servlet.ServletException;

/**
 * A interface <code>AuthenticationListener</code> define o m�todo a ser
 * executado ap�s uma autentica��o com sucesso na aplica��o. Cada implementa��o
 * dessa interface ter� um prop�sito espec�fico, como registrar o usu�rio no
 * cache, registrar o login no banco para efeitos de auditoria, etc.
 *
 * @author Victor Amano Izawa
 * @author Roberto Perillo
 * @version 1.0 05/02/2016
 */
public interface AuthenticationListener {

    /**
     * Executa uma a��o ap�s a autentica��o com sucesso na aplica��o.
     * 
     * @param event
     *            O evento de autentica��o.
     * @throws IOException
     *             Caso ocorra algum problema de I/O, como ao enviar um dado ao
     *             usu�rio por meio do <code>OutputStream</code> do objeto
     *             <code>HttpServletResponse</code>, presente no evento.
     * @throws ServletException
     *             Caso ocorra algum problema ao lidar com os objetos de
     *             requisi��o do usu�rio.
     */
    public void onAuthenticationSuccess(final AuthenticationEvent event) throws IOException, ServletException;
}