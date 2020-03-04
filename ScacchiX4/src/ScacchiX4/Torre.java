package ScacchiX4;

/********************************************************
 *@title TORRE
 *@package ScacchiX4
 *@brief 
********************************************************/

public class Torre extends Pezzo {

    private Coppia pos;
    private int colore;

    /*******************************************
    *TORRE
    *@brief 
    *******************************************/
    public Torre(Coppia c, int colore) {
        pos = c;
        this.colore = colore;
    }

    /*******************************************
    *CHECK
    *@brief 
    *******************************************/
    @Override
    boolean check(Coppia c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /*******************************************
    *TYPE
    *@brief 
    *******************************************/
    @Override
    char type() {
        return 't';
    }
}
