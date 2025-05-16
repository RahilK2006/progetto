class Merce {
  constructor(id, tipologia, idFornitore) {
    this.id = id;
    this.tipologia = tipologia;
    this.idFornitore = idFornitore;
  }

  static fromJSON(data) {
    return new Merce(data.id, data.tipologia, data.idFornitore);
  }

  toJSON() {
    return {
      id: this.id,
      tipologia: this.tipologia,
      idFornitore: this.idFornitore
    };
  }
}
