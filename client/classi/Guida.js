class Guida {
    constructor(id, idConducente, idCamion) {
        this.id = id;
        this.idConducente = idConducente;
        this.idCamion = idCamion;
    }

    static fromJSON(data) {
        return new Guida(data.id, data.id_conducente, data.id_camion);
    }

    toJSON() {
        return {
            id: this.id,
            id_conducente: this.idConducente,
            id_camion: this.idCamion
        };
    }
}
