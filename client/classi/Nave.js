class Nave {
    constructor(id, nome) {
        this.id = id;
        this.nome = nome;
    }

    static fromJSON(data) {
        return new Nave(data.id, data.nome);
    }

    toJSON() {
        return {
            id: this.id,
            nome: this.nome
        };
    }
}
