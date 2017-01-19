/*
 * shopcarpet 1.0 18 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * A <code>SecurityConfig</code> contem os bean de configuracao
 * do spring security, extendo o <code>WebSecurityConfigurerAdapter</code>
 * contribuindo assim para uma melhro configuracao do spring security,
 * 
 * @author João Batista
 * @version 1.0 18 de jan de 2017
 */
@Configuration
@EnableWebSecurity	// Ativa o web security
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/**
	 * Metodo usado para configurar Spring Filter Chain
	 * */
	@Override
	public void configure(final WebSecurity web) throws Exception {
		super.configure(web);
	}
	
	/**
	 * Metodo para configurar como as solicitacoes sao 
	 * protegidas por interceptadores.
	 * */
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		super.configure(http);
	}
	
	/**
	 * Metodo usado para confiruacao do user-details services, ou seja,
	 * para configurar a authenticacao do user-details.
	 * */
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user").password("password").roles("USER").and()
		.withUser("admin").password("password").roles("USER", "ADMIN");
	}
	
}
