package studyEasy;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.studyEasy.Model.UsersModel;
import org.studyEasy.entity.User;


@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID=1L;
	@Resource(name="jdbc/project")
	private DataSource dataSource;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String page=request.getParameter("page");
    
    switch(page) {
  
    	
    case "listusers":
    	listUsers(request,response);
    	break;
    case "adduser":
    	addUserFormLoader(request,response);
    	break;
    case "updateUser":
    	UpdateUserFormLoader(request,response);
    	break;
    case "deleteUser":
    	deleteUser(Integer.parseInt(request.getParameter("usersId")));
    	listUsers(request, response);
    	break;
    default: 
    	errorpage(request,response);
    
    }
    
	
	
	
	
	}
	private void deleteUser(int usersID) {
		new UsersModel().deleteUser(dataSource, usersID);
		return;
	}
	private void UpdateUserFormLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title","Update Users");
    	request.getRequestDispatcher("updateUser.jsp").forward(request, response);
    	
		
	}
	@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		 throws ServletException, IOException {
		String operation=request.getParameter("form");
		operation=operation.toLowerCase();
		switch(operation) {
		case "adduseroperation":
		User newUser=new User(request.getParameter("username"), request.getParameter("email"));
			try {
				addUserOperation(newUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		listUsers(request, response);
		break;
		case "updateuseroperation":
			User updatedUser=new User(Integer.parseInt(request.getParameter("usersId")), request.getParameter("username"), request.getParameter("email"));
			try {
				updateUserOperation(dataSource, updatedUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			listUsers(request, response);

			break;
		default:
	    	errorpage(request,response);

			break;
		}
		
	}
	private void updateUserOperation(DataSource dataSource, User updatedUser) throws SQLException {
		new UsersModel().updateUser(dataSource, updatedUser);
		return;
		
	}
	private void addUserOperation(User newUser) throws SQLException {
		new UsersModel().addUser(dataSource, newUser);
		return;
		
	}
	public void listUsers(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {
		List<User> listUsers=new ArrayList<>();
    	listUsers= new UsersModel().listUsers(dataSource);
    	request.setAttribute("listUsers", listUsers);
    	request.setAttribute("title","List Of Users");
    	request.getRequestDispatcher("listUser.jsp").forward(request, response);
    	

}
	

	public void addUserFormLoader(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {
		request.setAttribute("title","Add User");

    	request.getRequestDispatcher("adduser.jsp").forward(request, response);

	}

	public void errorpage(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {
		request.setAttribute("title", "Error");
    	request.getRequestDispatcher("error.jsp").forward(request, response);
    	
   
	}
	
}