function Huffmann() {
    this.div = document.getElementById("div");
    this.create();
}

Huffmann.prototype.create = function () {
    var input = document.createElement("input");
    input.setAttribute("type", "text");
    this.div.appendChild(input);

    this.div.appendChild(document.createElement("div"));

    var c = document.createElement("input");
    c.setAttribute("type", "button");
    c.setAttribute("value", "comprimi");
    this.div.appendChild(c);

    this.div.appendChild(document.createElement("div"));

    var d = document.createElement("input");
    d.setAttribute("type", "button");
    d.setAttribute("value", "decomprimi");
    this.div.appendChild(d);

    this.div.appendChild(document.createElement("div"));

    var output = document.createElement("input");
    output.setAttribute("type", "text");
    this.div.appendChild(output);

    d.addEventListener("click", callback);
    c.addEventListener("click", callback);
    
    
    var creatore = new CreatoreAlbero();
    var alb = creatore.getAlberoCreato();
    var caratteri = creatore.getListaCaratteri();
    var codici = creatore.getListaCodici();
    
    
    function callback() {
        
        if (this.value === "comprimi") {
            var inp = input.value;
            var s = "";
            for (var i = 0; i < inp.length; i++) {
                s += codici[caratteri.indexOf(inp.charAt(i))];
            }
            output.setAttribute("value", s);
        } else {
            var inp = output.value;
            for (var i = 0; i < inp.length; i++) {
                if (inp.charAt(i) === "0") {
                    alb = alb.sx;
                } else {
                    alb = alb.dx;
                }
            }
            output.setAttribute("value", alb.info);
        }
    }
}

