package IT.Java;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/")
public class HelloServlet extends HttpServlet {

	private String message;

	public void init() throws ServletException
	{

		message = "Hello Denis";
	}

	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)
			throws ServletException, IOException
	{

		response.setContentType("text/html");


		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
	}

	public void destroy()
	{

	}
}
