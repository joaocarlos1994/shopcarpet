/*
 * shopcarpet 1.0 8 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.shopcarpet.domain.carpet.Carpet;
import br.com.shopcarpet.restapi.deserializer.CarpertDeserializer;
import br.com.shopcarpet.restapi.serializer.CarpertSerializer;

/**
 * A <code>CarpertWrapper</code> encapsula um objeto Carpet,
 * onde esta classe tera a reponsabilidade de delegar para
 * classe reponsavel pela mplementacao do serializer e
 * deserializer. 
 * 
 * @author João Batista
 * @version 1.0 8 de jan de 2017
 */
@JsonSerialize(using = CarpertSerializer.class)
@JsonDeserialize(using = CarpertDeserializer.class)
public class CarpertWrapper {
	
	private final Carpet carpet;

	public CarpertWrapper(final Carpet carpet) {
		super();
		this.carpet = carpet;
	}
	
	public String getModelo() {
		return carpet.getModelo();
	}
	
	public double getComprimento() {
		return carpet.getComprimento();
	}
	
	public double getLargura() {
		return carpet.getLargura();
	}
	
	public String getColor() {
		return carpet.getColor().name();
	}
	
	public double getPreco() {
		return carpet.getPreco();
	}

	public Carpet getCarpet() {
		return carpet;
	}	
}
