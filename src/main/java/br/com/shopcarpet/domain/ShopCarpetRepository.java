/*
 * shopcarpet 1.0 10 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.domain;

import java.util.List;

/**
 * A <code>ShopCarpetRepository</code> e uma interface que 
 * fornece implementacoes de crud.
 * 
 * @author João Batista
 * @version 1.0 10 de jan de 2017
 */
public interface ShopCarpetRepository {
	
	public void delete(final Carpet entity);
	
	public void update(final Carpet entity);

	public void save(final Carpet entity);

	public List<Carpet> listAll();

	public Carpet get(final long id);
	
}
