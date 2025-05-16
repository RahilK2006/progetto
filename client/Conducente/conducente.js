document.addEventListener('DOMContentLoaded', () => {
  const conducenteSalvato = sessionStorage.getItem("user");
  const conducenteDetails = document.getElementById("conducenteDetails");
  const ruolo = sessionStorage.getItem("ruolo"); // Recupera il ruolo dalla sessione

  // Verifica se l'utente è loggato e ha il ruolo di "conducente"
  if (conducenteSalvato && ruolo === "conducente") {
    const conducente = JSON.parse(conducenteSalvato);  // Converte i dati in un oggetto JavaScript

    // Mostra i dettagli del conducente
    conducenteDetails.innerHTML = `
      <div class="card-header bg-success text-white">
      <h5 class="mb-0">Dettagli Conducente</h5>
    </div>
    <ul class="list-group list-group-flush">
      <li class="list-group-item"><strong>ID:</strong> ${conducente.id}</li>
      <li class="list-group-item"><strong>Nome:</strong> ${conducente.nome}</li>
      <li class="list-group-item"><strong>Cognome:</strong> ${conducente.cognome}</li>
      <li class="list-group-item"><strong>Email:</strong> ${conducente.email}</li>
      <li class="list-group-item"><strong>Username:</strong> ${conducente.username}</li>
    </ul>
  `;
  } else {
    // Se non è loggato o non ha il ruolo corretto, reindirizza al login
    window.location.href = "../index.html";
  }

  // Logout

});
