package ScacchiX4;

/********************************************************
 *@title ALFIERE
 *@package ScacchiX4
 *@brief 
********************************************************/

public class Alfiere extends Pezzo {

    private Coppia pos;
    private int colore;

    /*******************************************
    *ALFIERE
    *@brief 
    *******************************************/
    public Alfiere(Coppia c, int colore) {
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
        return 'a';
    }
}
