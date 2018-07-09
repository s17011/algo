import java.util.Scanner;

class E1_17 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n;
		
		do{
			System.out.print("段数:");
			n = stdIn.nextInt();
		}while(n <= 0);
		
		npira(n);
	}
	
		static void npira(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n-i+1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i-1; j++) {
				System.out.print(i % 10);
			}
			System.out.println();
		}
	}
}
