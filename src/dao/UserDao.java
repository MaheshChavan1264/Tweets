package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.ConnectionManager;

public class UserDao implements UserDaoInterface {

	private static final String INSERT_USER = "insert into users values(?,?,?,?,?,?)";
	
	@Override
	public int signupUser(User user) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = connection.prepareStatement(INSERT_USER);
		statement.setString(1, user.getFname());
		statement.setString(2, user.getLname());
		statement.setString(3,user.getEmail());                               
		statement.setString(4,user.getUsername());
		statement.setString(5,user.getPassword());
		statement.setString(6,user.getConfirmPassword());
		result = statement.executeUpdate();
		return result;
	}

	@Override
	public boolean loginUser(User user) throws ClassNotFoundException, SQLException {
		boolean checkUser = false;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from users where username = ? and passwd = ?");		
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getPassword());
		ResultSet resultSet = statement.executeQuery();
		checkUser = resultSet.next();
		return checkUser;
	}

}
