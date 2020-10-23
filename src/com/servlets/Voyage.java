package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.ReservationModel;
import com.models.VoyageModel;

@WebServlet({ "/Voyage", "/voyage" })
public class Voyage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationModel rm;
	private VoyageModel vm;
       
    public Voyage() {
        super();
        this.vm = new VoyageModel();
        rm = new ReservationModel();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idVoy = Integer.parseInt(request.getParameter("idVoy"));
		
		request.setAttribute("voy", vm.getById(idVoy));
		request.setAttribute("ress", rm.getReservations(idVoy));
		
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/page/voyage.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
