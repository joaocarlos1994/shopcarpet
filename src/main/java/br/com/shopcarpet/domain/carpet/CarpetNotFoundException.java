/*
 * shopcarpet 1.0 13 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.domain.carpet;

import br.com.shopcarpet.domain.error.Error;

/**
 * A <code>CarpetNotFoundException</code> representa
 * 
 * @author João Batista
 * @version 1.0 13 de jan de 2017
 */
public class CarpetNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final Error error;

	public CarpetNotFoundException() {
		super();
		this.error = Error.NOT_FOUND_CARPET;
	}

	public Error getError() {
		return error;
	}
}
