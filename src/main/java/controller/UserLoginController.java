package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserDao;
import utils.PageURL;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     request.getRequestDispatcher(PageURL.LOGIN.getUrl()).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Taking parameter for users when login and storing in this field
        String username = request.getParameter("Username_l");
        String userpassword = request.getParameter("Password_l");

        
        //Creating instance of userModel which perform database logic -part1 
        UserDao usermodel = new UserDao();

        try {
        	// storing select query result in User which content getter and setters
            User user = usermodel.loginUser(username, userpassword);
            int role = user.getRoleId();
            

            // creating session when user login sucess
            if (user.getLoginresult().equals("success")) {
            
            	//session object
            	HttpSession session = request.getSession();
                 session.setAttribute("user", user);
                 
                 //setting session for 30 min
                 session.setMaxInactiveInterval(1800);
                 System.out.println(session);
                 
                 
             

           
              // role 1= user
              // role 2 = admin
                 
            	
                if (role==1) {
                	response.sendRedirect(request.getContextPath()+"/home");
                  // for testing  request.getRequestDispatcher(PageURl.USER.getUrl()).forward(request, response);
                } else {
                	response.sendRedirect(request.getContextPath()+"/admin");

                    //request.getRequestDispatcher(PageURl.ADMIN.getUrl()).forward(request, response);
                }
            } else if (user.getLoginresult().equals("passwordMismatch")) {
                request.setAttribute("incorrect_password", "Password was incorrect");
                request.getRequestDispatcher(PageURL.LOGIN.getUrl()).forward(request, response);
            } else {
                request.setAttribute("user_notfound", "User with this name not found");
                request.getRequestDispatcher(PageURL.LOGIN.getUrl()).forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
	}

}
