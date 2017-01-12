/*
 * shopcarpet 1.0 8 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A <code>Carpet</code> e uma entidade, ela contem as principais caracterias do
 * Carpet, como tamanho, cor, valor e modelo.
 * 
 * @author João Batista
 * @version 1.0 8 de jan de 2017
 */
@Entity
public class Carpet {

	@Id
	@Column(name="id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private final String modelo;
	@Column
	private final double comprimento;
	@Column
	private final double largura;
	@Column
	private final Color color;
	@Column
	private double preco;

	public void setPreco(final double preco) {
		if (preco >= 0) {
			this.preco = preco;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public Long getId() {
		return id;
	}
	
	public String getModelo() {
		return modelo;
	}

	public double getComprimento() {
		return comprimento;
	}

	public double getLargura() {
		return largura;
	}

	public Color getColor() {
		return color;
	}

	public double getPreco() {
		return preco;
	}

	public static class Builder {

		private final String modelo;
		private final double comprimento;
		private final double largura;
		private final Color color;
		private double preco;
		private Long id;

		public Builder(final String modelo, final double comprimento, final double largura, final Color color) {
			this.modelo = modelo;
			this.comprimento = comprimento;
			this.largura = largura;
			this.color = color;
		}

		public Builder preco(final double preco) {
			this.preco = preco;
			return this;
		}
		
		public Builder id(final Long id) {
			this.id = id;
			return this;
		}

		public Carpet build() {
			return new Carpet(this);
		}

	}

	private Carpet(final Builder builder) {
		this.id = builder.id;
		this.modelo = builder.modelo;
		this.comprimento = builder.comprimento;
		this.largura = builder.largura;
		this.color = builder.color;
		this.preco = builder.preco;
	}
	
	/**
	 * Construtor default definido por conta do hibernate.
	 * */
	private Carpet() {
		this.modelo = null;
		this.comprimento = 0;
		this.largura = 0;
		this.color = null;
		this.preco = 0;
	}
}
