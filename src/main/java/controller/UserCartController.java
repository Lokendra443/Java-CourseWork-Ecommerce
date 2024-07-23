package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

@WebServlet(asyncSupported = true, urlPatterns = { "/user/cart" })
public class UserCartController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserCartController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       

    	
    	try {
            String cartID = request.getParameter("deleteCartID");
            if (cartID != null) {
                doDelete(request, response);
                return; 
            }

           
            ProductDao productDao = ProductDao.getInstance();
            HttpSession userSession = request.getSession();
            User user = (User) userSession.getAttribute("user");

            if (user != null) {
                int userID = user.getuserId();

                try {
                    List<Product> cartProduct = productDao.viewCart(userID);
                    request.setAttribute("inCart", cartProduct);

                } catch (SQLException e) {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    e.printStackTrace();
                }
            }

            request.getRequestDispatcher(PageURL.CART.getUrl()).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
		
 
    

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int cartID = Integer.parseInt(request.getParameter("deleteCartID"));
            ProductDao productDao = ProductDao.getInstance();
            productDao.deleteCartProduct(cartID);
            
            request.setAttribute("deleteSuccessMessage", "Product deleted successfully.");
        } catch (NumberFormatException e) {
            request.setAttribute("deleteErrorMessage", "Invalid cart ID provided. Please provide a valid integer.");
        }
        response.sendRedirect(request.getContextPath()+"/user/cart");
    }
}
