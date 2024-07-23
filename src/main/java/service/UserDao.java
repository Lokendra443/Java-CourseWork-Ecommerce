package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.cosenonjaviste.crypto.BCrypt;
import model.User;
import utils.DbConnection;

public class UserDao {
	public void addUser(User entity) throws SQLException {

		User user = null;
		String query = "INSERT INTO `user`"
				+ "( `FirstName`, `LastName`, `PhoneNumber`, `Username`, `Email`, `Address`, `Gender`, `DOB`, `Password`, `role_id`) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
		Connection connection = DbConnection.getDbConnection();
		PreparedStatement pstm = connection.prepareStatement(query);
		
		pstm.setString(1, entity.getFirstname());
		pstm.setString(2, entity.getLastname());
		pstm.setString(3, entity.getNumber());
		pstm.setString(4, entity.getUsername());
		pstm.setString(5, entity.getEmail());
		pstm.setString(6, entity.getAddress());
		pstm.setString(7, entity.getGender());
		pstm.setString(8, entity.getDob());
		System.out.println(entity.getFirstname());
		pstm.setString(9, BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt(10)));
		System.out.println(entity.getFirstname());
		pstm.setInt(10, 1);// role id is deafult for users 

		pstm.executeUpdate();
		System.out.println(entity.getFirstname());
		pstm.close();
		connection.close();

	}

	public User updateUser(User entity) throws SQLException {

		String query = "UPDATE user SET FirstName=?, LastName=?, PhoneNumber=?, Username=?, "
				+ "Email=?, Address=?, Gender=?, DOB=? " + "WHERE id=?";

		Connection connection = DbConnection.getDbConnection();
		PreparedStatement pstm = connection.prepareStatement(query);

		pstm.setString(1, entity.getFirstname());
		pstm.setString(2, entity.getLastname());
		pstm.setString(3, entity.getNumber());
		pstm.setString(4, entity.getUsername());
		pstm.setString(5, entity.getEmail());
		pstm.setString(6, entity.getAddress());
		pstm.setString(7, entity.getGender());
		pstm.setString(8, entity.getDob());
		pstm.setInt(9, entity.getuserId());

		int row = pstm.executeUpdate();
		if (row > 0) {
			return entity;
		}
		pstm.close();
		connection.close();
		return null;
	}

	public User loginUser(String name, String password) throws SQLException {
		User user = null;
		String query = "select * from user where username=?";

		Connection connection = DbConnection.getDbConnection();
		PreparedStatement pstm = connection.prepareStatement(query);
		pstm.setString(1, name);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			if (BCrypt.checkpw(password, rs.getString("password"))) {
				user = new User();
				user.setuserId(rs.getInt("id"));
				user.setFirstname(rs.getString("FirstName"));
				user.setLastname(rs.getString("LastName"));
				user.setNumber(rs.getString("PhoneNumber"));
				user.setEmail(rs.getString("Email"));
				user.setAddress(rs.getString("Address"));
				user.setGender(rs.getString("Gender"));
				user.setPassword(rs.getString("password"));
				user.setDob(rs.getString("Dob"));
				user.setRoleId(rs.getInt("role_id"));
				user.setUsername(rs.getString("Username"));
				user.setLoginresult("success");
			} else {
				user = new User();
				user.setLoginresult("passwordMismatch");
			}
		} else {
			user = new User();
			user.setLoginresult("userNotFound");

		}
		rs.close();
		pstm.close();
		connection.close();
		return user;
	}

}