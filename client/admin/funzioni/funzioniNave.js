document.addEventListener("DOMContentLoaded", () => {
  const apiBase = "http://localhost:8080/nave";
  const tabella = document.getElementById("tabellaNavi");
  const nomeInput = document.getElementById("nuovaNaveNome");

  caricaNavi();

  document.getElementById("aggiungiBtn").addEventListener("click", () => {
    const nome = nomeInput.value.trim();
    if (!nome) return alert("Inserisci un nome valido.");

    const nuovaNave = new Nave(null, nome);

    fetch(`${apiBase}/add`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(nuovaNave.toJSON())  // ✅ semplificato
    })
      .then(res => {
        if (!res.ok) throw new Error("Errore aggiunta");
        nomeInput.value = "";
        caricaNavi();
      })
      .catch(err => alert("Errore: " + err.message));
  });

  document.getElementById("logoutBtn").addEventListener("click", () => {
    sessionStorage.clear();
    window.location.href = "../index.html";
  });

  function caricaNavi() {
    fetch(`${apiBase}/getAll`)
      .then(res => res.json())
      .then(navi => {
        tabella.innerHTML = "";
        navi.map(Nave.fromJSON).forEach(nave => {  // ✅ semplificato
          const row = document.createElement("tr");
          row.innerHTML = `
            <td>${nave.id}</td>
            <td contenteditable="true" data-id="${nave.id}" class="editable">${nave.nome}</td>
            <td>
              <button class="salvaBtn" data-id="${nave.id}">Salva</button>
              <button class="eliminaBtn" data-id="${nave.id}">Elimina</button>
            </td>
          `;
          tabella.appendChild(row);
        });

        aggiungiEventi();
      });
  }

  function aggiungiEventi() {
    document.querySelectorAll(".salvaBtn").forEach(btn => {
      btn.addEventListener("click", () => {
        const id = btn.getAttribute("data-id");
        const cellaNome = document.querySelector(`td[data-id="${id}"]`);
        const nuovoNome = cellaNome.innerText.trim();
        if (!nuovoNome) return alert("Il nome non può essere vuoto.");

        const naveAggiornata = new Nave(parseInt(id), nuovoNome);

        fetch(`${apiBase}/update`, {
          method: "PUT",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(naveAggiornata.toJSON())  // ✅ semplificato
        })
          .then(res => {
            if (!res.ok) throw new Error("Errore aggiornamento");
            alert("Nave aggiornata con successo.");
          })
          .catch(err => alert("Errore: " + err.message));
      });
    });

    document.querySelectorAll(".eliminaBtn").forEach(btn => {
      btn.addEventListener("click", () => {
        const id = btn.getAttribute("data-id");
        if (!confirm("Confermi l'eliminazione?")) return;

        fetch(`${apiBase}/delete?id=${id}`, { method: "DELETE" })
          .then(res => {
            if (!res.ok) throw new Error("Errore eliminazione");
            caricaNavi();
          })
          .catch(err => alert("Errore: " + err.message));
      });
    });
  }
});

