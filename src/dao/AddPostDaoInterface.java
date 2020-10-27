package dao;

import java.sql.SQLException;
import java.util.List;

interface AddPostDaoInterface {
	 void addPost(Posts post) throws SQLException, ClassNotFoundException;
	 List<Posts> viewAllPosts() throws ClassNotFoundException;
	 void addComment(Comments comment) throws SQLException, ClassNotFoundException;
	 List<Comments> viewAllComments() throws ClassNotFoundException;
	 
}
