package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Messages;
import utils.DbConnection;

public class MessageDao {
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private boolean isSuccess;

	public MessageDao() {
		this.conn = DbConnection.getDbConnection();
	}

	public boolean saveMessage(Messages msg) throws SQLException {
		int row = insertMessage(msg);
		if (row > 0) {
			isSuccess = true;
		}
		
		return isSuccess;
	}

	public int insertMessage(Messages msg) throws SQLException {
		String query = "INSERT INTO `messages`(`name`, `email`, `phoneNumber`, `message`,`date`, `time`) VALUES (?,?,?,?,CURRENT_DATE, CURRENT_TIME)";
		statement = conn.prepareStatement(query);
		statement.setString(1, msg.getName());
		statement.setString(2, msg.getEmail());
		statement.setString(3, msg.getPhoneNumber());
		statement.setString(4, msg.getMessage());

		int rows = statement.executeUpdate();
		return rows;
	}

	public List<Messages> listAllMessages() throws SQLException {
		statement = conn.prepareStatement("SELECT * FROM messages ORDER BY id DESC");
		resultSet = statement.executeQuery();
		List<Messages> messages = new ArrayList<Messages>();

		while (resultSet.next()) {
			Messages msg = new Messages();
			msg.setId(resultSet.getInt("id"));
			msg.setName(resultSet.getString("name"));
			msg.setEmail(resultSet.getString("email"));
			msg.setPhoneNumber(resultSet.getString("phoneNumber"));
			msg.setMessage(resultSet.getString("message"));
			msg.setDate(resultSet.getDate("date"));
			msg.setTime(resultSet.getTime("time"));

			messages.add(msg);
		}
		return messages;
	}
}