<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Tweets</title>
    <link type="text/css" rel="stylesheet" href="./css/style1.css" />
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
      <a class="title" href="${pageContext.request.contextPath }/welcome"
        >Tweets</a
      >
      <div class="collapse navbar-collapse" id="navbarSupportedContent-333">
        <ul class="navbar-nav items ml-auto">
          <li class="nav-item active">
            <a
              class="nav-link"
              id="nav-links"
              href="${pageContext.request.contextPath }/welcome"
              >Home<span class="sr-only">(current)</span></a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath }/login"
              >Log In</a
            >
          </li>
          <li class="nav-item">
            <a
              class="nav-link"
              href="${pageContext.request.contextPath }/signup"
              >Sign Up</a
            >
          </li>
          <li class="nav-item">
            <a
              class="nav-link"
              href="${ pageContext.request.contextPath }/posts"
              >Posts</a
            >
          </li>
        </ul>
      </div>
    </nav>
    <div id="container">
      <div class="login-form">
        <form
          class="text-center border border-light p-5"
          action="${ pageContext.request.contextPath }/login"
          method="post"
        >
          <p class="h4 mb-4" id="item" >Log in</p>
          <input
            type="text"
            name="username"
            id="defaultLoginFormEmail"
            class="form-control mb-4"
            placeholder="User Name"
          />
          <input
            type="password"
            name="password"
            id="defaultLoginFormPassword"
            class="form-control mb-4"
            placeholder="Password"
          />

          <div class="d-flex justify-content-center">
            <div>
              <div class="custom-control custom-checkbox">
                <input
                  type="checkbox"
                  class="custom-control-input"
                  id="defaultLoginFormRemember"
                />
              </div>
            </div>
            <div>
              <a href="">Forgot password?</a>
            </div>
          </div>
          <button class="btn btn-info btn-block my-4" type="submit">
            Sign in
          </button>
          <p>
            Not a member?
            <a href="${pageContext.request.contextPath }/signup">Register</a>
          </p>
        </form>
      </div>
    </div>
  </body>
</html>
