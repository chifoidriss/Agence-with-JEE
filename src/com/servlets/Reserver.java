package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.VoyageModel;

@WebServlet("/reserver")
public class Reserver extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoyageModel vm;
       
    public Reserver() {
        super();
        this.vm = new VoyageModel();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idVoy"));
		
		request.setAttribute("voy", vm.getById(id));
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/page/reserve.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
