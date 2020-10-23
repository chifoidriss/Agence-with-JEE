package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.VoyageModel;

@WebServlet({ "/Home", "/home", "/acceuil" })
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoyageModel vm; 
       
    public Home() {
        super();
        vm = new VoyageModel();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("voy", vm.getVoyages());
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/page/home.jsp")
		.forward(request, response);
	}

}
