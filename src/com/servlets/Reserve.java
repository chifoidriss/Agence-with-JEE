package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.ReservationModel;

@WebServlet("/reserve")
public class Reserve extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationModel rm;
       
    public Reserve() {
        super();
        rm = new ReservationModel();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(rm.addReserve(request)) {
			response.sendRedirect("home");
		}else {
			response.sendRedirect("reserver?idVoy="+request.getParameter("idVoy"));
		}
	}

}
