package ScacchiX4;

/********************************************************
 *@title PEDONE
 *@package ScacchiX4
 *@brief 
********************************************************/

public class Pedone extends Pezzo {

    private Coppia pos;
    private int colore;

    /*******************************************
    *PEDONE
    *@brief 
    *******************************************/
    public Pedone(Coppia c, int colore) {
        pos = c;
        this.colore = colore;
    }

    /*******************************************
    *CHECK
    *@brief 
    *******************************************/
    @Override
    boolean check(Coppia c) {
        return false;
    }

    /*******************************************
    *TYPE
    *@brief 
    *******************************************/
    @Override
    char type() {
        return 'p';
    }
}
