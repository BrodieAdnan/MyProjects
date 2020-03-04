window.onload = function () {
    new Huffmann();
}

function Huffmann() {
    var div = document.getElementById("div");

    var input = document.createElement("input");
    input.setAttribute("type", "text");
    div.appendChild(input);

    div.appendChild(document.createElement("div"));

    var c = document.createElement("input");
    c.setAttribute("type", "button");
    c.setAttribute("value", "comprimi");
    div.appendChild(c);

    div.appendChild(document.createElement("div"));

    var d = document.createElement("input");
    d.setAttribute("type", "button");
    d.setAttribute("value", "decomprimi");
    div.appendChild(d);

    div.appendChild(document.createElement("div"));

    var output = document.createElement("input");
    output.setAttribute("type", "text");
    div.appendChild(output);

    d.addEventListener("click", callback);
    c.addEventListener("click", callback);

    function callback() {
        if (this.value == "comprimi") {
            var lettere = new Array(6);
            var c = ["0", "101", "100", "111", "1101", "1100"];
            for (var i = 0; i < input.value.length; i++) {
                if (input.value.charAt(i) === "a") {
                    lettere[0]++;
                } else if (input.value.charAt(i) === "b") {
                    lettere[1]++;
                } else if (input.value.charAt(i) === "c") {
                    lettere[2]++;
                } else if (input.value.charAt(i) === "d") {
                    lettere[3]++;
                } else if (input.value.charAt(i) === "e") {
                    lettere[4]++;
                } else if (input.value.charAt(i) === "f") {
                    lettere[5]++;
                }
            }

            var alb = new AlberoBin(0, AlberoBin.EMPTY, AlberoBin.EMPTY);

            for (var i = 0; i < lettere.length; i++) {
                alb.insertInfo(c[i], lettere[i], alb);//carattere e la sua frequenza
            }
            var convertitore = new Convertitore(alb);
            var convertito;
            convertito += convertitore.converti("a", alb, "");
            convertito += convertitore.converti("b", alb, "");
            convertito += convertitore.converti("c", alb, "");
            convertito += convertitore.converti("d", alb, "");
            convertito += convertitore.converti("e", alb, "");
            convertito += convertitore.converti("f", alb, "");
            output.setAttribute("value", convertito);
        } else if (this.value == "decomprimi") {
//			var riConvertito = converitore.riConverti();
//			output.setAttribute("value", riConvertito);
        }
    }
}

function Convertitore(alb) {
    this.alb = alb;
}

Convertitore.prototype.converti = function (carattere, frequenza, alb, s) {
    if (this.alb.info !== carattere) {
        if (frequenza < this.alb.info) {
            this.converti(carattere, frequenza, alb.getSx(), "0");
        } else {
            this.converti(carattere, frequenza, alb.getDx(), "1");
        }
    } else {
        return s;
    }
}

Convertitore.prototype.riConverti = function () {
    //decompressione
    return this.s;
}