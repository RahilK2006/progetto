document.addEventListener('DOMContentLoaded', () => {
  const adminSalvato = sessionStorage.getItem("user");
  const adminDetails = document.getElementById("adminDetails");
  
  if (adminSalvato) {
    const admin = JSON.parse(adminSalvato);
    adminDetails.innerHTML = `
      <div class="admin-details"><span>ID:</span> ${admin.id}</div>
      <div class="admin-details"><span>Nome:</span> ${admin.nome}</div>
      <div class="admin-details"><span>Cognome:</span> ${admin.cognome}</div>
    `;
  } else {
    window.location.href = "login.html"; // Redirigi al login se non è loggato
  }

  document.getElementById('logoutBtn').addEventListener('click', () => {
    sessionStorage.removeItem("user");
        window.location.href = '../index.html';
  });
});
