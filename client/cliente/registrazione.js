document.addEventListener('DOMContentLoaded', () => {
  const form = document.getElementById('registerForm');
  const message = document.getElementById('registerMessage');

  form.addEventListener('submit', function (event) {
    event.preventDefault();

    const cliente = {
      nome: document.getElementById('nome').value,
      cognome: document.getElementById('cognome').value,
      email: document.getElementById('email').value,
      username: document.getElementById('username').value,
      password: document.getElementById('password').value,
      azienda: document.getElementById('azienda').value
    };

    fetch('http://localhost:8080/cliente/register', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(cliente)
    })
    .then(response => {
      if (!response.ok) {
        throw new Error("Registrazione fallita.");
      }
      return response.json();
    })
    .then(data => {
      alert('Registrazione completata!');
      window.location.href = '../index.html';
    })
    .catch(error => {
      message.textContent = error.message || 'Errore nella registrazione.';
    });
  });
});
