class PolizzaCarico {
    constructor(id, id_viaggio, id_fornitore, id_cliente, tipologia_merce, peso_totale, giorni_franchigia, tariffa_giornaliera) {
        this.id = id;
        this.id_viaggio = id_viaggio;
        this.id_fornitore = id_fornitore;
        this.id_cliente = id_cliente;
        this.tipologia_merce = tipologia_merce;
        this.peso_totale = peso_totale;
        this.giorni_franchigia = giorni_franchigia;
        this.tariffa_giornaliera = tariffa_giornaliera;
    }

    toJSON() {
        return {
            id: this.id,
            id_viaggio: this.id_viaggio,
            id_fornitore: this.id_fornitore,
            id_cliente: this.id_cliente,
            tipologia_merce: this.tipologia_merce,
            peso_totale: this.peso_totale,
            giorni_franchigia: this.giorni_franchigia,
            tariffa_giornaliera: this.tariffa_giornaliera
        };
    }

    static fromJSON(obj) {
        return new PolizzaCarico(
            obj.id,
            obj.id_viaggio,
            obj.id_fornitore,
            obj.id_cliente,
            obj.tipologia_merce,
            obj.peso_totale,
            obj.giorni_franchigia,
            obj.tariffa_giornaliera
        );
    }
}
