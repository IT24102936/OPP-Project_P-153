<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Student Registration</title>
  <link rel="stylesheet" href="../css/form.css"><!-- Link to the external CSS file -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

</head>
<body>
<section class="container">
  <header>Student Registration</header>
  <form action="RegistrationServlet" method="POST" class="form" id="registrationForm">
  <div class="input-box">
      <i class="fa-solid fa-address-card"style="font-size: 13px; color: #333;"></i><label>Full Name</label>
      <input type="text" name="fullname" id="fullname" placeholder="Enter Your full name" required>
    </div>
    <div class="column1">
      <div class="input-box">
        <i class="fa-solid fa-user"style="font-size: 15px; color: #333;"></i><label>Username</label>
        <input type="text" name="username" id="username" placeholder="Choose a username" required>
      </div>
      <div class="input-box">
        <i class="fa-solid fa-phone"style="font-size: 15px; color: #333;"></i><label>Phone Number</label>
        <input type="tel" class="form-control" id="phone" name="phone" required placeholder="Enter your phone number">
      </div>
    </div>
    <div class="input-box">
      <i class="fa-solid fa-envelope"style="font-size: 13px; color: #333;"></i><label>Email</label>
      <input type="email" name="email" id="email" placeholder="Enter your email address" required>
    </div>

    <div class="column1">
      <div class="input-box">
        <i class="fa-solid fa-calendar-days"style="font-size: 13px; color: #333;"></i> <label>Date of Birth</label>
        <input type="date" name="dob" id="dob" required>
      </div>
      <div class="input-box">
        <i class="fa-solid fa-venus-mars"style="font-size: 13px; color: #333;"></i><label>Gender</label>
        <select name="gender" id="gender" class="gender" required>
          <option value="" disabled selected>Select your gender</option>
          <option value="Male">Male</option>
          <option value="Female">Female</option>
          <option value="Other">Other</option>
        </select>
      </div>
    </div>
    <div class="column1">
      <div class="input-box">
        <i class="fa-solid fa-key"style="font-size: 13px; color: #333;"></i><label>Password</label>
        <input type="password" name="password" id="password" placeholder="Enter your password" required>
      </div>
      <div class="input-box">
        <i class="fa-solid fa-lock"style="font-size: 13px; color: #333;"></i><label>Confirm Password</label>
        <input type="password" name="confirmPassword" id="confirmpassword" placeholder="Confirm your password" required>
      </div>
    </div>
    <div id="error-message" style="color: red;"></div>
    <button type="submit" class="btn btn-primary">Register</button>
  </form>
  <footer>Already have an account? <a href="../Login.jsp">Login here</a> </footer>
</section>

<script src="../js/form.js"></script> <!-- Link to the external JS file -->
</body>
</html>
