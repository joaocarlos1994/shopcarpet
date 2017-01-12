/*
 * shopcarpet 1.0 10 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.restapi.deserializer;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.shopcarpet.domain.Carpet;
import br.com.shopcarpet.domain.Color;
import br.com.shopcarpet.restapi.wrapper.CarpertWrapper;

/**
 * 
 * 
 * @author João Batista
 * @version 1.0 10 de jan de 2017
 */
@Component
public class CarpertDeserializer extends JsonDeserializer<CarpertWrapper> {

	@Override
	public CarpertWrapper deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		
		final ObjectCodec oc = jsonParser.getCodec();
		final JsonNode node = oc.readTree(jsonParser);
		
		final Carpet carpet = new Carpet.Builder(node.get("modelo").asText(), node.get("comprimento").asDouble(), 
				node.get("largura").asDouble(), Color.valueOf(node.get("cor").asText()))
				.preco(node.get("preco").asDouble()).id(node.get("id").asLong()).build();
		
		final CarpertWrapper carpertWrapper = new CarpertWrapper(carpet);
		
		return carpertWrapper;
	}

}
