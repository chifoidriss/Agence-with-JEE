package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.ChefAgenceModel;


@WebServlet("/connectChef")
public class ConnectChef extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChefAgenceModel cam;
       
    public ConnectChef() {
        super();
        cam = new ChefAgenceModel();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/page/connect-chef.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(cam.connecter(request) != null) {
			response.sendRedirect("admin");
		}else {
			request.setAttribute("msg", "Erreur de connexion!");
			doGet(request, response);
		}
	}

}
