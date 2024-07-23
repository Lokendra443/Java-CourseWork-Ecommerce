package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Order;
import utils.DbConnection;

public class OrderDao {
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private boolean isSuccess;
	private static OrderDao instance;

	
	public OrderDao() {
		conn = DbConnection.getDbConnection();
	}
	  public static OrderDao getInstance() { // singleton design pattern for home controller
	        if (instance == null) {
	            instance = new OrderDao();
	        }
	        return instance;
	    }
	
	
	public List<Order> getAllOrders() throws SQLException{
		String query = "SELECT o.id, u.FirstName, u.LastName, p.Title, o.OrderedOn, o.Quantity, o.status "
				+ "FROM Orders AS o "
				+ "LEFT JOIN User AS u ON o.UserId = u.Id "
				+ "LEFT JOIN Products AS p ON o.ProductId = p.Id "
				+ "ORDER BY o.id DESC";
		
		statement = conn.prepareStatement(query);
		resultSet = statement.executeQuery();
		
		List<Order> listOfOrders = new ArrayList<Order>();
		
		while(resultSet.next()) {
			Order order = new Order();
			order.setId(resultSet.getInt("id"));
			order.setCustomerName(resultSet.getString("FirstName")+" "+resultSet.getString("LastName"));
			order.setProductName(resultSet.getString("Title"));
			order.setOrderedon(resultSet.getTimestamp("OrderedOn").toLocalDateTime());
			order.setQuantity(resultSet.getInt("Quantity"));
			order.setStatus(resultSet.getString("status"));
			
			listOfOrders.add(order);
		}
		
		return listOfOrders;
		
	}
	
	public boolean addUserOrder(int userId,int productId,int quantity,int price,String status) {
		
		String query ="INSERT INTO orders"
				+ "(UserId,ProductId,Quantity,TotalAmount,Status) "
				+ "VALUES (?,?,?,?,?)";
		
        try (
        		Connection connection = DbConnection.getDbConnection();
                PreparedStatement pstm = connection.prepareStatement(query)) {
               
        	   pstm.setInt(1, userId);
               pstm.setInt(2, productId);
               pstm.setInt(3, quantity);
               pstm.setInt(4, price);
               pstm.setString(5, status);

               
                pstm.executeUpdate();
                return true;

           
 
           } catch (SQLException e) {
               e.printStackTrace();
           }
        
        return false;
	}
	
	public List<Order> showOrders(int userId) {
	    String query = "SELECT orders.Id AS order_id, products.Title AS product_name, orders.Quantity AS order_quantity " +
	                   "FROM orders " +
	                   "INNER JOIN products ON orders.ProductId = products.Id WHERE orders.UserId = ?";

	    try (PreparedStatement pstm = conn.prepareStatement(query)) {
	        pstm.setInt(1, userId);

	        try (ResultSet resultSet = pstm.executeQuery()) {
	            List<Order> listOfOrders = new ArrayList<>();

	            while (resultSet.next()) {
	                Order order = new Order();
	                order.setId(resultSet.getInt("order_id"));
	                order.setProductName(resultSet.getString("product_name"));
	                order.setQuantity(resultSet.getInt("order_quantity"));

	                listOfOrders.add(order);
	            }

	            return listOfOrders;

	        } catch (SQLException e) {
	            e.printStackTrace(); 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	    }
		return null;
	}


	
	
	
}