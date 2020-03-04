
import java.util.Scanner;

public class QuadratoMagico
{

	public static void costruisciQuadratoMagico(int[][] mat, int n)
	{
		int p = 1;
		int r = 0;
		int c = n / 2;
		mat[r][c] = p;
		while (p != n * n)
		{
			p++;
			if (r == 0 && c != 0)
			{
				c--;
				r = n - 1;
				mat[r][c] = p;
			} else if (r != 0 && c == 0)
			{
				r--;
				c = n - 1;
				mat[r][c] = p;
			} else if ((r == 0 && c == 0) || mat[r - 1][c - 1] != 0)
			{
				r++;
				mat[r][c] = p;
			} else
			{
				r--;
				c--;
				mat[r][c] = p;
			}
		}
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner (System.in);
		int n= input.nextInt();
		while(n%2==0){
			System.out.print("dimmi il valore di n: ");
			n = input.nextInt();
		}
		int[][] quadrato = new int[n][n];
		costruisciQuadratoMagico(quadrato, n);
		for (int r = 0; r < n; r++)
		{
			for (int c = 0; c < n; c++)
			{
				System.out.print(quadrato[r][c] + " ");
			}
			System.out.println("");
		}
	}

}
