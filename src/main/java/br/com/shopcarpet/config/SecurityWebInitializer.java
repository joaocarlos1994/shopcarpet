/*
 * shopcarpet 1.0 18 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.config;

/**
 * A <code>SecurityWebInitializer</code> representa o filter 
 * DelegatingFilterProxy onde ele ira receber todas requisicoes
 * e ira delegar para o filter SpringSecurityFilterChain, onde
 * ele contera uma lista de filter que atendera a requisicao.
 * 
 * Obs.: A configuracao desta classe nao e necessaria, devido
 * a <code>ShopCarpetWebAppInitializer</code> ja configurar
 * esse filtro na de subir o contexto.
 * 
 * SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer
 * devido a ambiguidade na hora de subir o contexto do spring security nao
 * sera extendida a classe por conta dela implementar a interface
 * <code>WebApplicationInitializer</code>.
 * 
 * @author João Batista
 * @version 1.0 18 de jan de 2017
 */
public class SecurityWebInitializer {

}
