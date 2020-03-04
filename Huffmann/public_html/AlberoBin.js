function AlberoBinario(info, sx, dx) {
    node = this;
	this.info = info;
	this.sx = sx;
	this.dx = dx;
    this.isEmpty = function () {
        return this == AlberoBinario.EMPTY;
    };

    if (sx == undefined) {
        sx = AlberoBinario.EMPTY;
    }

    if (dx == undefined) {
        dx = AlberoBinario.EMPTY;
    }

    this.getInfo = function () {
        if (this.isEmpty()) {
            throw exception;
        }
        return info;
    }

    ///aggiunto///
    this.getNode = function () {
        return node;
    }

    this.setSx = function (s) {
        if (sx.constructor == AlberoBinario) {
            sx = s;
        } else {
            throw exception;
        }
    }

    this.setDx = function (d) {
        if (dx.constructor == AlberoBinario) {
            dx = d;
        } else {
            throw exception;
        }
    }

    this.getSx = function () {
        return sx;
    }

    this.getDx = function () {
        return dx;
    }
	
	this.insertInfo = function (carattere, frequenza, alb) {
		if(this.info === AlberoBin.EMPTY){
			this.info = carattere;//inserisce in una foglia
		} else if (frequenza < this.info) {
			this.insertInfo(carattere, frequenza, alb.getSx());
			this.info = alb.getSx().info + frequenza;//aggiorna le frequenze
		} else {
			this.insertInfo(carattere, frequenza, alb.getDx());
			this.info = alb.getDx().info + frequenza;//aggiorna le frequenze
		}
	}

    //contaNodi//
    function contaNodiPreordine(alb) {
        if (alb.isEmpty())
            return 0;
        else
            return 1 + contaNodiPreordine(alb.getSx()) + contaNodiPreordine(alb.getDx());
    }
    function contaNodiSimmetrico(alb) {
        if (alb.isEmpty())
            return 0;
        else
            return contaNodiSimmetrico(alb.getSx()) + 1 + contaNodiSimmetrico(alb.getDx());
    }
    function contaNodiPostordine(alb) {
        if (alb.isEmpty())
            return 0;
        else
            return contaNodiPostordine(alb.getSx()) + contaNodiPostordine(alb.getDx()) + 1;
    }
    //fine contaNodi//

    //altezza//
    function altezza(alb) {
        if (alb.isEmpty()) {
            return -1;
        } else {
            return Math.max(altezza(alb.getSx()), altezza(alb.getDx())) + 1;
        }
    }

    //eliminaFoglie//
    function eliminaFoglie(alb) {
        if (alb.isEmpty()) {
            return alb;
        } else if (alb.getSx().isEmpty() && alb.getDx().isEmpty()) {
            return alb.EMPTY;
        } else {
            alb.setSx(eliminaFoglie(alb.getSx()));
            alb.setDx(eliminaFoglie(alb.getDx()));
            return alb;
        }
    }

    //visite//
    function attraversamentoPerLivelli(alb) {
        var coda = new Coda();
        if (alb.isEmpty()) {
            coda.enqueue(alb);
            while (!coda.isEmpty()) {
                alb = coda.dequeue();
                console.log(alb.getInfo());
                if (!alb.getSx().isEmpty()) {
                    coda.enqueue(alb.getSx());
                }
                if (!alb.getDx().isEmpty()) {
                    coda.enqueue(alb.getDx());
                }
            }
        }
    }

    function attraversamentoPreordineIterativo(alb) {
        var pila = new Pila();
        if (alb.isEmpty()) {
            pila.push(alb);
            while (!pila.isEmpty()) {
                alb = pila.pop();
                console.log(alb.getInfo());
                if (!alb.getSx().isEmpty()) {
                    pila.push(alb.getSx());
                }
                if (!alb.getDx().isEmpty()) {
                    pila.push(alb.getDx());
                }
            }
        }
    }

    function visitaPreordine(alb) {
        var pila = new Pila();
        if (!alb.isEmpty()) {
            pila.push(visitaPreordine(alb.getDx()));
            pila.push(visitaPreordine(alb.getSx()));
        }
    }

    this.simmetricVisitation = function (n, cercato) {
        node = n;
        if (n == null) {
            return false;
        } else if (n.getI() == cercato) {
            return true;
        } else {
            return this.simmetricVisitation(n.getS(), cercato) || this.simmetricVisitation(n.getD(), cercato);
        }
    }
    //fine visite//

    //ricostruzione albero//
    function preSimm(preordine, simmetrico) {
        if (preordine == 0) {
            return AlberoBinario.EMPTY;
        } else {
            var posRad = simmetrico.indexOf(preordine[0]);
            return albero = new AlberoBinario(preordine[0], preSimm(preordine.substring(1, simmetrico.substring(0, posRad))), preSimm(preordine.substring(preordine.substring(1 + posRad, simmetrico.substring(posRad + 1)))));
        }
    }
    
    function prePost(preordine, postordine) {
        if (preordine == 0) {
            return AlberoBinario.EMPTY;
        } else {
            var posRad = postordine.indexOf(preordine[1]);
            return albero = new AlberoBinario(preordine[0], prePost(preordine.substring(1, preordine.indeOf(postordine[0])+1, postordine.substring(0, posRad), prePost(preordine.indexOf(postordine[postordine.length-2]), preordine.length-1), postordine.substring(postordine.indexOf(preordine.indexOf(postordine[postordine.length-2])+1), postordine.length-1))));
        }
    }
    //fine ricostruzione albero//
};