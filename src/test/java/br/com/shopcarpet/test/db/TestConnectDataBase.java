/*
 * shopcarpet 1.0 10 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.test.db;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

/**
 * A <code>TestConnectDataBase</code> testa a conexao com banco
 * de dados, passando os parametros para essenciais para obter
 * a conexao.
 * 
 * @author João Batista
 * @version 1.0 10 de jan de 2017
 */
public class TestConnectDataBase {

	@Test
	public void connectDatabase() throws SQLException {
		
		final Connection conn = getConnection().getConnection();
		assertNotNull(conn);
		System.out.println(conn);
		
	}

	private DataSource getConnection() {
		final BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/carpet");
		ds.setUsername("carpet");
		ds.setPassword("carpet123");
		return ds;
	}
}
