/*
 * shopcarpet 1.0 10 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.restapi.wrapper;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.shopcarpet.domain.carpet.Carpet;
import br.com.shopcarpet.restapi.serializer.CarpetsSerialize;

/**
 * A <code>CarpetsWrapper</code> tem a responsabilidade
 * de compor um lista de objetos wrapper, assim delegando
 * para a <code>CarpetsSerialize</code> a responsabilidade
 * de serializar esta lista.
 * 
 * @author João Batista
 * @version 1.0 10 de jan de 2017
 */
@JsonSerialize(using = CarpetsSerialize.class)
public class CarpetsWrapper {
	
	private final List<Carpet> listCarpet;

	public CarpetsWrapper(final List<Carpet> listCarpet) {
		super();
		this.listCarpet = listCarpet;
	}

	public List<Carpet> getListCarpet() {
		return listCarpet;
	}
}
