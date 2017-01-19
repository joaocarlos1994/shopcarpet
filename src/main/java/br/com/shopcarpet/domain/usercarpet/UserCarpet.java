/*
 * shopcarpet 1.0 18 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.domain.usercarpet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * 
 * @author João Batista
 * @version 1.0 18 de jan de 2017
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
	@OneToMany
	private final List<AuthorityCarpet> authority;
	
	public UserCarpet(final Long id, final String name, final String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.authority = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public List<AuthorityCarpet> getAuthority() {
		return Collections.unmodifiableList(authority);
	}
	
	
	
}
