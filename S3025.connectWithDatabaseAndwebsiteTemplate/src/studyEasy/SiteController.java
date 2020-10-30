package studyEasy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/site")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String page=request.getParameter("page");
	    
	    switch(page) {
	    case "home":
	    	homepage(request,response);
	    	break;	}

	

	}
	public void homepage(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {
		request.setAttribute("title","HomePage");

   	request.getRequestDispatcher("index.jsp").forward(request, response);
   	
	}

}
