document.addEventListener("DOMContentLoaded", () => {
  const apiBase = "http://localhost:8080/linea";
  const tabella = document.getElementById("tabellaLinee");

  document.getElementById("aggiungiBtn").addEventListener("click", () => {
    const nome = document.getElementById("lineaNome").value.trim();
    if (!nome) return alert("Inserisci un nome valido.");

    const nuovaLinea = new Linea(null, nome);

    fetch(`${apiBase}/add`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(nuovaLinea.toJSON())
    })
    .then(res => {
      if (!res.ok) throw new Error("Errore aggiunta");
      document.getElementById("lineaNome").value = "";
      caricaLinee();
    })
    .catch(err => alert("Errore: " + err.message));
  });

  document.getElementById("logoutBtn").addEventListener("click", () => {
    sessionStorage.clear();
    window.location.href = "../index.html";
  });

  function caricaLinee() {
    fetch(`${apiBase}/getAll`)
      .then(res => res.json())
      .then(linee => {
        tabella.innerHTML = "";
        linee.map(Linea.fromJSON).forEach(linea => {
          const riga = document.createElement("tr");
          riga.innerHTML = `
            <td>${linea.id}</td>
            <td contenteditable="true" data-id="${linea.id}" class="editable">${linea.nome}</td>
            <td>
              <button class="salvaBtn" data-id="${linea.id}">Salva</button>
              <button class="eliminaBtn" data-id="${linea.id}">Elimina</button>
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
        const cellaNome = document.querySelector(`td[data-id="${id}"]`);
        const nuovoNome = cellaNome.innerText.trim();
        if (!nuovoNome) return alert("Il nome non può essere vuoto.");

        const lineaAggiornata = new Linea(parseInt(id), nuovoNome);

        fetch(`${apiBase}/update`, {
          method: "PUT",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(lineaAggiornata.toJSON())
        })
        .then(res => {
          if (!res.ok) throw new Error("Errore aggiornamento");
          alert("Linea aggiornata con successo.");
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
            caricaLinee();
          })
          .catch(err => alert("Errore: " + err.message));
      });
    });
  }

  caricaLinee();
});
