package ScacchiX4;

/********************************************************
 *@title CELLA
 *@package ScacchiX4
 *@brief 
********************************************************/

public class Cella {

    private boolean vuota;
    public Pezzo pezzo;

    /*******************************************
    *CELLA
    *@brief 
    *******************************************/
    public Cella() {
        pezzo = null;
        vuota = true;
    }

    /*******************************************
    *CELLA
    *@brief 
    *******************************************/
    public Cella(Pezzo p) {
        pezzo = p;
        vuota = false;
    }

    /*******************************************
    *MOSSO
    *@brief 
    *******************************************/
    public char mosso() {
        char ris = pezzo.type();
        pezzo = null;
        vuota = true;
        return ris;
    }

    /*******************************************
    *ARRIVA
    *@brief 
    *******************************************/
    public void arriva(Pezzo arrivato) {
        pezzo = arrivato;
        vuota = false;
    }

    /*******************************************
    *IS VUOTA
    *@brief 
    *******************************************/
    public boolean isVuota() {
        return vuota;
    }

    /*******************************************
    *CHECK
    *@brief 
    *******************************************/
    public boolean check(Coppia dest) {
        if (vuota) {
            return false;
        }
        return pezzo.check(dest);
    }
}
