function AlberoGenealogico(persona) {

	function ricerca(albBin, persona){
		if(albBin.isEmpty()){
            return AlberoBin.EMPTY;
		}
		else if(albBin.getInfo()==persona){
			return albBin;
		}
		else{
			var alb=ricerca(albBin.getLeft(),persona);
			if(alb.isEmpty()){
				alb=ricerca(albBin.getRight(),persona);
			}
			return alb;
		}
	}

    function visualizza(persona, maxLivello) {
        var riga = 0;
        function visualizzaRic(persona, livello) {
            if (persona.isEmpty() || livello > maxLivello) {
                return;
            }
            else {
                visualizzaRic(persona.getLeft(), livello + 1);
                g.scrivi(persona.getInfo(), riga, livello);
                riga++;
                visualizzaRic(persona.getRight(), livello + 1);
            }
        }
        visualizzaRic(persona, 0);
	}

    function mostraAntenati(persona) {
        var elem = ricerca(alberoAntenati, persona);
        if (elem.isEmpty()) {
            alert(Persona + " non è un antenato");
        }
        else {
            g.initArea();
            visualizza(elem, 2);
        }
    }

    this.addAntenato = function (antenato, padre, di) {
        var ant, subAlb;
        var elem = ricerca(alberoAntenati, di);
        if (elem.isEmpty()) {
            return false;
        }
        else {
            subAlb = padre ? "Left" : "Right";
            ant = elem["get" + subAlb]();
            if (ant.isEmpty()) {
                elem["set" + subAlb](new AlberoBin(antenato));
            }
            else {
                ant.setInfo(antenato);
            }
            return true;
        }
    };

    this.toString = function () {
        return alberoAntenati.toString();
    };

    var g = new Grafica();
    var alberoAntenati = new AlberoBin(persona);
    g.callBack(mostraAntenati);

}

window.onload = function () {
    var alb = new AlberoGenealogico("io");
    alb.addAntenato("mamma", false, "io");
    alb.addAntenato("papà", true, "io");
    alb.addAntenato("nonnoP", true, "papà");
    alb.addAntenato("nonnaP", false, "papà");
    alb.addAntenato("nonnaM", false, "mamma");
    alb.addAntenato("nonnoM", true, "mamma");
    alb.addAntenato("bisnonnaPM", false, "nonnoM");
    alb.addAntenato("bisnonnoPM", true, "nonnoM");
    alb.addAntenato("bisnonnaMM", false, "nonnaM");
    alb.addAntenato("bisnonnoMM", true, "nonnaM");
    alb.addAntenato("bisnonnaPP", false, "nonnoP");
    alb.addAntenato("bisnonnoPP", true, "nonnoP");
    alb.addAntenato("bisnonnaMP", false, "nonnaP");
    alb.addAntenato("bisnonnoMP", true, "nonnaP");
    console.log(alb.toString());
};