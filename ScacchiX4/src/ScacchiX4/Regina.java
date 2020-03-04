package ScacchiX4;

/********************************************************
 *@title REGINA
 *@package ScacchiX4
 *@brief 
********************************************************/

public class Regina extends Pezzo {

    private Coppia pos;
    private int colore;

    /*******************************************
    *REGINA
    *@brief 
    *******************************************/
    public Regina(Coppia c, int colore) {
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
        return 'r';
    }
}
