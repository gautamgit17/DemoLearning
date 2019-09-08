package com.profile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
@WebServlet(name = "SpringServlet", urlPatterns = "/employeeServlet")
public class SpringServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		    {
		       
		 SpringJosnParameter josnParameter = new SpringJosnParameter("TestServlet", 2, "Engineer");
		 String SpringJsonClass = this.gson.toJson(josnParameter);
		 resp.setContentType("application/json");
		 resp.setCharacterEncoding("UTF-8");
		    }

}
