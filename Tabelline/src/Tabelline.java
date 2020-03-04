/**
 * @author Marco Andrea Limongelli
 */
import java.util.*;
public class Tabelline 
{
    public static void main(String[] args) 
	{
		Scanner input = new Scanner (System.in);
		
		System.out.println("Dimmi il valore di N");
		int n= input.nextInt();
		int out;
		int conta=1;
		int fattore=1;
		int contav=1;
		
		while(conta<=n)
		{
			System.out.println();
			while(contav<n)
			{
				out=conta*fattore;
				fattore+=1;
				contav+=1;
				System.out.print(out+" ");
			}
			if(conta<2)
			{
				System.out.print(n+" ");
			}
			contav=0;
			fattore=1;
			conta=conta+1;
		}
    }
}
