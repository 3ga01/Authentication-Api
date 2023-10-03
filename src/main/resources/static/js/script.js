var homeLink = document.getElementById("home");
var statementLink = document.getElementById("statement");

console.log("Hello");

function toggleDisplay(element) {
  if (element.style.display === "none" || element.style.display === "") {
    element.style.display = "block";
  } else {
    element.style.display = "none";
  }
}

statementLink.addEventListener("click", function () {
  toggleDisplay(statementLink);
});

homeLink.addEventListener("click", function () {
  toggleDisplay(homeLink);
});
