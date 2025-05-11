class PolizzaCarico {
    constructor(id, idViaggio, idFornitore, tipologiaMerce, pesoTotale, giorniFranchigia, tariffaGiornaliera) {
        this.id = id;
        this.idViaggio = idViaggio;
        this.idFornitore = idFornitore;
        this.tipologiaMerce = tipologiaMerce;
        this.pesoTotale = pesoTotale;
        this.giorniFranchigia = giorniFranchigia;
        this.tariffaGiornaliera = tariffaGiornaliera;
    }

    static fromJSON(data) {
        return new PolizzaCarico(data.id, data.id_viaggio, data.id_fornitore, data.tipologia_merce, data.peso_totale, data.giorni_franchigia, data.tariffa_giornaliera);
    }

    toJSON() {
        return {
            id: this.id,
            id_viaggio: this.idViaggio,
            id_fornitore: this.idFornitore,
            tipologia_merce: this.tipologiaMerce,
            peso_totale: this.pesoTotale,
            giorni_franchigia: this.giorniFranchigia,
            tariffa_giornaliera: this.tariffaGiornaliera
        };
    }
}
