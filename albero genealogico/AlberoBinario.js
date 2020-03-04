function AlberoBin(info,sx,dx) {

    var left = sx || AlberoBin.EMPTY;
    var right = dx || AlberoBin.EMPTY;


    this.getInfo = function () {
        assert.preCondizione(!this.isEmpty(), new Error("'getInfo' non permesso su EMPTY"));
        return info;
    };

    this.getLeft = function () {
        assert.preCondizione(!this.isEmpty(), new Error("'getLeft' non permesso su EMPTY"));
        return left;
    };

    this.getRight = function () {
        assert.preCondizione(!this.isEmpty(), new Error("'getRight' non permesso su EMPTY"));
        return right;
    };

    this.setInfo = function (newInfo) {
        assert.preCondizione(!this.isEmpty(), new Error("'setInfo' non permesso su EMPTY"));
        info = newInfo;
    };

    this.setLeft = function (newLeft) {
        assert.preCondizione(!this.isEmpty(), new Error("'setLeft' non permesso su EMPTY"));
        left = newLeft;
    };

    this.setRight = function (newRight) {
        assert.preCondizione(!this.isEmpty(), new Error("'setRight' non permesso su EMPTY"));
        right = newRight;
    };

    this.isEmpty = function () {
        return this == AlberoBin.EMPTY;
    };

    this.toString = function () {
        return this.isEmpty()
            ? "-"
            : info + "(" + left + "," + right + ")"; //ricorsione nascosta
    };
}

AlberoBin.EMPTY = new AlberoBin(null,null,null);

