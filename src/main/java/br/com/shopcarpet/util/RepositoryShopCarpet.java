/*
 * shopcarpet 1.0 19 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.util;

import java.util.List;

/**
 * A <code>ShopCarpetRepository</code> e uma interface que fornece
 * implementacoes de crud.
 * 
 * @author João Batista
 * @version 1.0 19 de jan de 2017
 */
public interface RepositoryShopCarpet<T> {

	public void delete(final T entity);

	public void update(final T entity);

	public void save(final T entity);

	public List<T> listAll();

	public T get(final long id);
	
	public T loadByUserName(final String name);

}
