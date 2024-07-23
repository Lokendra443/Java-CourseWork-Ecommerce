package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Product;
import service.ProductDao;

/**
 * Servlet implementation class EditProductController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/admin/product/edit" })
public class EditProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ProductDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	dao = new ProductDao();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//fetching the id parameter from the request
		int id = Integer.parseInt(request.getParameter("id"));

		Product product = dao.getProduct(id);
		
		request.setAttribute("product", product);
		
		request.getRequestDispatcher("/WEB-INF/view/admin/edit-product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String brand = request.getParameter("brand");
		String title = request.getParameter("title");
		String model = request.getParameter("model");
		float discountPercent = Float.parseFloat(request.getParameter("discountPercent"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Double actualPrice = Double.parseDouble(request.getParameter("actualPrice"));
		String description = request.getParameter("description");
		
		Double discountedPrice = actualPrice - actualPrice * discountPercent / 100;

		Product product = new Product();
		product.setId(id);
		product.setTitle(title);
		product.setBrand(brand);
		product.setModelNo(model);
		product.setActualPrice(actualPrice);
		product.setDiscountPercent(discountPercent);
		product.setDiscountedPrice(discountedPrice);
		product.setQuantity(quantity);
		product.setDescription(description);
		product.setLastModified(LocalDateTime.now());
	
	

		boolean updated = dao.updateProduct(product);
		
		if(updated) {
			response.sendRedirect(request.getContextPath() + "/admin/product?success=Product+details+updated+successfully!");
		}else {
			request.setAttribute("error", "Invalid or duplicate product information provided. Please try again!");
			request.getRequestDispatcher("/admin/product/edit?id="+id).forward(request, response);
		}
	}

}
