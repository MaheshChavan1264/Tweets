package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import utility.ConnectionManager;

public class AddPostDao implements AddPostDaoInterface {

	@Override
	public void addPost(Posts post) throws SQLException, ClassNotFoundException {
		
		String sqlString = "insert into posts values(seq.nextval,?,?,?) ";
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
	@Override
	public void addComment(Comments comment) throws SQLException, ClassNotFoundException {
		
		String sqlString = "insert into comments values(seq.nextval,?) ";
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlString); 
		statement.setString(1, comment.getComment());
		int result = statement.executeUpdate();
		if(result!=0) {
			System.out.println("Comment Added successfully");
		}else {

			System.out.println("comment not Added successfully");
		}
	}

	@Override
	public List<Posts> viewAllPosts() throws ClassNotFoundException {
		Posts post = null;
		List<Posts> posts = new ArrayList<>();
		
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from posts");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int postId = resultSet.getInt("POSTID");
				String postTitle = resultSet.getString("POSTITLE");
				String postDes = resultSet.getString("POST");
				LocalDate postedOn = resultSet.getDate("POSTDATE").toLocalDate();
				post = new Posts();
				post.setId(postId);
				post.setPostTitle(postTitle);
				post.setPost(postDes);
				post.setDate(postedOn);
				posts.add(post);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return posts;
	}
	@Override
	public List<Comments> viewAllComments() throws ClassNotFoundException {
		Comments comment = null;
		List<Comments> comments = new ArrayList<>();
		
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from comments");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("ID");
				String com = resultSet.getString("COMMENTS");
				
				comment = new Comments();
				comment.setId(id);
				comment.setComment(com);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return comments;
	}

}
