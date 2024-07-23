package controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.cj.conf.AbstractPropertyDefinition;

import model.Product;
import service.ProductDao;

/**
 * Servlet implementation class AddProductController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/admin/product/add" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1 MB in bytes
		maxFileSize = 20971520, // 20 MB in bytes
		maxRequestSize = 41943040 // 40 MB in bytes
)
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductController() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/admin/add-products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String brand = request.getParameter("brand");
			String title = request.getParameter("title");
			String model = request.getParameter("model");
			float discountPercent = Float.parseFloat(request.getParameter("discountPercent"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			Double actualPrice = Double.parseDouble(request.getParameter("actualPrice"));
			String description = request.getParameter("description");
			Part photoPart = request.getPart("image");

			Double discountedPrice = actualPrice - actualPrice * discountPercent / 100;

			String photoFileName = generateUniqueFileName(photoPart.getSubmittedFileName());

			String photoPath = savePhoto(photoPart, photoFileName);

			Product product = new Product();

			product.setTitle(title);
			product.setBrand(brand);
			product.setModelNo(model);
			product.setActualPrice(actualPrice);
			product.setDiscountPercent(discountPercent);
			product.setDiscountedPrice(discountedPrice);
			product.setQuantity(quantity);
			product.setDescription(description);
			product.setImage(photoFileName);

			boolean isSuccess = dao.saveProduct(product);
			if (isSuccess) {
				response.sendRedirect(request.getContextPath() + "/admin/product?success=Product+created+successfully!");
			} else {
				request.setAttribute("error", "Invalid or duplicate product information provided. Please try again!");
				request.getRequestDispatcher("/WEB-INF/view/admin/add-products.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error",
					"Invalid, incomplete or duplicate product information provided. Please try again!");
			request.getRequestDispatcher("/WEB-INF/view/admin/add-products.jsp").forward(request, response);
		}

	}

	private String generateUniqueFileName(String originalFileName) {
		// Generate a unique filename using date-time and UUID
		LocalDateTime now = LocalDateTime.now();
		String dateTimeString = now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String uniqueId = UUID.randomUUID().toString().replace("-", "");
		String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
		return dateTimeString + "_" + uniqueId + extension;
	}

	private String savePhoto(Part photoPart, String fileName) throws IOException {
		// Saving the photo to the specified directory
		String photoDirectory = "D:\\Workshop\\java-cw-ecommerce\\src\\main\\webapp\\uploads\\product_images\\";
		
		String photoPath = photoDirectory + fileName;

		// Ensuring the directory exists; create it if it doesn't
		File directory = new File(photoDirectory);

		if (!directory.exists()) {
			directory.mkdirs();
		}

		// Saving the photo to the specified location
		photoPart.write(photoPath);

		return photoPath; // returning the path of the photo
	}

}
