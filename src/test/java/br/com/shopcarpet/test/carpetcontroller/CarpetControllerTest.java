/*
 * shopcarpet 1.0 13 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.test.carpetcontroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.shopcarpet.config.WebConfig;
import br.com.shopcarpet.domain.carpet.Carpet;
import br.com.shopcarpet.domain.carpet.Color;
import br.com.shopcarpet.infrastructure.persist.ShopCarpetPersist;
import br.com.shopcarpet.restapi.wrapper.CarpertWrapper;
import br.com.shopcarpet.test.db.DbEnvironment;
import br.com.shopcarpet.test.util.DefaultComparatorCarpet;

/**
 * A <code>CarpetControllerTest</code> representa uma classe de teste do
 * recursos do carpet.
 * 
 * @author João Batista
 * @version 1.0 13 de jan de 2017
 */
@RunWith(SpringJUnit4ClassRunner.class) // Indica que a classe deve usar as instalações do Spring JUnit.
/**
 * Usada para declarar que o ApplicationContext para um teste de integração deve
 * ser um WebApplicationContext.
 */
@WebAppConfiguration
@ContextConfiguration(classes = {DbEnvironment.class, WebConfig.class, ShopCarpetPersist.class}) // Indica as classes para a configuracao do ApplicationContext.
public class CarpetControllerTest {

	/**
	 * WebApplicationContext usada para fornecer configuração para uma aplicação
	 * web, vincunlando assim atraves do metodo getServletContext() a raiz no
	 * processo de inicializacao.
	 */
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		final DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		this.mockMvc = builder.build();
	}
	
	@Test
	public void salvar() throws Exception {
		final Carpet carpet = new Carpet.Builder("Tapete Teste", 10.0, 10.0, Color.BRANCO).preco(100.0).id(new Long(0)).build();
		this.mockMvc.perform(post("/").content(convertObjectToJson(new CarpertWrapper(carpet))).contentType(MediaType.APPLICATION_JSON_VALUE));
		final MvcResult result = this.mockMvc.perform(get("/4")).andReturn();
		JSONAssert.assertEquals(convertObjectToJson(new CarpertWrapper(carpet)), result.getResponse().getContentAsString(), new DefaultComparatorCarpet("id"));
	}
	
	@Test
	public void buscaPorId() throws Exception {
		final MvcResult result = this.mockMvc.perform(get("/1")).andReturn();
		final Carpet carpet = new Carpet.Builder("Tapete Sala de Estar", 2.5, 1.5, Color.VERDE).preco(65).id(new Long(1)).build();
		
		JSONAssert.assertEquals(convertObjectToJson(new CarpertWrapper(carpet)), result.getResponse().getContentAsString(), true);
	}
	
	/**
	 * Metodo pega um wrapper e transforma em um objeto json.
	 * @param object Um objeto wrapper usado para serializer
	 * @throws JsonProcessingException Erro no processo de serializer do wrapper passado 
	 * */
	private String convertObjectToJson(final Object object) throws JsonProcessingException {
		final ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
