package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User;
import dao.UserDao;


@WebServlet("/signup")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rDispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signup.jsp");
		rDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entering into the sign up");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String password  = request.getParameter("password");
		String confirmPassword  = request.getParameter("confirmPassword");
		User user = new User();
		user.setFname(fname);
		user.setLname(lname);
		user.setEmail(email);
		user.setUsername(userName);
		user.setPassword(password);
		user.setConfirmPassword(confirmPassword);
		UserDao userDao = new UserDao();
		int result = 0;
		try {
			 result = userDao.signupUser(user);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(result!=0) {
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/welcome.jsp");
			rd.forward(request, response);
		}else {
		}
	}

}



