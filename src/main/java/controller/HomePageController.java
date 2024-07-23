package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.ProductDao;
import utils.PageURL;

/**
 * Servlet implementation class HomePageController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/home" })
public class HomePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public HomePageController() {
        super();
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String minPrice_S = request.getParameter("min-price"); 
		String maxPrice_S =request.getParameter("max-price");
		
		String itemSearch=request.getParameter("search_product");
		ProductDao productModel = ProductDao.getInstance();
		
		if(minPrice_S!=null && maxPrice_S != null) {
			try {
				List<Product> productList= productModel.filterByPrice(Integer.parseInt(minPrice_S), Integer.parseInt(maxPrice_S));
				request.setAttribute("productList", productList);
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
			
		}
		else if(itemSearch==null || itemSearch.equals("")) {
			try {
				List<Product> productList = productModel.showAllproduct();
				request.setAttribute("productList", productList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				List<Product> productList = productModel.searchProduct(itemSearch);
				request.setAttribute("productList", productList);
				itemSearch=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		request.getRequestDispatcher(PageURL.HOME.getUrl()).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
