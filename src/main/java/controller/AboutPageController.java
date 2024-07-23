package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Messages;
import service.MessageDao;

/**
 * Servlet implementation class AboutPageController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/about-us" })
public class AboutPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private MessageDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AboutPageController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	dao = new MessageDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/home/about.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Messages msg = new Messages();
		System.out.println();
		msg.setName(request.getParameter("name"));
		msg.setEmail(request.getParameter("email"));
		msg.setPhoneNumber(request.getParameter("phoneNumber"));
		msg.setMessage(request.getParameter("message"));

		
		if(msg.getName()==null || msg.getEmail()==null || msg.getMessage()==null || msg.getPhoneNumber()==null ) {
			request.setAttribute("error", "Empty fields found!");
			request.getRequestDispatcher(request.getContextPath()+"/about-us").forward(request, response);
		}
		try {
			boolean success = dao.saveMessage(msg);
			if(success) {
				request.setAttribute("success", "Message was delivered successfully!");
				request.getRequestDispatcher("/WEB-INF/view/home/about.jsp").forward(request, response);
			}else {
				request.setAttribute("error", "Couldn't send your message. Please try again!");
				request.getRequestDispatcher("/WEB-INF/view/home/about.jsp").forward(request, response);
			}
			System.out.println(success);

		} catch (SQLException e) {
			request.setAttribute("error", "Couldn't send your message. Please try again!");
			request.getRequestDispatcher("/WEB-INF/view/home/about.jsp").forward(request, response);
		}
	}

}
