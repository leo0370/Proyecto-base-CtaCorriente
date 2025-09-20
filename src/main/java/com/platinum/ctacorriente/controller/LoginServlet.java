package com.platinum.ctacorriente.controller;
import com.platinum.ctacorriente.dao.EjecutivoDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private final EjecutivoDAO dao = new EjecutivoDAO();
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String rut = req.getParameter("rut");
    String nombre = req.getParameter("nombre");
    if (dao.validarLogin(rut, nombre)) {
      req.getSession().setAttribute("ejecutivo", rut);
      resp.sendRedirect("home.jsp");
    } else {
      req.setAttribute("error", "Credenciales inválidas");
      req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
  }
}
