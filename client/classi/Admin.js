class Admin {
  constructor(id, nome, cognome, username, password) {
    this.id = id;
    this.nome = nome;
    this.cognome = cognome;
    this.username = username;
    this.password = password;
  }

  toJSON() {
    return {
      id: this.id,
      nome: this.nome,
      cognome: this.cognome,
      username: this.username,
      password: this.password
    };
  }

  static fromJSON(json) {
    return new Admin(
      json.id,
      json.nome,
      json.cognome,
      json.username,
      json.password
    );
  }
}
