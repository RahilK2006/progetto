class Cliente {
    constructor(id, nome, cognome, email, username, password, azienda) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.username = username;
        this.password = password;
        this.azienda = azienda;
    }

    static fromJSON(data) {
        return new Cliente(data.id, data.nome, data.cognome, data.email, data.username, data.password, data.azienda);
    }

    toJSON() {
        return {
            id: this.id,
            nome: this.nome,
            cognome: this.cognome,
            email: this.email,
            username: this.username,
            password: this.password,
            azienda: this.azienda
        };
    }
}
