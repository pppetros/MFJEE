package com.airline.controllers;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPassenger
 */
@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPassenger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<html><head><title>Hello</title><meta charset=\"utf-8\"></head><body>");
//		
//		out.println("<h2>Καλώς ήρθατε/Welcome Aboard!</h2>");
//		out.println("<p>Δοκιμή Git: OK</p>");
//		out.println("<p>Kala pame, Ελληνικά δεν βλέπω.5</p>");
//		
//		out.println("</body></html>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		String firstName = request.getParameter("first-name");
		
		
		String lastName = request.getParameter("last-name");
		
		String dob_raw = request.getParameter("dob");
		String[] dobArray = dob_raw.split("\\/");
		String day =dobArray[0];
		String month =dobArray[1];
		String year =dobArray[2];
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		cal.set(Calendar.MONTH, Integer.parseInt(month)-1);
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
		
		Date dob = cal.getTime();
		
		String gender = request.getParameter("gender");
		
//		System.out.println(firstName);
//		System.out.println(lastName);
//		System.out.println(dob);
//		System.out.println(gender);
		
	}

}
