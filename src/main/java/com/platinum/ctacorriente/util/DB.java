package com.platinum.ctacorriente.util;
import java.sql.*;
public class DB {
	private static final String URL  = "jdbc:mysql://localhost:3306/Cuentas_clientes?useSSL=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = ""; 

  public static Connection get() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASS);
  }
}
