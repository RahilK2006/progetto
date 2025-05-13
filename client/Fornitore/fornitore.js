document.addEventListener('DOMContentLoaded', () => {
  const fornitoreSalvato = sessionStorage.getItem("user");
  const fornitoreDetails = document.getElementById("fornitoreDetails");
    const ruolo = sessionStorage.getItem("ruolo"); // Recupera i dati del cliente dalla sessione

  if (fornitoreSalvato && ruolo=="fornitore") {
    const fornitore = JSON.parse(fornitoreSalvato);
    fornitoreDetails.innerHTML = `
      <div class="fornitore-details"><span>ID:</span> ${fornitore.id}</div>
      <div class="fornitore-details"><span>Nome:</span> ${fornitore.nome}</div>
      <div class="fornitore-details"><span>Cognome:</span> ${fornitore.cognome}</div>
      <div class="fornitore-details"><span>Azienda:</span> ${fornitore.azienda}</div>
      <div class="fornitore-details"><span>Email:</span> ${fornitore.email}</div>
    `;
  } else {
    window.location.href = "../index.html"; // Redirigi al login se non è loggato
  }

  document.getElementById('logoutBtn').addEventListener('click', () => {
    sessionStorage.removeItem("user");
        window.location.href = '../index.html';
  });
});
