package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.AgenceModel;
import com.models.VoitureModel;
import com.models.VoyageModel;

@WebServlet("/add-voyage")
public class AddVoyage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoyageModel vym;
	private VoitureModel vm;
	private AgenceModel am;
       
    public AddVoyage() {
        super();
        this.vym = new VoyageModel();
        vm = new VoitureModel();
        am = new AgenceModel();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("voit", vm.getVoitures());
		request.setAttribute("ag", am.getAgences());
		request.setAttribute("voy", vym.getVoyages());
		this.getServletContext().getRequestDispatcher("/WEB-INF/page/add-voyage.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(this.vym.addVoyage(request)) {
			request.setAttribute("msg", "Enregistrement terminé!");
		}else {
			request.setAttribute("msg", "Erreur Enregistrement!");
		}
		doGet(request, response);
	}

}
