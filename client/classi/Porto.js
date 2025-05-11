class Porto {
    constructor(id, nomePorto, nazione, linea) {
        this.id = id;
        this.nomePorto = nomePorto;
        this.nazione = nazione;
        this.linea = linea;
    }

    static fromJSON(data) {
        return new Porto(data.id, data.nome_porto, data.nazione, data.linea);
    }

    toJSON() {
        return {
            id: this.id,
            nome_porto: this.nomePorto,
            nazione: this.nazione,
            linea: this.linea
        };
    }
}
