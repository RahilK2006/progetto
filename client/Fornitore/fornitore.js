document.addEventListener('DOMContentLoaded', () => {
  const fornitoreSalvato = sessionStorage.getItem("user");
  const fornitoreDetails = document.getElementById("fornitoreDetails");
    const ruolo = sessionStorage.getItem("ruolo"); // Recupera i dati del cliente dalla sessione

  if (fornitoreSalvato && ruolo=="fornitore") {
    const fornitore = JSON.parse(fornitoreSalvato);
  fornitoreDetails.innerHTML = `
    <div class="card">
      <div class="card-header bg-primary text-white">
        <h5 class="mb-0">Dettagli Fornitore</h5>
      </div>
      <ul class="list-group list-group-flush">
        <li class="list-group-item"><strong>ID:</strong> ${fornitore.id}</li>
        <li class="list-group-item"><strong>Nome:</strong> ${fornitore.nome}</li>
        <li class="list-group-item"><strong>Cognome:</strong> ${fornitore.cognome}</li>
        <li class="list-group-item"><strong>Azienda:</strong> ${fornitore.azienda}</li>
        <li class="list-group-item"><strong>Email:</strong> ${fornitore.email}</li>
      </ul>
    </div>
  `;
  } else {
    window.location.href = "../index.html"; // Redirigi al login se non è loggato
  }


});
document.addEventListener('DOMContentLoaded', () => {
  const modificaBtn = document.getElementById("modMerce");

  if (modificaBtn) {
    modificaBtn.addEventListener("click", () => {
      window.location.href = "modificaMerce.html";  // Reindirizza al login
    });
  } 
});
document.addEventListener('DOMContentLoaded', () => {
  const modificaBtn = document.getElementById("modPolizze");

  if (modificaBtn) {
    modificaBtn.addEventListener("click", () => {
      window.location.href = "modificaPolizza.html";  // Reindirizza al login
    });
  } 
});