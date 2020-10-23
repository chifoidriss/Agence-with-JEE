package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.PersonneModel;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonneModel pm;
       
    public Login() {
        super();
        pm = new PersonneModel();   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/page/login.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(pm.connecter(request) != null) {
			response.sendRedirect("home");
		}else {
			request.setAttribute("msg", "Erreur de connexion!");
			doGet(request, response);
		}
	}

}
