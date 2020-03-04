/***************************************************************
 *ASSERT
 *@author Gazi Adnan Latif, Riccardo Fusaro
 *@brief legge da file e salva i dati di fermate, tratte e bus.
 *@brief fornisce i dati al Gestore.
 *@date 12/05/2018
 ***************************************************************/
function ErrAssert(descr, errore) {
    this.toString = function () {
        return descr + errore.toString() + " alla linea: " + errore.lineNumber + errore.stack;
    }
}

assert = {
    preCondizione: function (cond, err) {
        if (cond)
            return;
        throw new ErrAssert("Precondizione errata:", err)
    },
    postCondizione: function (cond, err) {
        if (cond)
            return;
        throw new ErrAssert("Postcondizione errata:", err)
    },
    invariante: function (cond, err) {
        if (cond)
            return;
        throw new ErrAssert("Invariante errata:", err)
    }
}
