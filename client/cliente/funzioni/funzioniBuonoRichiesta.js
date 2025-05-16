  const user = JSON.parse(sessionStorage.getItem("user"));
  const idCliente = user?.id;

  let polizze = [];  // Polizze disponibili
  let richieste = []; // Richieste esistenti

  async function caricaPolizze() {
    const select = document.getElementById('polizzaSelect');
    select.innerHTML = '<option value="">Caricamento polizze...</option>';

    try {
      const response = await fetch(`http://localhost:8080/richiestaBuono/polizzeDisponibili?idCliente=${idCliente}`);
      if (!response.ok) throw new Error('Errore caricamento polizze');

      polizze = await response.json();

      if (polizze.length === 0) {
        select.innerHTML = '<option value="">Nessuna polizza disponibile</option>';
        document.getElementById('dettagliPolizza').textContent = '';
        return;
      }

      select.innerHTML = '<option value="">-- Seleziona una polizza --</option>';
      polizze.forEach(p => {
        const option = document.createElement('option');
        option.value = p.id;
        option.textContent = `Polizza #${p.id} - Peso totale: ${p.peso_totale.toFixed(2)} kg`;
        select.appendChild(option);
      });

      document.getElementById('dettagliPolizza').textContent = '';
    } catch (error) {
      select.innerHTML = '<option value="">Errore nel caricamento</option>';
      console.error(error);
    }
  }

  function mostraDettagliPolizza() {
    const select = document.getElementById('polizzaSelect');
    const dettagliDiv = document.getElementById('dettagliPolizza');
    const idSelezionato = select.value;

    if (!idSelezionato) {
      dettagliDiv.textContent = '';
      return;
    }

    const polizza = polizze.find(p => p.id == idSelezionato);
    if (!polizza) {
      dettagliDiv.textContent = 'Dettagli polizza non trovati.';
      return;
    }

    // Calcolo peso richiesto totale per questa polizza (solo richieste approvate o in attesa)
    const pesoRichiestoTotale = richieste
      .filter(r => r.id_polizza == polizza.id && (r.stato === 'approvata' || r.stato === 'in attesa'))
      .reduce((sum, r) => sum + r.peso_richiesto, 0);

    const pesoResiduo = polizza.peso_totale - pesoRichiestoTotale;

    dettagliDiv.innerHTML = `
      <strong>Dettagli Polizza #${polizza.id}</strong><br>
      Viaggio ID: ${polizza.id_viaggio}<br>
      Fornitore ID: ${polizza.id_fornitore}<br>
      Cliente ID: ${polizza.id_cliente}<br>
      Tipologia Merce: ${polizza.tipologia_merce}<br>
      Peso Totale: ${polizza.peso_totale.toFixed(2)} kg<br>
      Peso già richiesto: ${pesoRichiestoTotale.toFixed(2)} kg<br>
      Peso residuo disponibile: ${pesoResiduo.toFixed(2)} kg<br>
      Giorni Franchigia: ${polizza.giorni_franchigia}<br>
      Tariffa Giornaliera: €${polizza.tariffa_giornaliera.toFixed(2)}
    `;
  }

  async function caricaRichieste() {
    const tbody = document.getElementById('tabellaRichieste').querySelector('tbody');
    tbody.innerHTML = '<tr><td colspan="5">Caricamento richieste...</td></tr>';

    try {
      const response = await fetch(`http://localhost:8080/richiestaBuono/getByCliente?idCliente=${idCliente}`);
      if (!response.ok) throw new Error('Errore caricamento richieste');

      richieste = await response.json();

      if (richieste.length === 0) {
        tbody.innerHTML = '<tr><td colspan="5">Nessuna richiesta effettuata</td></tr>';
        return;
      }

      tbody.innerHTML = '';
      richieste.forEach(r => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
          <td>${r.id}</td>
          <td>${r.id_polizza}</td>
          <td>${r.peso_richiesto.toFixed(2)}</td>
          <td>${new Date(r.data_richiesta).toLocaleDateString()}</td>
          <td>${r.stato}</td>
        `;
        tbody.appendChild(tr);
      });

      // Aggiorna dettagli polizza nel caso sia selezionata
      mostraDettagliPolizza();

    } catch (error) {
      tbody.innerHTML = '<tr><td colspan="5">Errore nel caricamento</td></tr>';
      console.error(error);
    }
  }

  async function inviaRichiesta() {
    const select = document.getElementById('polizzaSelect');
    const pesoInput = document.getElementById('pesoRichiesto');

    const idPolizza = select.value;
    const pesoRichiesto = parseFloat(pesoInput.value);

    if (!idPolizza) {
      alert('Seleziona una polizza.');
      return;
    }

    if (isNaN(pesoRichiesto) || pesoRichiesto <= 0) {
      alert('Inserisci un peso richiesto valido (> 0).');
      return;
    }

    const polizza = polizze.find(p => p.id == idPolizza);
    if (!polizza) {
      alert('Polizza non trovata.');
      return;
    }

    // Calcolo peso già richiesto (approvato + in attesa)
    const pesoRichiestoTotale = richieste
      .filter(r => r.id_polizza == polizza.id && (r.stato === 'approvata' || r.stato === 'in attesa'))
      .reduce((sum, r) => sum + r.peso_richiesto, 0);

    const pesoResiduo = polizza.peso_totale - pesoRichiestoTotale;

    if (pesoRichiesto > pesoResiduo) {
      alert(`Errore: il peso richiesto (${pesoRichiesto.toFixed(2)} kg) supera il peso residuo disponibile (${pesoResiduo.toFixed(2)} kg) sulla polizza.`);
      return;
    }

    const data = {
      id_cliente: idCliente,
      id_polizza: parseInt(idPolizza),
      peso_richiesto: pesoRichiesto
    };

    try {
      const response = await fetch('http://localhost:8080/richiestaBuono/add', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
      });

      if (!response.ok) {
        const errorData = await response.json();
        alert(`Errore: ${errorData.message || 'Impossibile inviare richiesta.'}`);
        return;
      }

      alert('Richiesta inviata con successo!');
      pesoInput.value = '';
      await caricaRichieste();
      await caricaPolizze();
      mostraDettagliPolizza();

    } catch (error) {
      alert('Errore di rete o server.');
      console.error(error);
    }
  }

  // All'avvio carica polizze e richieste
  caricaPolizze();
  caricaRichieste();