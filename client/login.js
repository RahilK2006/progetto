document.addEventListener('DOMContentLoaded', () => {
    // Verifica se c'è già un utente loggato
    const ruolo = sessionStorage.getItem("ruolo");
    if (ruolo) {

        // Reindirizza alla pagina corretta in base al tipo di utente
        if (ruolo=="cliente") {
            window.location.href = "cliente/cliente.html"; // Se è un cliente
        } else if (ruolo === 'admin') {
            window.location.href = "admin/admin.html"; // Se è un admin
        } else if (ruolo=="fornitore") {
            window.location.href = "fornitore/fornitore.html"; // Se è un fornitore
        } else if (ruolo=="conducente") {
            window.location.href = "conducente/conducente.html"; // Se è un conducente
        }
    }

    // Il resto del codice per il login

    const loginForm = document.getElementById('loginForm');
    const errorMessage = document.getElementById('loginMessage');
    
    document.getElementById('loginBtn').addEventListener('click', function(event) {
        event.preventDefault();

        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;
        const userType = document.getElementById("userType").value;

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

        fetch(url, { method: 'get' })
            .then(response => {
                if (!response.ok) throw new Error("Credenziali errate");
                return response.json();
            })
            .then(user => {
                sessionStorage.setItem("user", JSON.stringify(user));

                switch (userType) {
                    case 'cliente':
                        sessionStorage.setItem("ruolo", "cliente");
                        window.location.href = "cliente/cliente.html";
                        break;
                    case 'admin':
                        sessionStorage.setItem("ruolo", "admin");
                        window.location.href = "admin/admin.html";
                        break;
                    case 'fornitore':                        
                        sessionStorage.setItem("ruolo", "fornitore");
                        window.location.href = "fornitore/fornitore.html";
                        break;
                    case 'conducente':
                        sessionStorage.setItem("ruolo", "conducente");
                        window.location.href = "conducente/conducente.html";
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

    // Bottone di registrazione (solo cliente)
    document.getElementById('registerBtn').addEventListener('click', () => {
        window.location.href = 'cliente/registrazione.html';
    });
});
