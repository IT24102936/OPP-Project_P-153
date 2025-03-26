<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Login</title>
    <link rel="stylesheet" href="./css/form.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
<section class="container">
    <header>Student Login</header>
    <form action="LoginServlet" method="POST" class="form" id="loginForm">
        <div class="input-box">
            <i class="fa-solid fa-user" style="font-size: 15px; color: #333;"></i>
            <label>Username</label>
            <input type="text" name="username" id="username" placeholder="Enter your username" required>
        </div>
        <div class="input-box">
            <i class="fa-solid fa-key" style="font-size: 13px; color: #333;"></i>
            <label>Password</label>
            <input type="password" name="password" id="password" placeholder="Enter your password" required>
        </div>
        <div id="error-message" style="color: red;">
            <%-- Display error message if login fails --%>
            <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
    <footer>Don't have an account? <a href="Registration.jsp">Register here</a></footer>
</section>
<script src="./js/form.js"></script>
</body>
</html>