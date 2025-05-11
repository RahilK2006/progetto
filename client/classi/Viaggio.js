class Viaggio {
    constructor(id, idNave, portoPartenza, portoArrivo, dataPartenza, dataArrivo) {
        this.id = id;
        this.idNave = idNave;
        this.portoPartenza = portoPartenza;
        this.portoArrivo = portoArrivo;
        this.dataPartenza = dataPartenza;
        this.dataArrivo = dataArrivo;
    }

    static fromJSON(data) {
        return new Viaggio(data.id, data.id_nave, data.porto_partenza, data.porto_arrivo, data.data_partenza, data.data_arrivo);
    }

    toJSON() {
        return {
            id: this.id,
            id_nave: this.idNave,
            porto_partenza: this.portoPartenza,
            porto_arrivo: this.portoArrivo,
            data_partenza: this.dataPartenza,
            data_arrivo: this.dataArrivo
        };
    }
}
