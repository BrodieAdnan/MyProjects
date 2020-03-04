gazi = {};
window.onload = function () {
    function createElement() {
        var titolo = document.createElement("span");
        var incognita = document.createElement("input");
        gazi.tab.appendChild(titolo);
        titolo.innerHTML = "Inserire il valore dell'incognita."
        gazi.tab.appendChild(document.createElement("br"));
        var x = document.createElement("span");
        gazi.tab.appendChild(x);
        x.innerHTML="X : ";
        gazi.tab.appendChild(incognita);
        gazi.tab.appendChild(document.createElement("br"));

        var input = document.createElement("input");
        calcola = document.createElement("input");
        var output = document.createElement("input");
        calcola.setAttribute("type", "button");
        calcola.setAttribute("value", "calcola");
        var x = document.createElement("span");
        gazi.calc.appendChild(x);
        x.innerHTML="Inserisci l'espressione : ";
        gazi.calc.appendChild(input);
        gazi.calc.appendChild(document.createElement("br"));
        gazi.calc.appendChild(calcola);
        gazi.calc.appendChild(document.createElement("br"));
        var y = document.createElement("span");
        gazi.calc.appendChild(y);
        y.innerHTML = "Il risultato è : ";
        gazi.calc.appendChild(output);
        gazi.calc.appendChild(document.createElement("br"));
    }

    gazi.tab = document.getElementById("tab");
    gazi.calc = document.getElementById("calc");
    createElement();
    calcola.addEventListener("click", callback);
    
    function callback(){
        
    }
}

