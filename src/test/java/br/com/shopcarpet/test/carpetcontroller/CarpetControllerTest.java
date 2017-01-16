/*
 * shopcarpet 1.0 13 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.test.carpetcontroller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
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
@ContextConfiguration(classes = {}) // Indica as classes para a configuracao do ApplicationContext.
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

}
