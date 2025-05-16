document.addEventListener('DOMContentLoaded', () => {
  const adminSalvato = sessionStorage.getItem("user");
  const adminDetails = document.getElementById("adminDetails");
  const ruolo = sessionStorage.getItem("ruolo"); // Recupera i dati del cliente dalla sessione

  if (adminSalvato && ruolo=="admin") {
    const admin = JSON.parse(adminSalvato);
    adminDetails.innerHTML = `      <div class="card-header bg-primary text-white">
        <h5 class="mb-0">Dettagli Admin</h5>
      </div>
      <ul class="list-group list-group-flush">
        <li class="list-group-item"><strong>ID:</strong> ${admin.id}</li>
        <li class="list-group-item"><strong>Nome:</strong> ${admin.nome}</li>
        <li class="list-group-item"><strong>Cognome:</strong> ${admin.cognome}</li>
      </ul>
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

document.addEventListener('DOMContentLoaded', () => {
  const modificaBtn = document.getElementById("modLinea");

  if (modificaBtn) {
    modificaBtn.addEventListener("click", () => {
      window.location.href = "modificaLinea.html";  // Reindirizza al login
    });
  } 
});

document.addEventListener('DOMContentLoaded', () => {
  const modificaBtn = document.getElementById("modViaggi");

  if (modificaBtn) {
    modificaBtn.addEventListener("click", () => {
      window.location.href = "modificaViaggio.html";  // Reindirizza al login
    });
  } 
});

document.addEventListener('DOMContentLoaded', () => {
  const modificaBtn = document.getElementById("modBuoni");

  if (modificaBtn) {
    modificaBtn.addEventListener("click", () => {
      window.location.href = "modificaBuoni.html";  // Reindirizza al login
    });
  } 
});