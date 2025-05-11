class Conducente {
    constructor(id, nome, cognome, username, password, email) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    static fromJSON(data) {
        return new Conducente(data.id, data.nome, data.cognome, data.username, data.password, data.email);
    }

    toJSON() {
        return {
            id: this.id,
            nome: this.nome,
            cognome: this.cognome,
            username: this.username,
            password: this.password,
            email: this.email
        };
    }
}
