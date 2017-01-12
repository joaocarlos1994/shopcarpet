/*
 * shopcarpet 1.0 8 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * A <code>ShopCarpetWebAppInitializer</code> representa todas configuracoes
 * as configuracoes do projeto, tanto da parte back-end como do front-end.
 * 
 * @author João Batista
 * @version 1.0 8 de jan de 2017
 */
public class ShopCarpetWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String [] {"/*"};
	}

}
