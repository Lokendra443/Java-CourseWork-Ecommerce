package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Order;
import model.Product;
import model.User;
import service.OrderDao;
import service.ProductDao;
import utils.PageURL;

/**
 * Servlet implementation class OrdersController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/user/order" })
public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersController() {
        super();
        
        
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession userS = request.getSession();
		User user = (User)userS.getAttribute("user");
		int userID = user.getuserId();
        OrderDao orderDao = OrderDao.getInstance();
        
        List<Order>orderProduct=orderDao.showOrders(userID);
		request.setAttribute("orders", orderProduct);

        request.getRequestDispatcher(PageURL.ORDER.getUrl()).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession userS = request.getSession();
		User user = (User)userS.getAttribute("user");
		int userID = user.getuserId();
		 
		for(int i=0; i<20; i++) {
			String qntStr =request.getParameter("stocks[" + i + "]");
            //String title = request.getParameter("title_" + i);
            String productIDStr =request.getParameter("product_" + i);
            String totalPriceStr =request.getParameter("total_" + i);
            if( qntStr == null || productIDStr == null || totalPriceStr ==null ) {
            	break;
            }
            
            OrderDao order = new OrderDao();
            int qnt = Integer.parseInt(qntStr);
            int productID =Integer.parseInt(productIDStr);
            int totalPrice =Integer.parseInt(totalPriceStr);
            
            order.addUserOrder(userID,productID,qnt,totalPrice,"Pending");
            
		}
		ProductDao product = new ProductDao();
		product.deleteAllCart(userID);
        
		doGet(request, response);
	}

}
