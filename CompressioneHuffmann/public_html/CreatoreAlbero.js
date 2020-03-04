function CreatoreAlbero() {
    this.caratteri = ["a", "b", "c", "d", "e", "f"];
    this.alb = new AlberoBin(120, new AlberoBin("a", null, null), new AlberoBin(63, new AlberoBin(25, new AlberoBin("c", null, null), new AlberoBin("b", null, null))), new AlberoBin(38, new AlberoBin(14, new AlberoBin("f", null, null))), new AlberoBin("d"));//this.formaAlbero();
    this.codici = ["0", "101", "100", "111", "1101", "1100"]; //this.formaCodice();
}

CreatoreAlbero.prototype.formaAlbero = function () {
    var n1 = new AlberoBin(14, "f", "e");
    var n2 = new AlberoBin(38, n1, "d");
    var n5 = new AlberoBin(63, n4, n2);
    var n4 = new AlberoBin(25, "c", "b");
    var n6 = new AlberoBin(120, "a", n5);

    return n6;
}

CreatoreAlbero.prototype.formaCodice = function () {
    var l = [];
    alert(this.alb.info !== null);
    for (var i = 0; i < this.caratteri.length; i++) {
        l.push(this.n(this.caratteri[i], "", this.alb));
    }
}

CreatoreAlbero.prototype.n = function (c, s, alb) {
    if (this.alb.info !== null) {
        if (c === alb.info) {
            return s;
        } else {
            var sx = this.n(c, s + "0", alb.sx);
            if (sx !== null) {
                return sx;
            }
            var dx = this.n(c, s + "1", alb.dx);
            if (dx !== null) {
                return dx;
            }
        }
    }
}

CreatoreAlbero.prototype.getAlberoCreato = function () {
    return this.alb;
}

CreatoreAlbero.prototype.getListaCodici = function () {
    return this.codici;
}

CreatoreAlbero.prototype.getListaCaratteri = function () {
    return this.caratteri;
}
