class Camion {
    constructor(targa) {
        this.targa = targa;
    }

    static fromJSON(json) {
        return new Camion(json.targa);
    }

    toJSON() {
        return {
            targa: this.targa
        };
    }
}
