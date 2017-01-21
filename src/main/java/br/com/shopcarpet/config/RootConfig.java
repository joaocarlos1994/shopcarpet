/*
 * shopcarpet 1.0 8 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * A <code>RootConfig</code> representa as configuracoes essenciais para
 * aplicacao, esta confiuracao esta diretamente relacionada a core da aplicacao,
 * nao expondo confiurancao relacionadas ao front-end do projeto.
 * 
 * @author João Batista
 * @version 1.0 8 de jan de 2017
 */
@Configuration
@ComponentScan(basePackages = { "br.com.shopcarpet.infrastructure.persist", "br.com.shopcarpet.authentication"})
@EnableJpaRepositories(basePackages = { "br.com.shopcarpet.infrastructure.persist" })
@Import({ JpaConfig.class, SecurityConfig.class })
@PropertySource("classpath:authentication.properties")
public class RootConfig {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
