package ScacchiX4;

/********************************************************
 *@title RE
 *@package ScacchiX4
 *@brief 
********************************************************/

public class Re extends Pezzo {

    private Coppia pos;
    private int colore;

    /*******************************************
    *RE
    *@brief 
    *******************************************/
    public Re(Coppia c, int colore) {
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
        return 'R';
    }
}
