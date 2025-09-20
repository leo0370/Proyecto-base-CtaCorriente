package com.platinum.tests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.sql.Connection;
import com.platinum.ctacorriente.util.DB;
public class DbConnectionTest {
  @Test
  void conexionMySql_debeConectarse() throws Exception {
    try (Connection c = DB.get()) {
     assertNotNull(c, "La conexión no debe ser nula");
    }
  }
}
