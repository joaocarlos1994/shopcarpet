/*
 * shopcarpet 1.0 8 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.restapi.serializer;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.shopcarpet.restapi.wrapper.CarpertWrapper;

/**
 * 
 * 
 * @author João Batista
 * @version 1.0 8 de jan de 2017
 */
@Component
public class CarpertSerializer extends JsonSerializer<CarpertWrapper> {

	@Override
	public void serialize(final CarpertWrapper carpet, final JsonGenerator jsonGenerator, final SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		
		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("modelo", carpet.getModelo());
		jsonGenerator.writeNumberField("comprimento", carpet.getComprimento());
		jsonGenerator.writeNumberField("largura", carpet.getLargura());
		jsonGenerator.writeStringField("cor", carpet.getColor());
		jsonGenerator.writeNumberField("preco", carpet.getPreco());
		jsonGenerator.writeEndObject();
		
	}

}
