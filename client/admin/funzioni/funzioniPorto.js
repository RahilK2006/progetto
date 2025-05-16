document.addEventListener("DOMContentLoaded", () => {
  const apiBase = "http://localhost:8080/porto";
  const tabella = document.getElementById("tabellaPorti");

  document.getElementById("aggiungiBtn").addEventListener("click", () => {
    const nome = document.getElementById("portoNome").value.trim();
    const nazione = document.getElementById("portoNazione").value.trim();

    if (!nome || !nazione) return alert("Compila tutti i campi");

    const nuovo = new Porto(null, nome, nazione);

    fetch(`${apiBase}/add`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(nuovo.toJSON())
    })
      .then(res => {
        if (!res.ok) throw new Error("Errore aggiunta");
        caricaPorti();
      })
      .catch(err => alert("Errore: " + err.message));
  });

  document.getElementById("logoutBtn").addEventListener("click", () => {
    sessionStorage.clear();
    window.location.href = "../index.html";
  });

  function caricaPorti() {
    fetch(`${apiBase}/getAll`)
      .then(res => res.json())
      .then(porti => {
        tabella.innerHTML = "";
        porti.map(Porto.fromJSON).forEach(porto => {
          const riga = document.createElement("tr");
          riga.innerHTML = `
            <td>${porto.id}</td>
            <td contenteditable="true" data-id="${porto.id}" data-field="nome_porto">${porto.nome_porto}</td>
            <td contenteditable="true" data-id="${porto.id}" data-field="nazione">${porto.nazione}</td>
            <td>
              <button class="salvaBtn" data-id="${porto.id}">Salva</button>
              <button class="eliminaBtn" data-id="${porto.id}">Elimina</button>
            </td>
          `;
          tabella.appendChild(riga);
        });

        aggiungiEventi();
      })
      .catch(err => alert("Errore caricamento: " + err.message));
  }

  function aggiungiEventi() {
    document.querySelectorAll(".salvaBtn").forEach(btn => {
      btn.addEventListener("click", () => {
        const id = btn.dataset.id;
        const nome = document.querySelector(`td[data-id="${id}"][data-field="nome_porto"]`).innerText.trim();
        const nazione = document.querySelector(`td[data-id="${id}"][data-field="nazione"]`).innerText.trim();

        if (!nome || !nazione) {
          alert("Tutti i campi devono essere compilati prima di salvare.");
          return;
        }

        const aggiornato = new Porto(parseInt(id), nome, nazione);

        fetch(`${apiBase}/update`, {
          method: "PUT",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(aggiornato.toJSON())
        })
          .then(res => {
            if (!res.ok) throw new Error("Errore aggiornamento");
            alert("Porto aggiornato con successo.");
          })
          .catch(err => alert("Errore: " + err.message));
      });
    });

    document.querySelectorAll(".eliminaBtn").forEach(btn => {
      btn.addEventListener("click", () => {
        const id = btn.dataset.id;
        if (!confirm("Confermi eliminazione?")) return;

        fetch(`${apiBase}/delete?id=${id}`, { method: "DELETE" })
          .then(res => {
            if (!res.ok) throw new Error("Errore eliminazione");
            caricaPorti();
          })
          .catch(err => alert("Errore: " + err.message));
      });
    });
  }

  caricaPorti();
});