/*
 * shopcarpet 1.0 13 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.domain.error;

/**
 * A enum <code>Error</code> representa o possivel
 * que poderam ocorrer dentro da aplicação.
 * 
 * @author João Batista
 * @version 1.0 13 de jan de 2017
 */
public enum Error {
	
	NOT_FOUND_CARPET(404, "Carpet Não Encontrado");
	
	private final int statusError;
	private final String mensagem;
	
	private Error(final int statusError, final String mensagem) {
		this.statusError = statusError;
		this.mensagem = mensagem;
	}

	public int getStatusError() {
		return statusError;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	
	
}
