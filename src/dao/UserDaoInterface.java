package dao;

import java.sql.SQLException;

public interface UserDaoInterface {
	int signupUser(User user) throws ClassNotFoundException, SQLException;
	boolean loginUser(User user) throws ClassNotFoundException, SQLException;
}
