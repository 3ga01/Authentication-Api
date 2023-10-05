// Get references to the links and iframe
const homeLink = document.getElementById("home");
const statementLink = document.getElementById("statement");
const coursesLink = document.getElementById("courses");
const iframe = document.getElementById("userFrame");
const library = document.getElementById("library");
const questions = document.getElementById("questions");
const learning = document.getElementById("learning");
const exam = document.getElementById("exam");
const assignments = document.getElementById("assignments");
const fees = document.getElementById("fees");
const clubs = document.getElementById("clubs");
const events = document.getElementById("events");
const annoucements = document.getElementById("annoucements");
const info = document.getElementById("info");

// Set the initial source for the iframe

// Add click event listeners to the links
homeLink.addEventListener("click", () => {
  iframe.src = "http://localhost:8080/user/home"; // Update the iframe source for Home
});

statementLink.addEventListener("click", () => {
  iframe.src = "http://localhost:8080/user/dashboard/statement"; // Update the iframe source for Statement of Results
});

coursesLink.addEventListener("click", () => {
  iframe.src = "http://localhost:8080/user/dashboard/courses"; // Update the iframe source for Registered Courses
});
library.addEventListener("click", () => {
  iframe.src = "http://localhost:8080/user/dashboard/libraryServices"; // Update the iframe source for Registered Courses
});
questions.addEventListener("click", () => {
  iframe.src = "http://localhost:8080/user/dashboard/pastQuestions"; // Update the iframe source for Registered Courses
});
learning.addEventListener("click", () => {
  iframe.src = "http://localhost:8080/user/dashboard/learningMaterials"; // Update the iframe source for Registered Courses
});
exam.addEventListener("click", () => {
  iframe.src = "http://localhost:8080/user/dashboard/exams"; // Update the iframe source for Registered Courses
});
assignments.addEventListener("click", () => {
  iframe.src = "http://localhost:8080/user/dashboard/assignments"; // Update the iframe source for Registered Courses
});
fees.addEventListener("click", () => {
  iframe.src = "http://localhost:8080/user/dashboard/fees"; // Update the iframe source for Registered Courses
});
clubs.addEventListener("click", () => {
  iframe.src = "http://localhost:8080/user/dashboard/clubs"; // Update the iframe source for Registered Courses
});
events.addEventListener("click", () => {
  iframe.src = "http://localhost:8080/user/dashboard/upComingEvents"; // Update the iframe source for Registered Courses
});
annoucements.addEventListener("click", () => {
  iframe.src = "http://localhost:8080/user/dashboard/annoucements"; // Update the iframe source for Registered Courses
});
info.addEventListener("click", () => {
  iframe.src = "http://localhost:8080/user/dashboard/userInfo"; // Update the iframe source for Registered Courses
});
courses.addEventListener("click", () => {
  iframe.src = "http://localhost:8080/user/dashboard/courses"; // Update the iframe source for Registered Courses
});
