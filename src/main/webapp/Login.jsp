<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <link rel="stylesheet" href="./css/form.css"><!-- Link to the external CSS file -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
<section class="container">
  <header>Login</header>
  <form action="/login" class="form" id="loginForm">
    <div class="input-box">
      <label>Username</label>
      <input type="text" name="username" id="username" placeholder="Enter your username" required>
    </div>
    <div class="input-box">
      <label>Password</label>
      <input type="password" name="password" id="password" placeholder="Enter your password" required>
    </div>
    <div id="error-message" style="color: red;"></div>
    <button type="submit" class="btn btn-primary">Login</button>
  </form>
  <footer>Don't have an account? <a href="jsp/Registration.jsp">Register here</a> </footer>
</section>

<script src="./js/form.js"></script> <!-- Link to the external JS file -->
</body>
</html>
