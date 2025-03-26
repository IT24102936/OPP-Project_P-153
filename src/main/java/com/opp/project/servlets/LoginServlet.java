package com.opp.project.servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private String dataFilePath; // Path to registrations.txt

    @Override
    public void init() throws ServletException {
        // Use the user's home directory as the base path (platform-independent)
        String userHome = System.getProperty("user.home");
        String appDataDir = userHome + File.separator + "Desktop/Project/OPP-Project_P-153/src/main/resources/data";
        File dir = new File(appDataDir);
        if (!dir.exists()) {
            dir.mkdirs(); // Create the directory if it doesn't exist
        }
        dataFilePath = appDataDir + File.separator + "student.txt";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate credentials by reading the registrations.txt file
        boolean isAuthenticated = authenticateUser(username, password);

        if (isAuthenticated) {
            // On successful login, redirect to welcome page
            request.setAttribute("username", username);
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        } else {
            // On failure, redirect back to login page with error message
            request.setAttribute("error", "Invalid username or password.");
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
    }

    private boolean authenticateUser(String username, String password) throws IOException {
        File file = new File(dataFilePath);
        if (!file.exists()) {
            return false; // No users registered yet
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String currentUsername = null;
            String currentPassword = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Username: ")) {
                    currentUsername = line.substring("Username: ".length()).trim();
                } else if (line.startsWith("Password: ")) {
                    currentPassword = line.substring("Password: ".length()).trim();
                    // Check if the current entry matches the provided credentials
                    if (currentUsername != null && currentUsername.equals(username) &&
                            currentPassword != null && currentPassword.equals(password)) {
                        return true;
                    }
                }
            }
        }
        return false; // No match found
    }
}
