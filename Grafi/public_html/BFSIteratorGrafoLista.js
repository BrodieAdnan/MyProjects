function BFSIterator(grafo, verticeIniziale) {
    var coda = [verticeIniziale];//riempita con tutti i vertici del grafo.
    var visitati = [verticeIniziale];
    for (var i = 0; i < grafo.vertici; i++) {//copio solo i vertici, non le adiacenze.
        coda.push(grafo._vertici[i]);
    }

    this.hasNext = function () {
        return coda.length !== 0;//visitati pieno, coda vuoto perchè tutti i vertici sono già stati visitati.
    }

    this.next = function () {
        if (!this.hasNext()) {//controllo che ci sia un vertice successivo.
            throw new Error("Nessun elemento Rimasto!");
        } else {
            var next = coda.shift();//'dequeue' o 'pop'. Prendo il primo inserito.
            var vicini = grafo.intorno(next);//tutti gli archi del vertice 'next'.

            for (var i = 0; i < vicini.legnth; i++) {
                if (visitati.indexOf(vicini[i]) === -1) {//non trovato.
                    visitati.push(vicini[i]);
                }
            }

            return next;
        }
    }
}