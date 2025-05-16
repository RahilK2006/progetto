  const user = JSON.parse(sessionStorage.getItem("user"));
  const idFornitore = user?.id;

document.addEventListener("DOMContentLoaded", () => {
  const apiBase = "http://localhost:8080/merce";
  const tabella = document.getElementById("tabellaMerci");
  const user = JSON.parse(sessionStorage.getItem("user"));
  const idFornitore = user?.id;

  if (!idFornitore) {
    alert("Sessione non valida");
    window.location.href = "../index.html";
    return;
  }

  document.getElementById("aggiungiBtn").addEventListener("click", () => {
    const tipologia = document.getElementById("merceTipologia").value.trim();
    if (!tipologia) return alert("Inserisci una tipologia valida.");

    const nuovaMerce = new Merce(null, tipologia, idFornitore);

    fetch(`${apiBase}/add`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(nuovaMerce.toJSON())
    })
    .then(res => {
      if (!res.ok) throw new Error("Errore aggiunta");
      document.getElementById("merceTipologia").value = "";
      caricaMerci();
    })
    .catch(err => alert("Errore: " + err.message));
  });

  function caricaMerci() {
      const user = JSON.parse(sessionStorage.getItem("user"));
  const idFornitore = user?.id;
    fetch(`${apiBase}/getByFornitore?idFornitore=${idFornitore}`)
      .then(res => res.json())
      .then(data => {
        tabella.innerHTML = "";
        data.map(Merce.fromJSON).forEach(merce => {
          const riga = document.createElement("tr");
          riga.innerHTML = `
            <td>${merce.id}</td>
            <td contenteditable="true" data-id="${merce.id}" class="editable">${merce.tipologia}</td>
            <td>
              <button class="salvaBtn" data-id="${merce.id}">Salva</button>
              <button class="eliminaBtn" data-id="${merce.id}">Elimina</button>
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
        const cella = document.querySelector(`td[data-id="${id}"]`);
        const nuovaTipologia = cella.innerText.trim();
        if (!nuovaTipologia) return alert("Tipologia non valida.");

        const aggiornata = new Merce(parseInt(id), nuovaTipologia, idFornitore);

        fetch(`${apiBase}/update`, {
          method: "PUT",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(aggiornata.toJSON())
        })
        .then(res => {
          if (!res.ok) throw new Error("Errore aggiornamento");
          alert("Merce aggiornata.");
        })
        .catch(err => alert("Errore: " + err.message));
      });
    });

    document.querySelectorAll(".eliminaBtn").forEach(btn => {
      btn.addEventListener("click", () => {
        const id = btn.dataset.id;
        if (!confirm("Vuoi davvero eliminare questa merce?")) return;

        fetch(`${apiBase}/delete?id=${id}&idFornitore=${idFornitore}`, {
          method: "DELETE"
        })
        .then(res => {
          if (!res.ok) throw new Error("Errore eliminazione");
          caricaMerci();
        })
        .catch(err => alert("Errore: " + err.message));
      });
    });
  }

  caricaMerci();

  document.getElementById("logoutBtn").addEventListener("click", () => {
    sessionStorage.clear();
    window.location.href = "../index.html";
  });
});