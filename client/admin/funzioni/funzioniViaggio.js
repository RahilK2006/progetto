const API = "http://localhost:8080";
const navDrop = document.getElementById("naveSelect");
const partenzaDrop = document.getElementById("partenzaSelect");
const arrivoDrop = document.getElementById("arrivoSelect");
const lineaDrop = document.getElementById("lineaSelect");

const selects = {
  nave: [],
  porto: [],
  linea: []
};

async function caricaComboBox() {
  const [navi, porti, linee] = await Promise.all([
    fetch(API + "/nave/getAll").then(res => res.json()),
    fetch(API + "/porto/getAll").then(res => res.json()),
    fetch(API + "/linea/getAll").then(res => res.json())
  ]);

  selects.nave = navi;
  selects.porto = porti;
  selects.linea = linee;

  riempiSelect(navDrop, navi);
  riempiSelect(partenzaDrop, porti);
  riempiSelect(arrivoDrop, porti);
  riempiSelect(lineaDrop, linee);

  // Setto min date oggi per i campi date nel form
  const oggi = new Date().toISOString().split('T')[0];
  document.getElementById("dataPartenza").setAttribute("min", oggi);
  document.getElementById("dataArrivo").setAttribute("min", oggi);

  caricaViaggi();
}

function riempiSelect(select, dati) {
  select.innerHTML = "";
  dati.forEach(e => {
    const opt = document.createElement("option");
    opt.value = e.id;
    opt.textContent = e.nome || e.nome_porto || e.nome_linea || "??";
    select.appendChild(opt);
  });
}

document.getElementById("aggiungiBtn").addEventListener("click", () => {
  const idNave = parseInt(navDrop.value);
  const portoPartenza = parseInt(partenzaDrop.value);
  const portoArrivo = parseInt(arrivoDrop.value);
  const dataPartenza = document.getElementById("dataPartenza").value;
  const dataArrivo = document.getElementById("dataArrivo").value;
  const linea = parseInt(lineaDrop.value);

  // Controlli
  if (portoPartenza === portoArrivo) {
    alert("Il porto di partenza e arrivo non possono essere uguali.");
    return;
  }

  if (!dataPartenza) {
    alert("Inserisci la data di partenza.");
    return;
  }

  if (!dataArrivo) {
    alert("Inserisci la data di arrivo.");
    return;
  }

  const oggi = new Date();
  const dtPartenza = new Date(dataPartenza);
  const dtArrivo = new Date(dataArrivo);

  // La data partenza non può essere prima di oggi
  oggi.setHours(0,0,0,0);
  if (dtPartenza < oggi) {
    alert("La data di partenza non può essere antecedente a oggi.");
    return;
  }

  // La data arrivo non può essere minore di quella di partenza
  if (dtArrivo < dtPartenza) {
    alert("La data di arrivo non può essere precedente alla data di partenza.");
    return;
  }

  const viaggio = new Viaggio(null, idNave, portoPartenza, portoArrivo, dataPartenza, dataArrivo, linea);

  fetch(API + "/viaggio/add", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(viaggio.toJSON())
  }).then(res => {
    if (!res.ok) throw new Error("Errore inserimento");
    caricaViaggi();
  }).catch(err => alert("Errore: " + err.message));
});

function caricaViaggi() {
  fetch(API + "/viaggio/getAll")
    .then(res => res.json())
    .then(viaggi => {
      const tab = document.getElementById("tabellaViaggi");
      tab.innerHTML = `
        <tr>
          <th>ID</th><th>Nave</th><th>Partenza</th><th>Arrivo</th>
          <th>Data Partenza</th><th>Data Arrivo</th><th>Linea</th><th>Azioni</th>
        </tr>`;

      viaggi.forEach(v => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
          <td>${v.id}</td>
          <td>${comboHTML("nave", v.id, v.id_nave)}</td>
          <td>${comboHTML("porto", v.id, v.porto_partenza)}</td>
          <td>${comboHTML("porto", v.id, v.porto_arrivo)}</td>
          <td><input type="date" data-id="${v.id}" data-field="data_partenza" value="${v.data_partenza}" min="${new Date().toISOString().split('T')[0]}"></td>
          <td><input type="date" data-id="${v.id}" data-field="data_arrivo" value="${v.data_arrivo}" min="${v.data_partenza}"></td>
          <td>${comboHTML("linea", v.id, v.linea)}</td>
          <td>
            <button class="salvaBtn" data-id="${v.id}">Salva</button>
            <button class="eliminaBtn" data-id="${v.id}">Elimina</button>
          </td>
        `;
        tab.appendChild(tr);
      });

      aggiungiEventi();
    });
}

function comboHTML(tipo, id, selectedId) {
  const lista = selects[tipo];
  return `<select data-id="${id}" data-field="${tipo}">
    ${lista.map(e => `
      <option value="${e.id}" ${e.id === selectedId ? "selected" : ""}>
        ${e.nome || e.nome_porto || e.nome_linea}
      </option>`).join("")}
  </select>`;
}

function aggiungiEventi() {
  document.querySelectorAll(".salvaBtn").forEach(btn => {
    btn.addEventListener("click", () => {
      const id = btn.dataset.id;
      const idNave = parseInt(document.querySelector(`select[data-id="${id}"][data-field="nave"]`).value);
      const portoP = parseInt(document.querySelector(`select[data-id="${id}"][data-field="porto"]`).value);
      const portoA = parseInt(document.querySelectorAll(`select[data-id="${id}"][data-field="porto"]`)[1].value);
      const dataP = document.querySelector(`input[data-id="${id}"][data-field="data_partenza"]`).value;
      const dataA = document.querySelector(`input[data-id="${id}"][data-field="data_arrivo"]`).value;
      const linea = parseInt(document.querySelector(`select[data-id="${id}"][data-field="linea"]`).value);

      // Controlli anche qui (aggiornamento)
      if (portoP === portoA) {
        alert("Il porto di partenza e arrivo non possono essere uguali.");
        return;
      }

      if (!dataP || !dataA) {
        alert("Inserisci entrambe le date.");
        return;
      }

      const oggi = new Date();
      const dtPartenza = new Date(dataP);
      const dtArrivo = new Date(dataA);

      oggi.setHours(0,0,0,0);
      if (dtPartenza < oggi) {
        alert("La data di partenza non può essere antecedente a oggi.");
        return;
      }
      if (dtArrivo < dtPartenza) {
        alert("La data di arrivo non può essere precedente alla data di partenza.");
        return;
      }

      const viaggio = new Viaggio(parseInt(id), idNave, portoP, portoA, dataP, dataA, linea);

      fetch(API + "/viaggio/update", {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(viaggio.toJSON())
      }).then(res => {
        if (!res.ok) throw new Error("Errore aggiornamento");
        alert("Viaggio aggiornato con successo");
        caricaViaggi();
      }).catch(err => alert("Errore: " + err.message));
    });
  });

  document.querySelectorAll(".eliminaBtn").forEach(btn => {
    btn.addEventListener("click", () => {
      const id = btn.dataset.id;
      if (!confirm("Confermi eliminazione?")) return;

      fetch(API + `/viaggio/delete?id=${id}`, { method: "DELETE" })
        .then(res => {
          if (!res.ok) throw new Error("Errore eliminazione");
          caricaViaggi();
        }).catch(err => alert("Errore: " + err.message));
    });
  });
}

caricaComboBox();
