package com.bmi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmi.service.AgeService;

/**
 * Servlet implementation class AgeCalculator
 */
@WebServlet("/AgeCalculator")
//Sample:
//localhost:9090/AgeCalculator?name=DummyName&dob=1999-12-30
public class AgeCalculatorNotInUse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AgeCalculatorNotInUse() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// add the code as per the requirement
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");

		String message = new AgeService().calculateAge(dob);

		request.setAttribute("name", name);
		request.setAttribute("message", message);
		request.setAttribute("check", "true");
		RequestDispatcher dispatcher = request.getRequestDispatcher("bmiStatus.jsp");

		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
