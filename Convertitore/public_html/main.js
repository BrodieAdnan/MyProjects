gazi = {};
window.onload = function () {
    div = document.getElementById("div");

    input = document.createElement("input");
    input.setAttribute("type", "text");
    div.appendChild(input);

    div.appendChild(document.createElement("div"));

    bF = document.createElement("input");
    bF.setAttribute("type", "button");
    bF.setAttribute("value", "toFahrenheit");
    div.appendChild(bF);

    div.appendChild(document.createElement("div"));

    bC = document.createElement("input");
    bC.setAttribute("type", "button");
    bC.setAttribute("value", "toCelsius");
    div.appendChild(bC);

    div.appendChild(document.createElement("div"));

    output = document.createElement("span");
    div.appendChild(output);

    bF.addEventListener("click", callback);
    bC.addEventListener("click", callback);
    
    function callback() {
        if (this.value == "toCelsius") {
            x = input.value * 9 / 5 + 32;
            output.innerHTML = Math.round(x);
        } else if (this.value == "toFahrenheit") {
            x = (input.value - 32) * 5 / 9;
            output.innerHTML = Math.round(x);
        }
    }
};

