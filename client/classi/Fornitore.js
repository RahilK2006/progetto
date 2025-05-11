class Fornitore {
    constructor(id, nome, cognome, azienda, username, password, email) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.azienda = azienda;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    static fromJSON(data) {
        return new Fornitore(data.id, data.nome, data.cognome, data.azienda, data.username, data.password, data.email);
    }

    toJSON() {
        return {
            id: this.id,
            nome: this.nome,
            cognome: this.cognome,
            azienda: this.azienda,
            username: this.username,
            password: this.password,
            email: this.email
        };
    }
}
