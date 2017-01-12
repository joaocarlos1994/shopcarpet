/*
 * shopcarpet 1.0 11 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.infrastructure.persist;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.shopcarpet.domain.Carpet;

/**
 * A <code>CarpetRepository</code> e uma interface criada
 * para extender a interface <code>JpaRepository</code>
 * obtendo assim todos os metodos de crud para trabalhar com
 * Spring Data.
 * 
 * @author João Batista
 * @version 1.0 11 de jan de 2017
 */
public interface CarpetRepository extends JpaRepository<Carpet, Long> {

}
