document.addEventListener('DOMContentLoaded', () => {
  const clienteSalvato = sessionStorage.getItem("user"); // Recupera i dati del cliente dalla sessione
  const clienteDetails = document.getElementById("clienteDetails");
  
  if (clienteSalvato) {
    const cliente = JSON.parse(clienteSalvato);  // Converte i dati da JSON a oggetto cliente
    
    // Visualizza i dettagli del cliente
    clienteDetails.innerHTML = `
      <div class="cliente-details"><span>ID:</span> ${cliente.id}</div>
      <div class="cliente-details"><span>Nome:</span> ${cliente.nome}</div>
      <div class="cliente-details"><span>Cognome:</span> ${cliente.cognome}</div>
      <div class="cliente-details"><span>Email:</span> ${cliente.email}</div>
      <div class="cliente-details"><span>Username:</span> ${cliente.username}</div>
      <div class="cliente-details"><span>Azienda:</span> ${cliente.azienda}</div>
    `;
  } else {
    // Se il cliente non è loggato, reindirizza alla pagina di login
    window.location.href = "login.html";
  }

  // Funzione di logout
  document.getElementById('logoutBtn').addEventListener('click', () => {
    sessionStorage.removeItem("user");  // Rimuove il cliente dalla sessione
    window.location.href = '../index.html';  // Redirige alla pagina di login
  });
});
