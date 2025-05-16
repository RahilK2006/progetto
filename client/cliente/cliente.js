document.addEventListener('DOMContentLoaded', () => {
  const clienteSalvato = sessionStorage.getItem("user"); // Recupera i dati del cliente dalla sessione
  const ruolo = sessionStorage.getItem("ruolo"); // Recupera i dati del cliente dalla sessione

  const clienteDetails = document.getElementById("clienteDetails");
  
  if (clienteSalvato && ruolo=="cliente") {
    const cliente = JSON.parse(clienteSalvato);  // Converte i dati da JSON a oggetto cliente
    
    // Visualizza i dettagli del cliente
    clienteDetails.innerHTML = `
      <div class="card-header bg-success text-white">
        <h5 class="mb-0">Dettagli Cliente</h5>
      </div>
      <ul class="list-group list-group-flush">
        <li class="list-group-item"><strong>ID:</strong> ${cliente.id}</li>
        <li class="list-group-item"><strong>Nome:</strong> ${cliente.nome}</li>
        <li class="list-group-item"><strong>Cognome:</strong> ${cliente.cognome}</li>
        <li class="list-group-item"><strong>Email:</strong> ${cliente.email}</li>
        <li class="list-group-item"><strong>Username:</strong> ${cliente.username}</li>
        <li class="list-group-item"><strong>Azienda:</strong> ${cliente.azienda}</li>
      </ul>
    `;
  } else {
    // Se il cliente non è loggato, reindirizza alla pagina di login
    window.location.href = "../index.html";
  }


});


document.addEventListener('DOMContentLoaded', () => {
  const modificaBtn = document.getElementById("richiestaBuoni");

  if (modificaBtn) {
    modificaBtn.addEventListener("click", () => {
      window.location.href = "richiestaBuoni.html";  // Reindirizza al login
    });
  } 
});

document.addEventListener('DOMContentLoaded', () => {
  const modificaBtn = document.getElementById("buoni");

  if (modificaBtn) {
    modificaBtn.addEventListener("click", () => {
      window.location.href = "buoniCliente.html";  // Reindirizza al login
    });
  } 
});



