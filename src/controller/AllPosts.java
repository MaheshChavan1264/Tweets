package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Posts;
import dao.AddPostDao;

/**
 * Servlet implementation class Posts
 */
@WebServlet("/posts")
public class AllPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllPosts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("View all Posts");
		AddPostDao postDao = new AddPostDao();
		List<Posts> posts = null;
		try {
			posts = postDao.viewAllPosts();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Posts post: posts) {
			System.out.println(post.getId());
			System.out.println(post.getPostTitle());	
			System.out.println(post.getPost());
			System.out.println(post.getDate());
		}
		
		request.setAttribute("posts",posts);
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
