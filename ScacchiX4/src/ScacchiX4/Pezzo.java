package ScacchiX4;

/******************************************************************
 *@title PEZZO
 *@package ScacchiX4
 *@brief Classe Astratta dalla quale derivano i pezzi degli scacchi
 *@brief 
*******************************************************************/

public abstract class Pezzo {

    /*******************************************
    *CHECK
    *@brief 
    *******************************************/
    abstract boolean check(Coppia c);

    /*******************************************
    *TYPE
    *@brief 
    *******************************************/
    abstract char type();
}
