class PolizzaCarico {
  constructor(id, id_viaggio, id_fornitore, id_cliente, tipologia_merce, peso_totale, giorni_franchigia, tariffa_giornaliera) {
    this.id = id;
    this.id_viaggio = id_viaggio;
    this.id_fornitore = id_fornitore;
    this.id_cliente = id_cliente;
    this.tipologia_merce = tipologia_merce;
    this.peso_totale = peso_totale;
    this.giorni_franchigia = giorni_franchigia;
    this.tariffa_giornaliera = tariffa_giornaliera;
  }

  toJSON() {
    return {
      id: this.id,
      id_viaggio: this.id_viaggio,
      id_fornitore: this.id_fornitore,
      id_cliente: this.id_cliente,
      tipologia_merce: this.tipologia_merce,
      peso_totale: this.peso_totale,
      giorni_franchigia: this.giorni_franchigia,
      tariffa_giornaliera: this.tariffa_giornaliera
    };
  }
}

document.addEventListener("DOMContentLoaded", () => {
    
  const user = JSON.parse(sessionStorage.getItem("user"));
  const idFornitore = user?.id;
    caricaPolizze(idFornitore)
  if (!user || sessionStorage.getItem("ruolo") !== "fornitore") {
    alert("Accesso negato. Effettua il login.");
    window.location.href = "../index.html";
    return;
  }

  // Popola merci (solo del fornitore)
  fetch(`http://localhost:8080/merce/getByFornitore?idFornitore=${idFornitore}`)
    .then(res => res.json())
    .then(data => {
      const selectMerce = document.getElementById("selectMerce");
      data.forEach(merce => {
        const opt = document.createElement("option");
        opt.value = merce.id;
        opt.textContent = merce.tipologia;
        selectMerce.appendChild(opt);
      });
    })
    .catch(err => alert("Errore caricamento merci: " + err.message));

  // Popola clienti
  fetch("http://localhost:8080/cliente/getAll")
    .then(res => res.json())
    .then(data => {
      const selectCliente = document.getElementById("selectCliente");
      data.forEach(cliente => {
        const opt = document.createElement("option");
        opt.value = cliente.id;
        opt.textContent = cliente.nome;
        selectCliente.appendChild(opt);
      });
    })
    .catch(err => alert("Errore caricamento clienti: " + err.message));

  // Popola tabella viaggi
  fetch("http://localhost:8080/viaggio/getAll")
    .then(res => res.json())
    .then(data => {
      const tbody = document.getElementById("tabellaViaggi");
      data.forEach(viaggio => {
        const row = document.createElement("tr");
        row.innerHTML = `
          <td><input type="radio" name="viaggioRadio" value="${viaggio.id}"></td>
          <td>${viaggio.id}</td>
          <td>${viaggio.id_nave}</td>
          <td>${viaggio.porto_partenza}</td>
          <td>${viaggio.porto_arrivo}</td>
          <td>${viaggio.data_partenza}</td>
          <td>${viaggio.data_arrivo}</td>
        `;
        tbody.appendChild(row);
      });
    })
    .catch(err => alert("Errore caricamento viaggi: " + err.message));

  // Gestione creazione polizza
  document.getElementById("creaPolizzaBtn").addEventListener("click", () => {
    const id_merce = document.getElementById("selectMerce").value;
    const id_cliente = document.getElementById("selectCliente").value;
    const id_viaggio = document.querySelector("input[name='viaggioRadio']:checked")?.value;
    const peso_totale_raw = document.getElementById("pesoTotale").value;
    const tariffa_raw = document.getElementById("tariffaGiornaliera").value;
    const giorni_franchigia_raw = document.getElementById("giorniFranchigia").value;

    if (!id_merce || !id_cliente || !id_viaggio || !peso_totale_raw || !tariffa_raw || !giorni_franchigia_raw) {
      alert("Compila tutti i campi.");
      return;
    }

    const peso_totale = parseFloat(peso_totale_raw).toFixed(2);
    const tariffa_giornaliera = parseFloat(tariffa_raw).toFixed(2);
    const giorni_franchigia = parseInt(giorni_franchigia_raw);

    if (isNaN(peso_totale) || isNaN(tariffa_giornaliera) || isNaN(giorni_franchigia)) {
      alert("Inserisci valori numerici validi per peso, tariffa e giorni franchigia.");
      return;
    }

    const polizza = new PolizzaCarico(
      null,
      parseInt(id_viaggio),
      idFornitore,
      parseInt(id_cliente),
      parseInt(id_merce),
      parseFloat(peso_totale),
      giorni_franchigia,
      parseFloat(tariffa_giornaliera)
    );

    fetch("http://localhost:8080/polizza/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(polizza.toJSON())
    })
    .then(res => {
      if (!res.ok) throw new Error("Errore creazione polizza");
      alert("Polizza creata con successo!");
      location.reload();
    })
    .catch(err => alert("Errore: " + err.message));
  });
});
function caricaPolizze(idFornitore) {
  fetch(`http://localhost:8080/polizza/getByFornitore?idFornitore=${idFornitore}`)
    .then(res => res.json())
    .then(data => {
      const tbody = document.getElementById("tabellaPolizze");
      tbody.innerHTML = ""; // pulisco tabella

      data.forEach(polizza => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
          <td>${polizza.id}</td>
          <td>${polizza.id_viaggio}</td>
          <td>${polizza.id_fornitore}</td>
          <td>${polizza.id_cliente}</td>
          <td>${polizza.tipologia_merce}</td>
          <td>${polizza.peso_totale.toFixed(2)}</td>
          <td>${polizza.giorni_franchigia}</td>
          <td>${polizza.tariffa_giornaliera.toFixed(2)}</td>
        `;
        tbody.appendChild(tr);
      });
    })
    .catch(err => alert("Errore caricamento polizze: " + err.message));
}