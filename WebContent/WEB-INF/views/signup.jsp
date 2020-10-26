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
    <div class="sign-form">
      <form
        class="text-center border border-light p-5"
        action="${pageContext.request.contextPath}/login"
        method="post"
      >
        <p class="h4 mb-4" id="item">Sign up</p>

        <div class="form-row mb-4">
          <div class="col">
            <input
              type="text"
              name="fname"
              id="defaultRegisterFormFirstName"
              class="form-control"
              placeholder="First name"
            />
          </div>
          <div class="col">
            <input
              type="text"
              name="lname"
              id="defaultRegisterFormLastName"
              class="form-control"
              placeholder="Last name"
            />
          </div>
        </div>

        <input
          type="text"
          name="username"
          class="form-control mb-4"
          placeholder="User Name"
        />
        <input
          type="email"
          name="email"
          id="defaultRegisterFormEmail"
          class="form-control mb-4"
          placeholder="E-mail"
        />

        <input
          type="password"
          name="password"
          id="defaultRegisterFormPassword"
          class="form-control"
          placeholder="Password"
          aria-describedby="defaultRegisterFormPasswordHelpBlock"
        />
        <small
          id="defaultRegisterFormPasswordHelpBlock"
          class="form-text text-muted mb-4"
        >
          At least 8 characters and 1 digit
        </small>

        <input
          type="password"
          name="confirmPassword"
          id="defaultRegisterFormPassword"
          class="form-control"
          placeholder="Confirm Password"
          aria-describedby="defaultRegisterFormPasswordHelpBlock"
        />
        <button class="btn btn-info my-4 btn-block" type="submit">
          Sign Up
        </button>
      </form>
    </div>

    <script
      type="text/javascript"
      src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
    ></script>
    <script
      type="text/javascript"
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"
    ></script>
    <script
      type="text/javascript"
      src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"
    ></script>
    <script
      type="text/javascript"
      src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"
    ></script>
  </body>
</html>
