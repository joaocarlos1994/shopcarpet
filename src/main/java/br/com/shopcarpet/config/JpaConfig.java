/*
 * shopcarpet 1.0 10 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * A <code>JpaConfig</code> contem a configuracao dos bean do Jpa e de acesso ao
 * banco de dados.
 * 
 * @author João Batista
 * @version 1.0 10 de jan de 2017
 */
@Configuration
public class JpaConfig {

	/**
	 * Este bean criado controla a conexao com banco de dados, dialeto.
	 * Este bean esta associado a contexto do Spring, ou seja
	 * todas sessoes serão controlados pelo spring.
	 * */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource,
			final JpaVendorAdapter jpaVendorAdapter) {
		final LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);
		emfb.setJpaVendorAdapter(jpaVendorAdapter);
		emfb.setPackagesToScan("br.com.shopcarpet.domain");
		return emfb;
	}

	/**
	 * Configuracao opcao do hibernate como o dialeto.
	 * */
	@Bean
	public JpaVendorAdapter getJpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		return adapter;
	}

	/**
	 * O Bean persistenceTranslation e um bean declarado para adicionar
	 * exception de transacao, convertendo assim em exececoes genericas,
	 * independente do banco de dados.
	 */
	@Bean
	public BeanPostProcessor persistenceTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	/**
	 * A metodo dataSource retorna a conexao do banco de dados.
	 */
	@Bean
	public DataSource getDataSource() {
		final BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/carpet");
		ds.setUsername("carpet");
		ds.setPassword("carpet123");
		return ds;
	}

	@Bean
	public PersistenceAnnotationBeanPostProcessor paPostProcessor() {
		return new PersistenceAnnotationBeanPostProcessor();
	}

	/**
	 * Configura a transacao do banco de dados. Por default o Spring Data
	 * precisa desse bean para executar operacoes basicas no banco de dados.
	 * */
	@Bean
	public JpaTransactionManager transactionManager() {
		return new JpaTransactionManager(); // does this need an emf???
	}
}
