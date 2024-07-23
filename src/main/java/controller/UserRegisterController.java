package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserDao;
import utils.PageURL;

/**
 * Servlet implementation class UserRegisterController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/register" })
public class UserRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher(PageURL.REGISTER.getUrl()).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		UserDao userM = new UserDao();
		String password = request.getParameter("Password");
		String conformpassword = request.getParameter("confirmPassword");

		// checking password and conform password are same or not
		if (!password.equals(conformpassword)) {
			request.setAttribute("error", "password not match");
			doGet(request, response);

		}

		else {

			try {
				// setting parameters to user object (User)
				user.setFirstname(request.getParameter("Firstname"));
				user.setLastname(request.getParameter("Lastname"));
				user.setNumber(request.getParameter("Number"));
				user.setUsername(request.getParameter("Username"));
				user.setEmail(request.getParameter("Email"));
				user.setAddress(request.getParameter("Address"));
				user.setGender(request.getParameter("Gender"));
				user.setDob(request.getParameter("Date"));
				user.setPassword(request.getParameter("Password"));
				userM.addUser(user);

				request.setAttribute("success", "User registered successfully");
				doGet(request, response);
			} catch (SQLIntegrityConstraintViolationException e) {
				String errorMessage = e.getMessage();
				// taking out text from error message
				int startindeXField = errorMessage.indexOf("users.") + "users.".length(); //
				int endIndexField = errorMessage.indexOf("'", startindeXField);
				String duplicateEntryField = errorMessage.substring(startindeXField, endIndexField);
				request.setAttribute("error", duplicateEntryField + " already existe choose another ");
				doGet(request, response);

			}

			catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("error", "something went wrong please try again later");
				doGet(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "some thing went wrong try again");
				doGet(request, response);
			}

		}

	}

}
