function AlberoBinario(info, sx, dx) {
    persona = info; //stringa
    sinistro = sx; //albero
    destro = dx; //albero
    node = this; //albero principale

    this.isEmpty = function () {
        return this == AlberoBin.EMPTY;
    }

    this.getS = function () {
        return sx;
    }

    this.getD = function () {
        return dx;
    }
    
    this.setD = function (d) {
        if (dx.constructor == AlberoBinario) {
            dx = d;
        } else {
            throw exception;
        }
    }

    this.getNode = function () {
        return node;
    }

    this.getI = function () {
        return info;
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


//    this.simmetricVisitation = function (n, cercato) {
//        node = n;
//        if (cercato == "" || n.getI() == null) {
//            return false;
//        } else if (n.getI() == cercato) {
//            return true;
//        } else {
//            if (n.getS().getI() == cercato) {
//                node=n.getS();
//                return true;
//            } else if (n.getS().getS().getI() == cercato) {
//                node=n.getS().getS();
//                return true;
//            } else if (n.getS().getD().getI() == cercato) {
//                node=n.getS().getD();
//                return true;
//            } else if (n.getS().getS().getS().getI() == cercato) {
//                node=n.getS().getS().getS();
//                return true;
//            } else if (n.getS().getS().getD().getI() == cercato) {
//                node=n.getS().getS().getD();
//                return true;
//            } else if (n.getS().getD().getS().getI() == cercato) {
//                node=n.getS().getD().getS();
//                return true;
//            } else if (n.getS().getD().getD().getI() == cercato) {
//                node=n.getS().getD().getD();
//                return true;
//            } else if (n.getD().getS().getS().getI() == cercato) {
//                node=n.getD().getS().getS();
//                return true;
//            } else if (n.getD().getS().getD().getI() == cercato) {
//                node=n.getD().getS().getD();
//                return true;
//            } else if (n.getD().getD().getI() == cercato) {
//                node=n.getD().getD();
//                return true;
//            } else if (n.getD().getD().getS().getI() == cercato) {
//                node=n.getD().getD().getS();
//                return true;
//            } else if (n.getD().getD().getD().getI() == cercato) {
//                node=n.getD().getD().getD();
//                return true;
//            } else if (n.getD().getS().getI() == cercato) {
//                node=n.getD().getS();
//                return true;
//            } else if (n.getD().getI() == cercato) {
//                node=n.getD();
//                return true;
//            }
//        }
//    }
}
;