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

import model.Order;
import service.OrderDao;
import utils.PageURL;

/**
 * Servlet implementation class ViewOrderController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/admin/orders" })
public class ViewOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    OrderDao dao;
    
    
 /**
  * @see HttpServlet#HttpServlet()
  */
 public ViewOrderController() {
     super();
     // TODO Auto-generated constructor stub
 }
 
 @Override
 public void init(ServletConfig config) throws ServletException {
 	// TODO Auto-generated method stub
 	super.init(config);
 	dao = new OrderDao();
 }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Order> listOfOrder = dao.getAllOrders();
			request.setAttribute("listOfOrder", listOfOrder);
			request.getRequestDispatcher(PageURL.ADMIN_ORDERS.getUrl()).forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
