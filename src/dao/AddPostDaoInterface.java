package dao;

import java.sql.Date;
import java.sql.SQLException;

interface AddPostDaoInterface {
	 void addPost(Posts post) throws SQLException, ClassNotFoundException;
}
