class Transazione {
    constructor(id, idPolizza, idCliente, importo, dataOraPagamento, metodo) {
        this.id = id;
        this.idPolizza = idPolizza;
        this.idCliente = idCliente;
        this.importo = importo;
        this.dataOraPagamento = dataOraPagamento;
        this.metodo = metodo;
    }

    static fromJSON(data) {
        return new Transazione(data.id, data.id_polizza, data.id_cliente, data.importo, data.data_ora_pagamento, data.metodo);
    }

    toJSON() {
        return {
            id: this.id,
            id_polizza: this.idPolizza,
            id_cliente: this.idCliente,
            importo: this.importo,
            data_ora_pagamento: this.dataOraPagamento,
            metodo: this.metodo
        };
    }
}
