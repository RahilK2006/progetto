document.addEventListener('DOMContentLoaded', () => {
  const loginForm = document.getElementById('loginForm');
  const errorMessage = document.getElementById('loginMessage');
  
  // Aggiungi l'evento di click al pulsante di login
  document.getElementById('loginBtn').addEventListener('click', function(event) {
    event.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const userType = document.getElementById("userType").value; // Ottieni il tipo di utente

    // Impostiamo l'URL in base al tipo di utente
    let url = '';
    switch (userType) {
      case 'cliente':
        url = `http://localhost:8080/cliente/login?username=${encodeURIComponent(username)}&password=${password}`;
        break;
      case 'admin':
        url = `http://localhost:8080/admin/login?username=${encodeURIComponent(username)}&password=${password}`;
        break;
      case 'fornitore':
        url = `http://localhost:8080/fornitore/login?username=${encodeURIComponent(username)}&password=${password}`;
        break;
      case 'conducente':
        url = `http://localhost:8080/conducente/login?username=${encodeURIComponent(username)}&password=${password}`;
        break;
      default:
        errorMessage.textContent = "Seleziona un tipo di utente.";
        return;
    }

    // Effettuare la richiesta di login
    fetch(url)
      .then(response => {
        if (!response.ok) {
          throw new Error("Credenziali errate");
        }
        return response.json();
      })
      .then(user => {
        // Salva l'utente nel sessionStorage
        sessionStorage.setItem("user", JSON.stringify(user));
        
        // Redirigi l'utente alla pagina corretta in base al tipo
        switch (userType) {
          case 'cliente':
            window.location.href = "cliente/cliente.html"; // Pagine per cliente
            break;
          case 'admin':
            window.location.href = "admin/admin.html"; // Pagine per admin
            break;
          case 'fornitore':
            window.location.href = "fornitore/fornitore.html"; // Pagine per fornitore
            break;
          case 'conducente':
            window.location.href = "conducente/conducente.html"; // Pagine per conducente
            break;
        }
      })
      .catch(err => {
        console.error("Errore di login:", err);
        if (errorMessage) {
          errorMessage.textContent = err.message || "Errore di connessione al server.";
        }
      });
  });
});

  document.getElementById('registerBtn').addEventListener('click', () => {
    window.location.href = 'cliente/registrazione.html';
  });
