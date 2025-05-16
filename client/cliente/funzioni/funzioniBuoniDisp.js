    // Recupera l'id cliente dalla sessione (modifica secondo la tua gestione autenticazione)
    const user = JSON.parse(sessionStorage.getItem("user"));
    const idCliente = user?.id;

    async function caricaBuoni() {
      const tbody = document.querySelector('#tabellaBuoni tbody');
      const messaggio = document.getElementById('messaggio');
      messaggio.textContent = '';
      if (!idCliente) {
        tbody.innerHTML = '<tr><td colspan="4">Utente non autenticato.</td></tr>';
        return;
      }

      tbody.innerHTML = '<tr><td colspan="4">Caricamento buoni...</td></tr>';

      try {
        const response = await fetch(`http://localhost:8080/buono/getByCliente?idCliente=${idCliente}`);
        if (!response.ok) throw new Error('Errore nel caricamento dei buoni.');

        const buoni = await response.json();

        if (buoni.length === 0) {
          tbody.innerHTML = '<tr><td colspan="4">Nessun buono trovato.</td></tr>';
          return;
        }

        tbody.innerHTML = '';
        buoni.forEach(buono => {
          const tr = document.createElement('tr');
          tr.innerHTML = `
            <td>${buono.id}</td>
            <td>${buono.id_polizza}</td>
            <td>${buono.peso_riferito.toFixed(2)}</td>
            <td>${new Date(buono.data_emissione).toLocaleString()}</td>
          `;
          tbody.appendChild(tr);
        });

      } catch (error) {
        tbody.innerHTML = '<tr><td colspan="4">Errore nel caricamento dei buoni.</td></tr>';
        messaggio.textContent = error.message;
        console.error(error);
      }
    }

    caricaBuoni();