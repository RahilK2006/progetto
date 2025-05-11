document.addEventListener('DOMContentLoaded', () => {
  const logoutBtn = document.getElementById("logoutBtn");

  if (logoutBtn) {
    logoutBtn.addEventListener("click", () => {
      sessionStorage.removeItem("cliente"); // Rimuove l'utente
      window.location.href = "../index.html";  // Reindirizza al login
    });
  } else {
    console.warn("Bottone logout non trovato.");
  }
});