/*
 * shopcarpet 1.0 10 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.shopcarpet.domain.Carpet;
import br.com.shopcarpet.restapi.wrapper.CarpertWrapper;
import br.com.shopcarpet.restapi.wrapper.CarpetsWrapper;

/**
 * 
 * 
 * @author João Batista
 * @version 1.0 10 de jan de 2017
 */
public class CarpetsSerialize extends JsonSerializer<CarpetsWrapper> {

	@Override
	public void serialize(final CarpetsWrapper carpetsWrapper , JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		
		jsonGenerator.writeStartArray();
		for (final Carpet carpet : carpetsWrapper.getListCarpet()) {
			final CarpertSerializer carpetSerialize = new CarpertSerializer();
			carpetSerialize.serialize(new CarpertWrapper(carpet), jsonGenerator, serializerProvider);
		}
		jsonGenerator.writeEndArray();
		
	}

}
