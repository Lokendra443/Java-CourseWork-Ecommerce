package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductDao;

/**
 * Servlet implementation class DeleteProductController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/admin/product/delete" })
public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ProductDao dao;
       
       @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	dao = new ProductDao();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/404.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(id!=0) {
			boolean success = dao.deleteProduct(id);
			if(success) {
				response.sendRedirect(request.getContextPath() + "/admin/product?success=Product+deleted+successfully!");
				return;
			}
		}
		response.sendRedirect(request.getContextPath() + "/admin/product?error=Product+not+found!");
	}

}
