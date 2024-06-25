// scripts.js

// Function to change the background color of the page
function changeBackgroundColor(color) {
    document.body.style.backgroundColor = color;
}

// Event listener for the login button
document.getElementById("loginButton").addEventListener("click", function() {
    changeBackgroundColor("#f8d7da"); // Change background color to red
});

// Event listener for the register button
document.getElementById("registerButton").addEventListener("click", function() {
    changeBackgroundColor("#d4edda"); // Change background color to green
});
