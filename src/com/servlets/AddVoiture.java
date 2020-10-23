package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.VoitureModel;

@WebServlet("/add-voiture")
public class AddVoiture extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoitureModel vm;
       
    public AddVoiture() {
        super();
        vm = new VoitureModel();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("voit", vm.getVoitures());
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/page/add-voiture.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(vm.addVoiture(request)) {
			request.setAttribute("msg", "Enregistrement terminé!");
		}else {
			request.setAttribute("msg", "Erreur Enregistrement!");
		}
		doGet(request, response);
	}

}
