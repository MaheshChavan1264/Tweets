package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import utility.ConnectionManager;

public class AddPostDao implements AddPostDaoInterface {

	@Override
	public void addPost(Posts post) throws SQLException, ClassNotFoundException {
		
		String sqlString = "insert into posts values(?,?,?) ";
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlString); 
		statement.setString(1,post.getPostTitle());
		statement.setString(2, post.getPost());
		statement.setDate(3, java.sql.Date.valueOf(post.getDate()));
		int result = statement.executeUpdate();
		if(result!=0) {
			System.out.println("Post Added successfully");
		}else {

			System.out.println("Post not Added successfully");
		}
	}

}
