package poligono;

import java.util.Scanner;
import zuclib.Tartaruga;

/**
 * @author adnan.gazi
 */
public class Poligono {
    public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("Quanti lati vuoi per il poligono?");
		int lati=input.nextInt();
		Tartaruga t = new Tartaruga();
		int angolo=360/lati;
		double lato=0.4;
		t.pennaSu();
		t.gotoXY(0.5 - lato / 2, 0.5 - lato / 2);
		t.pennaGiu();
		for (int i = 0; i < lati; i++) {
			t.avanti(lato);
			t.destra(angolo);
		}
	}

}
