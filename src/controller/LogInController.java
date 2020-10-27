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

/**
 * Servlet implementation class LogInController
 */
@WebServlet("/login")
public class LogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rDispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		rDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		UserDao userDao = new UserDao();
		boolean validateUser = false;
		try {
			validateUser = userDao.loginUser(user);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(validateUser) {
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/profile.jsp");
			rd.forward(request, response);
			System.out.println("Successfully Login");
		}else {
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(request, response);
			System.out.println("Not Successfully login");
		}
	}

}