/*
 * shopcarpet 1.0 19 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.domain.user;

/**
 * 
 * 
 * @author João Batista
 * @version 1.0 19 de jan de 2017
 */
public enum RoleCarpet {
	USER, ADMIN;
	
	public boolean isAdmin() {
		if(this.equals(ADMIN)) return true;
		return false;
	}
	
}
