package com.template.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.template.beans.Person;
import com.template.dao.emaildb;


/**
 * Servlet implementation class emailServlet
 */
@WebServlet("/emailServlet")
public class emailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private emaildb dao = new emaildb();
    
    
    
    public emailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String toDo = request.getParameter("name");
    	
    	if(toDo.equalsIgnoreCase("View")) {
    		view(request, response);
    	}
    	
    	else if(toDo.equalsIgnoreCase("edit")) {
    		edit(request, response);
    	}
    	
    	else if(toDo.equalsIgnoreCase("delete")) {
    		delete(request, response);
    	}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		int result = dao.delete(request.getParameter("email"));
		List<Person> p = dao.view();
		request.setAttribute("person", p);
		RequestDispatcher d = request.getRequestDispatcher("email.jsp");
		d.forward(request, response);
	}


	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		List<Person> p = dao.view();
		request.setAttribute("person", p);
		RequestDispatcher d = request.getRequestDispatcher("email.jsp");
		d.forward(request, response);
	}


	private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Person> p = dao.view();
		request.setAttribute("person", p);
		System.out.println("Hello Servlet! ");
		RequestDispatcher d = request.getRequestDispatcher("email.jsp");
		d.forward(request, response);		
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String to_Do = request.getParameter("name");
    	
    	if(to_Do.equalsIgnoreCase("addEmail")) {
    		addEmail(request, response);
    	}
    	
    	else if(to_Do.equalsIgnoreCase("addname")) {
    		addName(request, response);
    	}
    	
	}

	private void addName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("email")+"....................</h1>");
		Person new_person = new Person(request.getParameter("email"), request.getParameter("ename"), request.getParameter("fee"));
		int result = dao.addName(new_person);
		List<Person> p = dao.view();
		request.setAttribute("person", p);
		System.out.println("Hello Servlet! ");
		RequestDispatcher d = request.getRequestDispatcher("email.jsp");
		d.forward(request, response);
	}


	private void addEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Person new_person = new Person(request.getParameter("email"));
			int result = dao.addEmail(new_person);
			System.out.println(result);
			RequestDispatcher d = request.getRequestDispatcher("index.jsp");
			d.forward(request, response);
	}

}
