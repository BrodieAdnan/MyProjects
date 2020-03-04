package ScacchiX4;

/********************************************************
 *@title CAVALLO
 *@package ScacchiX4
 *@brief 
********************************************************/

public class Cavallo extends Pezzo {

    private Coppia pos;
    private int colore;
    
    /*******************************************
    *CAVALLO
    *@brief 
    *******************************************/
    public Cavallo(Coppia c, int colore) {
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
        return 'c';
    }
}
