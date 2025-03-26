package com.opp.project.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");

        // Prepare data to be saved
        String data = "Full Name: " + fullname + "\n" +
                "Username: " + username + "\n" +
                "Phone: " + phone + "\n" +
                "Email: " + email + "\n" +
                "Date of Birth: " + dob + "\n" +
                "Gender: " + gender + "\n" +
                "Password: " + password + "\n" +
                "--------------------------------------\n";

        String filePath = "C:/data/student_data.txt";

        // Debugging: Print the file path to confirm
        System.out.println("File will be saved to: " + filePath);

        // Check if the directory exists, if not, create it
        File file = new File(filePath);
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs(); // Create the directory if it doesn't exist
        }

        // Write data to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(data);  // Append data to the file
            writer.newLine();     // Ensure a new line for each entry
        } catch (IOException e) {
            e.printStackTrace();
            response.getWriter().println("<html><body><h2>Error saving file: " + e.getMessage() + "</h2></body></html>");
            return;
        }

        // Send a success message to the user
        response.setContentType("text/html");
        response.getWriter().println("<html><body><h2>Registration Successful!</h2></body></html>");
    }
}
