package com.platinum.ctacorriente.dao;
import com.platinum.ctacorriente.util.DB;
import java.sql.*;
public class EjecutivoDAO {
  public boolean validarLogin(String rutEjecutivo, String nombre) {
    String sql = "SELECT 1 FROM ejecutivo WHERE rutEjecutivo=? AND nombre=?";
    try (Connection c = DB.get(); PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setString(1, rutEjecutivo);
      ps.setString(2, nombre);
      try (ResultSet rs = ps.executeQuery()) {
        return rs.next();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
