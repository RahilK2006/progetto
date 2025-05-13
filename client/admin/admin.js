document.addEventListener('DOMContentLoaded', () => {
  const adminSalvato = sessionStorage.getItem("user");
  const adminDetails = document.getElementById("adminDetails");
  const ruolo = sessionStorage.getItem("ruolo"); // Recupera i dati del cliente dalla sessione

  if (adminSalvato && ruolo=="admin") {
    const admin = JSON.parse(adminSalvato);
    adminDetails.innerHTML = `
      <div class="admin-details"><span>ID:</span> ${admin.id}</div>
      <div class="admin-details"><span>Nome:</span> ${admin.nome}</div>
      <div class="admin-details"><span>Cognome:</span> ${admin.cognome}</div>
    `;
  } else {
    window.location.href = "../index.html"; // Redirigi al login se non è loggato
  }


});
document.addEventListener('DOMContentLoaded', () => {
  const modificaBtn = document.getElementById("modNave");

  if (modificaBtn) {
    modificaBtn.addEventListener("click", () => {
      window.location.href = "modificaNave.html";  // Reindirizza al login
    });
  } 
});
document.addEventListener('DOMContentLoaded', () => {
  const modificaBtn = document.getElementById("modPorti");

  if (modificaBtn) {
    modificaBtn.addEventListener("click", () => {
      window.location.href = "modificaPorto.html";  // Reindirizza al login
    });
  } 
});