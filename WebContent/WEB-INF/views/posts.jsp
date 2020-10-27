<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Tweets</title>
    <link type="text/css" rel="stylesheet" href="./css/style1.css" />
    <link type="text/css" rel="stylesheet" href="./css/post.css" />
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
    />
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css"
      rel="stylesheet"
    />
  </head>
  <body>
    <nav class="mb-1 navbar navbar-expand-lg">
      <a class="title" href="#">Tweets</a>
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarSupportedContent-333"
        aria-controls="navbarSupportedContent-333"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent-333">
        <ul class="navbar-nav items ml-auto">
          <li class="nav-item active">
            <a
              class="nav-link"
              href="${pageContext.request.contextPath }/welcome"
              >Home<span class="sr-only">(current)</span></a
            >
          </li>

          <li class="nav-item">
            <a
              class="nav-link"
              href="${pageContext.request.contextPath }/newpost"
              >New Post</a
            >
          </li>

          <li class="nav-item">
            <a
              class="nav-link"
              href="${ pageContext.request.contextPath }/posts"
              >Posts</a
            >
          </li>

          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              id="navbarDropdownMenuLink-4"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
            >
              <i class="fas fa-user"></i> Profile
            </a>
            <div
              class="dropdown-menu dropdown-menu-right dropdown-info"
              aria-labelledby="navbarDropdownMenuLink-4"
            >
              <a class="dropdown-item" href="#">My account</a>
              <a
                class="dropdown-item"
                href="${ pageContext.request.contextPath }/login"
                >Log out</a
              >
            </div>
          </li>
        </ul>
      </div>
    </nav>
    <div class="post">
	<c:forEach var="post" items="${posts}">
    		<div class="card">
            <div class="card-text">
                <h1 id="item" ><c:out value="${post.getPostTitle()}" /></h1>
                <p ><c:out value="${post.getPost()}" /></p>
                <p>Posted on <b><c:out value="${post.getDate()}" /></b> </p>
                <c:forEach var="comments" items="$comments">
                	<p><c:out value="${comment.getComment()}" /></p>
                </c:forEach>
            </div>
            <div class="card-buttons">
                <button type="button" id="edit" value="edit">EDIT</button> <span></span><button id="delete" value="delete">DELETE</button>
            </div>
            <p>Comments</p>
                <textarea name="comment" rows="5" id="comment"></textarea>
			<button id="post" type="submit">Add Comments</button>        
			</div>
        </c:forEach>
 	</div>
  </body>
</html>
