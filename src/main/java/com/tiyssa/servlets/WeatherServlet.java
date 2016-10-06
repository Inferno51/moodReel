package com.tiyssa.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tiyssa.dao.GenreDAO;
import com.tiyssa.entity.Genres;

/**
 * Servlet implementation class FootBallServlet
 */
@WebServlet("/WeatherServlet")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Genres searchDb = new Genres();
		
		
		searchDb.setCondition(request.getParameter("Conditiont"));
		
		
		
		
	//	GenreDAO.writeToDB(searchDb);
		request.getRequestDispatcher("FootBall.html").forward(request, response);
	}
	
	
}