package ScacchiX4;

/********************************************************
 *@title SCHACCHIERA
 *@package ScacchiX4
 *@brief 
********************************************************/

public class Scacchiera {

    Cella tavola[][][] = new Cella[4][4][8];

    /*******************************************
    *SCACCHIERA
    *@brief 
    *******************************************/
    public Scacchiera() {

    }

    /*******************************************
    *MOVE PEZZO
    *@brief 
    *******************************************/
    public boolean movePezzo(Coppia inizio, Coppia fine) {
        return getCella(inizio).check(fine);
    }

    /*******************************************
    *GET CELLA
    *@brief 
    *******************************************/
    public Cella getCella(Coppia coppia) {
        return tavola[coppia.getX() / 4][coppia.getX() % 4][coppia.getY()];
    }
}
