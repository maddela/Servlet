package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rafi.db.Connector;

import com.google.gson.Gson;
import com.model.PersonData;

public class AngularJsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AngularJsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PersonData personData = new PersonData('1', "Hello", "test");
		personData.setFirstName("Mohaideen");
		personData.setLastName("Jamil");

		String json = new Gson().toJson(personData);
		response.setContentType("application/json");
		response.getWriter().write(json);
		
		
		
	}
	
	

	
	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	String emaiId = request.getParameter("emailId");

	String phonenum = request.getParameter("phonenum");
	String gender = request.getParameter("gender");
	System.out.println("username is " +userName);
	System.out.println("password is " +password);
	System.out.println("emailId is " +emaiId);
	System.out.println("phonenum is " +phonenum);
	System.out.println("gender is " +gender);

	try {
		Connector.insertUser(userName,password, emaiId,phonenum,gender);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	System.out.println("going to registration");
    response.sendRedirect("http://localhost:8080/servlet/signup.html");

	
	}
	
	
}
