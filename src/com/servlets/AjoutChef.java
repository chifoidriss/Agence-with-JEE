package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.AgenceModel;
import com.models.ChefAgenceModel;

@WebServlet({ "/AjoutChef", "/ajouChef", "/register-chef" })
public class AjoutChef extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChefAgenceModel cm;
	private AgenceModel am;
       
    public AjoutChef() {
        super();
        // TODO Auto-generated constructor stub
        this.cm = new ChefAgenceModel();
        this.am = new AgenceModel();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("ag", am.getAgences());
		this.getServletContext().getRequestDispatcher("/WEB-INF/page/register-chef.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(this.cm.addChef(request)) {
			request.setAttribute("msg", "Enregistrement terminé!");
		}
		request.setAttribute("msg", "Erreur Enregistrement!");
		doGet(request, response);
	}

}
