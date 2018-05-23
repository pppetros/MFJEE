package com.airline.controllers;

import java.io.IOException;
import java.util.ArrayList;
//import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Gender;
import com.airline.models.Passenger;

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
		request.setAttribute("first-name", "");
		request.setAttribute("last-name", "");
		request.setAttribute("dob", "");
		request.setAttribute("gender", "");
		
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
		
		request.setAttribute("errors", false);
		
		Passenger p = new Passenger();
		
		String firstName = request.getParameter("first-name");
		System.out.println("firstname: " + firstName);
		if (firstName.length() == 0) {
			System.out.println("ERROR: Empty first name");	
			request.setAttribute("errors", true);
			request.setAttribute("firstname_error", true);
			request.setAttribute("first-name", "");
		}
		else {
			p.setFirstName(firstName);
			request.setAttribute("first-name", firstName);
		}
		
		String lastName = request.getParameter("last-name");
		System.out.println("lastname: " + lastName);
		if (lastName.length() == 0) {
			System.out.println("ERROR: Empty last name");	
			request.setAttribute("errors", true);
			request.setAttribute("lastname_error", true);
			request.setAttribute("last-name", "");
		}
		else {
			p.setLastName(lastName);
			request.setAttribute("last-name", lastName);
		}
		
		String dob_raw = request.getParameter("dob");
		String[] dobArray = dob_raw.split("\\/");
		
		String pattern = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(dob_raw);
		
		if (m.find()) {
			String day =dobArray[0];
			String month =dobArray[1];
			String year =dobArray[2];
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, Integer.parseInt(year));
			cal.set(Calendar.MONTH, Integer.parseInt(month)-1);
			cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
			
			Date dob = cal.getTime();
			System.out.println("dob: " + dob);
			
			p.setDob(dob);
			request.setAttribute("dob", dob_raw);
		}
		else {
			System.out.println("ERROR: Invalid date of birth");	
			request.setAttribute("errors", true);
			request.setAttribute("date_format_error", true);
			if (dob_raw.length() == 0) {
				request.setAttribute("dob", "");
			}
			else {
				request.setAttribute("dob", dob_raw);
			}
		}
		
		String gender = request.getParameter("gender");
		System.out.println("gender: " + gender);
		p.setGender(Gender.valueOf(gender));
		request.setAttribute("gender", gender);
		
		
		if ((Boolean) request.getAttribute("errors")) {
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");
			view.forward(request, response);
		}
		else {
			ServletContext sc = this.getServletContext();	
			
			synchronized (this) {
				ArrayList<Passenger> pList = (ArrayList<Passenger>) sc.getAttribute("passengers");
				pList.add(p);
				sc.setAttribute("passengers", pList);
			}
			response.sendRedirect("");
		}
	
		
	}

}
