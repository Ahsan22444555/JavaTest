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


@WebServlet("/sendEmail")
public class sendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private emaildb dao = new emaildb();
	
    public sendEmail() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultMessage = "";
		List<Person> p = dao.view();
        try {
        	for(int i=0; i<p.size(); i++){
        		send.sendEmail("arshadbelal1@gmail.com", "belal8651@", p.get(i).getEmail(), "Test",
                        "This is java mail api Test\nHello " + p.get(i).getName() + ",\nTotal fee charged is Rs. " + p.get(i).getFee());
        	}
             
            System.out.println("Hello send Mail Server!");
            resultMessage = "The email was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Hello.....................................12");
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
    		request.setAttribute("person", p);
    		System.out.println("Hello Servlet! ");
    		request.setAttribute("message", resultMessage);
    		RequestDispatcher d = request.getRequestDispatcher("email.jsp");
    		d.forward(request, response);
        }
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
