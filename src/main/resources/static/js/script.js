// Get references to the links and iframe
const homeLink = document.getElementById("home");
const statementLink = document.getElementById("statement");
const coursesLink = document.getElementById("courses");
const iframe = document.getElementById("userFrame");

// Set the initial source for the iframe

// Add click event listeners to the links
homeLink.addEventListener("click", () => {
  iframe.src = "http://localhost:8080/user/home"; // Update the iframe source for Home
});

statementLink.addEventListener("click", () => {
  iframe.src = "http://localhost:8080/user/dashboard/statement"; // Update the iframe source for Statement of Results
});

coursesLink.addEventListener("click", () => {
  iframe.src = "courses.html"; // Update the iframe source for Registered Courses
});
