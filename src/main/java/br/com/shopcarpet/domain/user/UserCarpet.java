/*
 * shopcarpet 1.0 19 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * 
 * @author João Batista
 * @version 1.0 19 de jan de 2017
 */
@Entity
public class UserCarpet {
	
	@Id
	@Column(name="id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private final Long id;
	@Column
	private final String name;
	@Column
	private final String password;
	@Column
	private final RoleCarpet role;
	
	public UserCarpet(final Long id, final String name, final String password, final RoleCarpet role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
	}
	
	@SuppressWarnings("unused")
	private UserCarpet() {
		super();
		this.id = new Long(0);
		this.name = null;
		this.password = null;
		this.role = null;
	}

	public RoleCarpet getRole() {
		return role;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
}
