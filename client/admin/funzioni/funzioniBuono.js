  async function caricaRichieste() {
    const tbody = document.querySelector('#tabellaRichieste tbody');
    tbody.innerHTML = '<tr><td colspan="7">Caricamento...</td></tr>';

    try {
      const response = await fetch('http://localhost:8080/richiestaBuono/getAll');
      if (!response.ok) throw new Error("Errore fetch richieste");
      const richieste = await response.json();

      if (richieste.length === 0) {
        tbody.innerHTML = '<tr><td colspan="7">Nessuna richiesta trovata.</td></tr>';
        return;
      }

      tbody.innerHTML = '';
      richieste.forEach(r => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
          <td>${r.id}</td>
          <td>${r.id_polizza}</td>
          <td>${r.id_cliente}</td>
          <td>${r.peso_richiesto.toFixed(2)}</td>
          <td>${new Date(r.data_richiesta).toLocaleDateString()}</td>
          <td>${r.stato}</td>
          <td>
            ${r.stato === 'in attesa' ? `
              <button onclick="accettaRichiesta(${r.id}, ${r.id_polizza}, ${r.id_cliente}, ${r.peso_richiesto})">Accetta</button>
              <button onclick="rifiutaRichiesta(${r.id})">Rifiuta</button>
            ` : ''}
          </td>
        `;
        tbody.appendChild(tr);
      });

    } catch (err) {
      console.error(err);
      tbody.innerHTML = '<tr><td colspan="7">Errore nel caricamento.</td></tr>';
    }
  }

  async function accettaRichiesta(idRichiesta, idPolizza, idCliente, peso) {
    try {
      // 1. Crea buono
      const resBuono = await fetch('http://localhost:8080/buono/crea', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          id_polizza: idPolizza,
          id_cliente: idCliente,
          peso_riferito: peso
        })
      });
      if (!resBuono.ok) {
        alert("Errore nella creazione del buono.");
        return;
      }

      // 2. Aggiorna stato richiesta a "accettata"
await fetch(`http://localhost:8080/richiestaBuono/aggiornaStato?id=${idRichiesta}&stato=approvata`, {
  method: 'POST',
});
      alert("Buono creato e richiesta accettata.");
      caricaRichieste();
    } catch (error) {
      console.error(error);
      alert("Errore durante l'accettazione.");
    }
  }

  async function rifiutaRichiesta(idRichiesta) {
        try {
    await fetch(`http://localhost:8080/richiestaBuono/aggiornaStato?id=${idRichiesta}&stato=rifiutata`, {
    method: 'POST',
    });
      alert("Richiesta rifiutata.");
      caricaRichieste();
    } catch (error) {
      console.error(error);
      alert("Errore nel rifiuto.");
    }
  }

  // Avvio
  caricaRichieste();