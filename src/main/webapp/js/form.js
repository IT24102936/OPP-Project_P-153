// Password validation script
document.getElementById('registrationForm').addEventListener('submit', function(event) {
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmpassword').value;
    const errorMessage = document.getElementById('error-message');

    // Clear any previous error message
    errorMessage.textContent = '';

    // Check if the password is at least 8 characters long
    if (password.length < 8) {
        errorMessage.textContent = 'Password must be at least 8 characters long.';
        event.preventDefault(); // Prevent form submission
        return;
    }

    // Check if password and confirm password match
    if (password !== confirmPassword) {
        errorMessage.textContent = 'Passwords do not match.';
        event.preventDefault(); // Prevent form submission
        return;
    }
});
