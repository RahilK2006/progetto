document.addEventListener('DOMContentLoaded', () => {
  const conducenteSalvato = sessionStorage.getItem("user");
  const conducenteDetails = document.getElementById("conducenteDetails");
  const ruolo = sessionStorage.getItem("ruolo"); // Recupera il ruolo dalla sessione

  // Verifica se l'utente è loggato e ha il ruolo di "conducente"
  if (conducenteSalvato && ruolo === "conducente") {
    const conducente = JSON.parse(conducenteSalvato);  // Converte i dati in un oggetto JavaScript

    // Mostra i dettagli del conducente
    conducenteDetails.innerHTML = `
      <div class="conducente-details"><span>ID:</span> ${conducente.id}</div>
      <div class="conducente-details"><span>Nome:</span> ${conducente.nome}</div>
      <div class="conducente-details"><span>Cognome:</span> ${conducente.cognome}</div>
      <div class="conducente-details"><span>Username:</span> ${conducente.username}</div>
      <div class="conducente-details"><span>Email:</span> ${conducente.email}</div>
    `;
  } else {
    // Se non è loggato o non ha il ruolo corretto, reindirizza al login
    window.location.href = "../index.html";
  }

  // Logout

});
