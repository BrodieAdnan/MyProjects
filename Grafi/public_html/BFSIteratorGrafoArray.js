function BFSIterator(grafo, verticeIniziale) {
    var coda = [verticeIniziale];
    var visitati = [verticeIniziale];

    for (var i = 0; i < grafo.vertici; i++) {//carico i vertici sulla coda.
        coda.push(grafo._vertici[i]);
    }

    this.hasNext = function () {
        return coda.length !== 0;
    }

    this.next = function () {
        if (!this.hasNext()) {
            throw new Error("Nessun elemento rimanente!");
        } else {
            var next = coda.shift();
            var intorno = grafo.intorno(next);

            for (var i = 0; i < grafo.adiacenze[i].length; i++) {
                if (visitati.indexOf(intorno[i]) === -1) {//non trovato.
                    visitati.push(intorno[i]);
                }
            }
            return next;
        }
    }
}

