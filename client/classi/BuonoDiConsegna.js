class BuonoDiConsegna {
    constructor(id, idPolizza, idCliente, pesoRiferito, dataEmissione) {
        this.id = id;
        this.idPolizza = idPolizza;
        this.idCliente = idCliente;
        this.pesoRiferito = pesoRiferito;
        this.dataEmissione = dataEmissione; // YYYY-MM-DD
    }

    static fromJSON(json) {
        return new BuonoDiConsegna(
            json.id,
            json.idPolizza,
            json.idCliente,
            json.pesoRiferito,
            json.dataEmissione
        );
    }

    toJSON() {
        return {
            id: this.id,
            idPolizza: this.idPolizza,
            idCliente: this.idCliente,
            pesoRiferito: this.pesoRiferito,
            dataEmissione: this.dataEmissione
        };
    }
}
