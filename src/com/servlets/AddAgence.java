package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.AgenceModel;

@WebServlet({ "/AddAgence", "/add-agence", "/new-agence" })
public class AddAgence extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AgenceModel am;
	
    public AddAgence() {
        super();
        this.am = new AgenceModel();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("ag", am.getAgences());
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/page/add-agence.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(this.am.addAgence(request)) {
			request.setAttribute("msg", "Enregistrement terminé!");
		}else {
			request.setAttribute("msg", "Erreur Enregistrement!");
		}
		doGet(request, response);
	}
}
