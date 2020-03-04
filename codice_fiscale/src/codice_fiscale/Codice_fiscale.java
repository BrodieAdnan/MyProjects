/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codice_fiscale;

import java.util.Scanner;

/**

 @author Alessandro Casarin
 */
public class Codice_fiscale {

	/**
	 @param args the command line arguments
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Dimmi il cognome, il nome, il sesso, la data e il comune di nascita");
		System.out.print("cognome: ");
		String cognome = input.nextLine();
		System.out.print("nome: ");
		String nome = input.nextLine();
		System.out.print("sesso: ");
		String sesso = input.nextLine();
		System.out.print("data: ");
		String data = input.nextLine();
		System.out.print("Scrivi il mese per esteso: ");
		String mese = input.nextLine();
		System.out.print("comune: ");
		String comune = input.nextLine();
		String codice = "";
		String vocali = "";
		String consonanti = "";
		String aiuto = "";
		int i = 0;
		int j = 0;
		cognome = cognome.toLowerCase();
		for (i = 0; i < cognome.length(); i++) {
			if (cognome.charAt(i) != 'a' && cognome.charAt(i) != 'e' && cognome.charAt(i) != 'i' && cognome.charAt(i) != 'o' && cognome.charAt(i) != 'u') {
				consonanti += cognome.charAt(i);
			} else {
				vocali += cognome.charAt(i);
			}
		}
		aiuto += consonanti;
		aiuto += vocali;
		aiuto = aiuto.toUpperCase();
		for (j = 0; j < 3; j++) {
			if (j > aiuto.length()) {
				codice += 'X';
			} else {
				codice += aiuto.charAt(j);
			}
		}
		vocali = "";
		consonanti = "";
		aiuto = "";
		nome = nome.toLowerCase();
		for (i = 0; i < nome.length(); i++) {
			if (nome.charAt(i) != 'a' && nome.charAt(i) != 'e' && nome.charAt(i) != 'i' && nome.charAt(i) != 'o' && nome.charAt(i) != 'u') {
				consonanti += nome.charAt(i);
			} else {
				vocali += nome.charAt(i);
			}
		}
		if (consonanti.length() > 4) {
			aiuto += consonanti.charAt(0);
			aiuto += consonanti.substring(2, consonanti.length() - 1);
		} else {
			aiuto += consonanti;
			aiuto += vocali;
		}
		aiuto = aiuto.toUpperCase();
		int k = 0;
		for (j = 3; j < 6; j++) {
			if (k > aiuto.length()) {
				codice += 'X';
			} else {
				codice += aiuto.charAt(k);
			}
			k++;
		}
		codice += data.charAt(data.length() - 2);
		codice += data.charAt(data.length() - 1);
		String mesi[] = new String[]{"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};
		String Lmesi[] = new String[]{"A", "B", "C", "D", "E", "H", "L", "M", "P", "R", "S", "T"};
		boolean trovato = false;
		int pos = 0;
		for (i = 0; i < 12 && !trovato; i++) {
			if (mese.equals(mesi[i])) {
				pos = i;
				trovato = true;
			}
		}
		codice += Lmesi[pos];
		if (sesso.charAt(0) == 'm' || sesso.charAt(0) == 'M') {
			codice += data.charAt(0);
			codice += data.charAt(1);
		} else {
			codice += (data.charAt(0) + 40);
			codice += (data.charAt(1) + 40);
		}
		if (comune.equals("Venezia")) {
			codice += "L736";
		} else if (comune.equals("Mirano")) {
			codice += "F241";
		} else if (comune.equals("Spinea")) {
			codice += "I908";
		} else if (comune.equals("Treviso")) {
			codice += "L407";
		} else if (comune.equals("Belluno")) {
			codice += "A757";
		} else if (comune.equals("Marcon")) {
			codice += "E936";
		} else if (comune.equals("Mogliano")) {
			codice += "F268";
		} else if (comune.equals("Chioggia")) {
			codice += "C638";
		} else if (comune.equals("Dolo")) {
			codice += "D325";
		} else if (comune.equals("Rovigo")) {
			codice += "H620";
		}
		char pari[] = new char[26];
		pari[0] = 'A';
		pari[1] = 'B';
		pari[2] = 'C';
		pari[3] = 'D';
		pari[4] = 'E';
		pari[5] = 'F';
		pari[6] = 'G';
		pari[7] = 'H';
		pari[8] = 'I';
		pari[9] = 'J';
		pari[10] = 'K';
		pari[11] = 'L';
		pari[12] = 'M';
		pari[13] = 'N';
		pari[14] = 'O';
		pari[15] = 'P';
		pari[16] = 'Q';
		pari[17] = 'R';
		pari[18] = 'S';
		pari[19] = 'T';
		pari[20] = 'U';
		pari[21] = 'V';
		pari[22] = 'W';
		pari[23] = 'X';
		pari[24] = 'Y';
		pari[25] = 'Z';
		char dispari[] = new char[26];
		dispari[0] = 'B';
		dispari[1] = 'A';
		dispari[2] = 'K';
		dispari[3] = 'P';
		dispari[4] = 'L';
		dispari[5] = 'C';
		dispari[6] = 'Q';
		dispari[7] = 'D';
		dispari[8] = 'R';
		dispari[9] = 'E';
		dispari[10] = 'V';
		dispari[11] = 'O';
		dispari[12] = 'S';
		dispari[13] = 'F';
		dispari[14] = 'T';
		dispari[15] = 'G';
		dispari[16] = 'U';
		dispari[17] = 'H';
		dispari[18] = 'M';
		dispari[19] = 'I';
		dispari[20] = 'N';
		dispari[21] = 'J';
		dispari[22] = 'W';
		dispari[23] = 'Z';
		dispari[24] = 'Y';
		dispari[25] = 'X';
		int somma = 0;
		for (i = 0; i < 15; i++) {
			if (i % 2 == 0) {
				if (i <= 9) {
					somma += i;
				} else {
					for (j = 0; j < 26; j++) {
						if (codice.charAt(i) == pari[j]) {
							somma += j;
						}
					}
				}
			} else {
				for (k = 0; k < 26; k++) {
					if (codice.charAt(i) == dispari[k]) {
						somma += k;
					}
				}
			}
		}
		codice += pari[somma % 26];
		System.out.println (codice);
	}

}

