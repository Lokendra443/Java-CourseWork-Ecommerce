package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Messages;
import service.MessageDao;

/**
 * Servlet implementation class MessagesController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/admin/messages" })
public class MessagesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageDao dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = new MessageDao();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessagesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Messages> listOfMessages = dao.listAllMessages();
			request.setAttribute("listOfMessages", listOfMessages);

			request.getRequestDispatcher("/WEB-INF/view/admin/messages.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		Messages msg = new Messages();
		
		msg.setName(name);
		msg.setPhoneNumber(phone);
		msg.setEmail(email);
		msg.setMessage(message);
		
		try {
			boolean add = dao.saveMessage(msg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
