package quadrato_ricorsione;
import static zuclib.GraficaSemplice.*;
import java.util.*;

/**
 @author Riccardo Fusaro & Adnan Gazi Latif
 */
public class Quadrato_Ricorsione {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Inserire il numero dei quadrati");
		int nDecorazioni = input.nextInt();
		double lato = 0.95;
		double x=0.5;
		double y=0.5;
		setFinestra(600, 600, "Quadrato");
		ricorsioneQ(nDecorazioni, lato, x, y);
	}
	public static void ricorsioneQ(int n, double lato, double x0, double y0){
		if (n>0) {
			quadrato(x0, y0, lato);
			ricorsioneO(n-1, lato/2, x0, y0);
		}
	}
	public static void ricorsioneO(int n, double lato, double x0, double y0) {
		if(n>0){
		linea(x0,y0-lato,x0+lato,y0);
		linea(x0+lato,y0,x0,y0+lato);
		linea(x0,y0+lato,x0-lato,y0);
		linea(x0-lato,y0,x0,y0-lato);		
		ricorsioneQ(n-1, lato, x0, y0);
		}
	}
}
