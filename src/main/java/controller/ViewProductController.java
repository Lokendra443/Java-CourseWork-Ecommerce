package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.User;
import service.ProductDao;
import utils.PageURL;

/**
 * Servlet implementation class ViewProductController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ViewProductController" })
public class ViewProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ViewProductController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		int product_ID =Integer.parseInt(request.getParameter("product_ID"));
		ProductDao productModel = new ProductDao();

		try {		
			
			Product product = productModel.searchByID(product_ID);
			request.setAttribute("productDetail", product);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(PageURL.PRODUCT_DETAIL.getUrl()).forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession userS = request.getSession();
		User user = (User) userS.getAttribute("user");
		int product_id=Integer.parseInt(request.getParameter("product_id"));
		int user_id =user.getuserId();
		
		
		ProductDao productDao = ProductDao.getInstance();

		try {		
			
			Boolean productadded = productDao.addToCart(user_id, product_id);
			
			if(productadded) {
				response.sendRedirect(request.getContextPath()+"/user/cart");
			}
			else {
				request.getRequestDispatcher(PageURL.PRODUCT_DETAIL.getUrl()).forward(request, response);

			}

			
		} catch (Exception e) {
			System.out.println("Some thing went wrong ");
			e.printStackTrace();
		}

	
	}

}
