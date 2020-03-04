function grafica(comp) {
    var componente = comp;

    rosso = create(componente);

    sR = document.createElement("span");
    componente.appendChild(sR);
    space1 = document.createElement("div");
    space1.setAttribute("style", "weidth: 100%;");
    componente.appendChild(space1);


    verde = create(componente);

    sV = document.createElement("span");
    componente.appendChild(sV);
    space2 = document.createElement("div");
    space2.setAttribute("style", "weidth: 100%;");
    componente.appendChild(space2);


    blu = create(componente);

    sB = document.createElement("span");
    componente.appendChild(sB);
    space3 = document.createElement("div");
    space3.setAttribute("style", "weidth: 100%;");
    componente.appendChild(space3);


    cella = document.createElement("div");
    cella.setAttribute("style", "weidth:500px; height:200px; border: 5px solid black; background-color: rgb(0, 0, 0);");
    componente.appendChild(cella);

    visualizza = document.createElement("output");
    componente.appendChild(visualizza);


    rosso.addEventListener("mousemove", callback);
    verde.addEventListener("mousemove", callback);
    blu.addEventListener("mousemove", callback);

}
;

function create(comp) {
    var x = document.createElement("input");
    x.setAttribute("type", "range");
    x.setAttribute("max", "255");
    x.setAttribute("value", "100");
    x.setAttribute("id", "rosso");
    comp.appendChild(x);
    return x;
}

this.callback = function () {
    cella.style.backgroundColor = 'rgb(' + rosso.value + ',' + verde.value + ',' + blu.value + ')';
    visualizza.innerHTML = conversione() + "   è cambiato il " + this.id;
    setRange();
}

function conversione() {
    return '#' + toHex(rosso.value) + toHex(verde.value) + toHex(blu.value);
}

function toHex(n) {
    n = parseInt(n, 10);
    if (isNaN(n))
        return "00";
    n = Math.max(0, Math.min(n, 255));
    return '0123456789ABCDEF'.charAt((n - n % 16) / 16)
            + '0123456789ABCDEF'.charAt(n % 16);
}

function setRange() {
    sR.innerHTML = rosso.value;
    sV.innerHTML = verde.value;
    sB.innerHTML = blu.value;
}