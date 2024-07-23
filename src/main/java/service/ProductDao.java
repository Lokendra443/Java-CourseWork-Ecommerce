package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import utils.DbConnection;

public class ProductDao {
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private boolean isSuccess;
	private static ProductDao instance;

	
	public ProductDao() {
		conn = DbConnection.getDbConnection();
	}
	  public static ProductDao getInstance() { // singleton design pattern for home controller
	        if (instance == null) {
	            instance = new ProductDao();
	        }
	        return instance;
	    }
	
	
	public boolean saveProduct(Product product) {
		String query = "select * from products";
		try {
			statement = conn.prepareStatement(query);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				boolean isFound = isAvailable(product);
				if (isFound) {
					// duplicate product found
					return false;
				}else {
					//duplicate not found
					int row = insertProduct(product);
					if(row>0) {
						return true;
					}
				}
			}else {
				int row = insertProduct(product);
				if(row>0) {
					return true;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	private int insertProduct(Product product) throws SQLException {
		String sql = "INSERT INTO products "
				+ "(Title, ModelNo, Brand, Quantity, DiscountPercent, ActualPrice, DiscountedPrice, Description, Image) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		statement = conn.prepareStatement(sql);
		// Set the values for each parameter
		statement.setString(1, product.getTitle());
		statement.setString(2, product.getModelNo());
		statement.setString(3, product.getBrand());
		statement.setInt(4, product.getQuantity());
		statement.setFloat(5, product.getDiscountPercent());
		statement.setDouble(6, product.getActualPrice());
		statement.setDouble(7, product.getDiscountedPrice());
		statement.setString(8, product.getDescription());
		statement.setString(9, product.getImage());

		int rows = statement.executeUpdate();
		return rows;
	}

	public boolean isAvailable(Product product) throws SQLException {
		String query = "select modelno, title from products;";
		statement = conn.prepareStatement(query);
		resultSet = statement.executeQuery();
		boolean isFound = false;
		while (resultSet.next()) {
			String titleFromDb = resultSet.getString(2);
			String modelnoFromDb = resultSet.getString(1);
			
			if(product.getModelNo().equals(modelnoFromDb) || product.getTitle().equals(titleFromDb)) {
				isFound = true;
				break;
			}
		}
		return isFound;
	}

	public List<Product> getAllProducts() throws SQLException{
		statement = conn.prepareStatement("select * from products");
		resultSet = statement.executeQuery();
		List<Product> listOfProduct= new ArrayList<Product>();
		
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String title = resultSet.getString("title");
			String model = resultSet.getString("modelno");
			String brand = resultSet.getString("brand");
			int quantity = resultSet.getInt("quantity");
			Float discountPercent = resultSet.getFloat("DiscountPercent");
			Double actualprice = resultSet.getDouble("actualprice");
			Double discountedprice= resultSet.getDouble("DiscountedPrice");
			String image = resultSet.getString("Image");
			
			Product  product = new Product();
			
			product.setId(id);
			product.setTitle(title);
			product.setModelNo(model);
			product.setBrand(brand);
			product.setQuantity(quantity);
			product.setDiscountedPrice(discountedprice);
			product.setActualPrice(actualprice);
			product.setImage(image);
			product.setDiscountPercent(discountPercent);

			listOfProduct.add(product);
		}
		return listOfProduct;
	}

	 public Product getProduct(int id) {
	        String query = "select * from products where id=?";
	        Product product = null;

	        try {
	            statement = conn.prepareStatement(query);
	            statement.setInt(1, id);
	            resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                product = new Product();
	                product.setId(resultSet.getInt("id"));
	                product.setTitle(resultSet.getString("title"));
	                product.setModelNo(resultSet.getString("modelno"));
	                product.setBrand(resultSet.getString("brand"));
	                product.setQuantity(resultSet.getInt("quantity"));
	                product.setDiscountPercent(resultSet.getFloat("discountpercent"));
	                product.setActualPrice(resultSet.getDouble("actualprice"));
	                product.setDiscountedPrice(resultSet.getDouble("discountedprice"));
	                product.setDescription(resultSet.getString("description"));
	                product.setImage(resultSet.getString("image"));
	                product.setCreatedon(resultSet.getTimestamp("createdon").toLocalDateTime());
	                product.setLastModified(resultSet.getTimestamp("lastmodified").toLocalDateTime());
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 

	        return product;
	    }

	 public boolean updateProduct(Product product) {
		    String query = "UPDATE products SET " +
		                 "Title = ?, " +
		                 "ModelNo = ?, " +
		                 "Brand = ?, " +
		                 "Quantity = ?, " +
		                 "DiscountPercent = ?, " +
		                 "ActualPrice = ?, " +
		                 "DiscountedPrice = ?, " +
		                 "Description = ? " + 
		                 "WHERE id=?"; 

		    try {
		        statement = conn.prepareStatement(query);
		        statement.setString(1, product.getTitle());
		        statement.setString(2, product.getModelNo());
		        statement.setString(3, product.getBrand());
		        statement.setInt(4, product.getQuantity());
		        statement.setFloat(5, product.getDiscountPercent());
		        statement.setDouble(6, product.getActualPrice());
		        statement.setDouble(7, product.getDiscountedPrice());
		        statement.setString(8, product.getDescription());
		        statement.setInt(9, product.getId()); 

		        int row = statement.executeUpdate();

		        if(row == 1) {
		            return true;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return false;
		}

	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		String query = "delete from products where id=?";
		
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			int row = statement.executeUpdate();
			
			if(row == 1) {
	            return true;
	        }
			
		}catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
			System.out.println("product is order by user");
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	//!!!! anjesh product dao 
	
	 public List<Product> showAllproduct() throws SQLException, IOException{

		 List<Product> productEntity = new ArrayList<Product>();
		    String query = "SELECT * FROM products";
		    
		    try (
		        Connection connection = DbConnection.getDbConnection();
		        PreparedStatement pstm = connection.prepareStatement(query);
		        ResultSet rs = pstm.executeQuery()
		    ) {
		        while (rs.next()) {
		            Product product = setProductEntity(rs);
		            productEntity.add(product);
		        }
		    }
	     
	        return productEntity;
	    }
		
	public List<Product> searchProduct(String productname) throws SQLException {
		
		List<Product>productEntity = new ArrayList<Product>();
		String query = "select * from products where Title LIKE ? ";
		Connection connection = DbConnection.getDbConnection();
		
		PreparedStatement pstm = connection.prepareStatement(query);
		pstm.setString(1, productname+"%");
		
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
           Product product = setProductEntity(rs);
			productEntity.add(product);
		}
		
		return productEntity;		
	}
	
	public List<Product> filterByPrice(int min,int max) throws SQLException{
		
		List<Product>productEntity = new ArrayList<Product>();
		String query = "select * from products where DiscountedPrice BETWEEN ? AND ? ";
		
		Connection connection = DbConnection.getDbConnection();
		PreparedStatement pstm = connection.prepareStatement(query);
		pstm.setInt(1, min);
		pstm.setInt(2, max);

		
		ResultSet rs =pstm.executeQuery();
		
		while(rs.next()) {
           Product product = setProductEntity(rs);
			productEntity.add(product);
		}
	
		return productEntity;
	}
	
	public Product searchByID(int id) throws SQLException{
		
		Product productEntity = new Product();
		String query ="SELECT * FROM products where id=?";
		
        try (Connection connection = DbConnection.getDbConnection();
                PreparedStatement pstm = connection.prepareStatement(query)) {
               pstm.setInt(1, id);
               
               try (ResultSet rs = pstm.executeQuery()) {
                   if (rs.next()) {
                       productEntity = setProductEntity(rs);    
                   }
               }
 
           } catch (SQLException e) {
               e.printStackTrace();
               // Handle exception, possibly rethrow or return null
           }

           
        	
    		conn.close();

           return productEntity;
		
	}
	

	public Product setProductEntity(ResultSet rs) throws SQLException {
		
		Product product = new Product();

		product.setId(rs.getInt("Id"));
		product.setTitle(rs.getString("Title"));
		product.setModelNo(rs.getString("ModelNo"));
		product.setBrand(rs.getString("Brand"));
		product.setQuantity(Integer.parseInt(rs.getString("Quantity")));
		product.setActualPrice(rs.getFloat("ActualPrice"));
		product.setDiscountedPrice(rs.getFloat("DiscountedPrice"));
		product.setDescription(rs.getString("Description"));
		product.setImage(rs.getString("Image"));
		
		return product;
		
	}
	
	public Boolean addToCart(int user_id,int product_id) {
		
		String query ="INSERT INTO cart"
				+ "(UserId,ProductId) "
				+ "VALUES (?,?)";

        try (Connection connection = DbConnection.getDbConnection();
                PreparedStatement pstm = connection.prepareStatement(query)) {
               pstm.setInt(1, user_id);
               pstm.setInt(2, product_id);
               
                pstm.executeUpdate();
                return true;

           
 
           } catch (SQLException e) {
               e.printStackTrace();
           }
        return false;
	}
	
	
public List<Product> viewCart(int user_id) throws SQLException{
		
		List<Product>productEntity = new ArrayList<Product>();
		 
		String query = "SELECT cart.Id AS cartId ,products.Id, products.Image, products.ModelNo, products.Title, products.DiscountedPrice " +
	               "FROM cart " +
	               "JOIN products ON cart.ProductId = products.Id " +
	               "WHERE cart.UserId = ?";

		
		Connection connection = DbConnection.getDbConnection();
		PreparedStatement pstm = connection.prepareStatement(query);
		pstm.setInt(1, user_id);


		ResultSet rs =pstm.executeQuery();

		while(rs.next()) {
			Product product = new Product();
			product.setCartID(rs.getInt("cartId"));
			product.setId(rs.getInt("Id"));
	        product.setImage(rs.getString("Image"));
	        product.setModelNo(rs.getString("ModelNo"));
	        product.setTitle(rs.getString("Title"));
	        product.setDiscountedPrice(rs.getDouble("DiscountedPrice"));
			productEntity.add(product);
		}
		rs.close();
		pstm.close();
		connection.close();
		return productEntity;
	}

public boolean deleteCartProduct(int cartID) {
	// TODO Auto-generated method stub
	String query = "delete from cart where Id=? ";
	// under work
	try {
		statement = conn.prepareStatement(query);
		statement.setInt(1, cartID);

		int row = statement.executeUpdate();
		
		if(row == 1) {
            return true;
        }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
}



public boolean deleteAllCart(int userID) {
	// TODO Auto-generated method stub
	String query = "delete from cart where UserId=? ";
	// under work
	try {
		statement = conn.prepareStatement(query);
		statement.setInt(1, userID);

		int row = statement.executeUpdate();
		
		if(row == 1) {
            return true;
        }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
}

	
	

}