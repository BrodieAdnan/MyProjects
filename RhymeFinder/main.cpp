#include <iostream>
#include <fstream>

/************************************************************************************
 *@author Gazi Adnan Latif
 *@brief ricerca in oggetto 'dizionario' delle rime coerenti con una parola inserita.
 *@date 29/03/2017
 *@version 1
 ************************************************************************************/

using namespace std;

ifstream dizionario("/home/studente/RhymeFinder/words_italian.win.txt");

int main(int argc, char *argv[])
{
    //testDizionario();
    cout << "Inscerisci la parola della quale vuoi trovare le rime : " << endl;
    string parolaCercata;
    cin >> parolaCercata;
    cout << "Sto eleborando le rime disponibili per " + parolaCercata + "..."<< endl;
    cercaRime(parolaCercata);
    return 0;
}

void cercaRime(string rime){
cout << "ciao" << endl;
}

void testDizionario(){
    if(dizionario){
    cout << "funziona correttamente" << endl;
    }else {
        cout << "non funziona corretamente" << endl;
    }
}
