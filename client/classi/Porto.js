class Porto {
    constructor(id, nome_porto, nazione, linea) {
        this.id = id;
        this.nome_porto = nome_porto;
        this.nazione = nazione;
        this.linea = linea;
    }

    static fromJSON(data) {
        return new Porto(data.id, data.nome_porto, data.nazione, data.linea);
    }

    toJSON() {
        return {
            id: this.id,
            nome_porto: this.nome_porto,
            nazione: this.nazione,
            linea: this.linea
        };
    }
}
