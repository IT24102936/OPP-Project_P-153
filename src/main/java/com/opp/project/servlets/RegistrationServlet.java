package com.opp.project.servlets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private String dataFilePath; // Store the platform-independent file path
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    @Override
    public void init() throws ServletException {
        // Use the user's home directory as the base path
        String userHome = System.getProperty("user.home");
        // Create a directory for the app data in the user's home directory
        String appDataDir = userHome + File.separator + "registration-app-data";
        File dir = new File(appDataDir);
        if (!dir.exists()) {
            dir.mkdirs(); // Create the directory if it doesn't exist
        }
        // Set the file path to registrations.txt in the app data directory
        dataFilePath = appDataDir + File.separator + "registrations.txt";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        StringBuilder errorMessage = new StringBuilder();

        if (isEmpty(fullname) || isEmpty(username) || isEmpty(phone) || isEmpty(email) ||
                isEmpty(dob) || isEmpty(gender) || isEmpty(password) || isEmpty(confirmPassword)) {
            errorMessage.append("All fields are required.<br>");
        }

        if (!password.equals(confirmPassword)) {
            errorMessage.append("Passwords do not match.<br>");
        }

        if (!isValidEmail(email)) {
            errorMessage.append("Invalid email format.<br>");
        }

        if (errorMessage.length() > 0) {
            request.setAttribute("error", errorMessage.toString());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        String dataLine = String.format(
                "=== New Registration ===%n" +
                        "Full Name: %s%n" +
                        "Username: %s%n" +
                        "Phone: %s%n" +
                        "Email: %s%n" +
                        "Date of Birth: %s%n" +
                        "Gender: %s%n" +
                        "Password: %s%n%n",
                escapeText(fullname), escapeText(username), escapeText(phone),
                escapeText(email), escapeText(dob), escapeText(gender), escapeText(password));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFilePath, true))) {
            writer.write(dataLine);
            request.setAttribute("message", "Registration successful!");
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("error", "Error saving registration data: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    private boolean isValidEmail(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

    private String escapeText(String value) {
        return value.replace("\n", " ").replace("\r", " ");
    }
}
