package dizionario;

import java.util.*;

/**
 @author Riccardo Fusaro & Adnan Gazi Latif
 @date 28/03/2017
 @brief Contenitore di parole e definizioni.
 */
public class Vocabolario {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.print("Inserire la parola da cercare : ");
		String parolaCercata = input.next();
		Dizionario vocabolario = new Dizionario();
		vocabolario.INIT("dizionario.txt");
		vocabolario.getDefinizione(parolaCercata);
	}
}
