package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddPostDao;
import dao.Comments;

/**
 * Servlet implementation class AllComments
 */
@WebServlet("/comments")
public class AllComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllComments() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("View all Comments");
		AddPostDao commentDao = new AddPostDao();
		List<Comments> comments = null;
		try {
			comments = commentDao.viewAllComments();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Comments comment: comments) {
			System.out.println(comment.getId());
			System.out.println(comment.getComment());
		}
		
		request.setAttribute("comments",comments);
		RequestDispatcher rDispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/posts.jsp");
		rDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
