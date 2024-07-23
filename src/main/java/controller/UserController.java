package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserDao;
import utils.PageURL;

// Futher implementation need to be done for this class
@WebServlet(asyncSupported = true, urlPatterns = { "/user" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(PageURL.USER.getUrl()).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("username"));
		
		
	    HttpSession session = request.getSession();
		UserDao userModel = new UserDao();
	    User userEntity = (User) session.getAttribute("user");
		
			try {
				
				int userId = userEntity.getuserId();
				userEntity.setuserId(userId);
				userEntity.setUsername(request.getParameter("username"));
		        userEntity.setFirstname(request.getParameter("firstName")); 
		        userEntity.setLastname(request.getParameter("lastName")); 
		        userEntity.setEmail(request.getParameter("email")); 
		        userEntity.setNumber(request.getParameter("phoneNumber")); 
		        userEntity.setGender(request.getParameter("gender"));
		        userEntity.setAddress(request.getParameter("address")); 
		        userEntity.setDob(request.getParameter("dob")); 
				userModel.updateUser(userEntity);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		doGet(request, response);
	}

}
