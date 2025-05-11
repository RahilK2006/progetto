document.addEventListener('DOMContentLoaded', () => {
    const conducenteSalvato = sessionStorage.getItem("user");
    if (!conducenteSalvato) {
        // Se non c'è un conducente loggato, rimanda al login
        window.location.href = "login.html";
        return;
    }

    const conducente = JSON.parse(conducenteSalvato);
    const conducenteDetails = document.getElementById("conducenteDetails");

    // Mostra i dettagli del conducente
    conducenteDetails.innerHTML = `
        <div class="conducente-details">
          <span>Nome: </span>${conducente.nome}
        </div>
        <div class="conducente-details">
            <span>Cognome: </span>${conducente.cognome}
        </div>    
        <div class="conducente-details">
            <span>Username: </span>${conducente.username}
        </div>
        <div class="conducente-details">
            <span>Email: </span>${conducente.email}
        </div>

    `;

    // Logout
    document.getElementById("logoutBtn").addEventListener("click", () => {
        sessionStorage.removeItem("user");
        window.location.href = '../index.html';
    });
});
