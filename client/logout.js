document.addEventListener('DOMContentLoaded', () => {
  const logoutBtn = document.getElementById("logoutBtn");

  if (logoutBtn) {
    logoutBtn.addEventListener("click", () => {
      sessionStorage.removeItem("user");  // Rimuove l'utente
      sessionStorage.removeItem("ruolo"); // Rimuove il ruolo
      window.location.href = "../index.html";  // Reindirizza al login
    });
  } else {
    console.warn("Bottone logout non trovato.");
  }
});
