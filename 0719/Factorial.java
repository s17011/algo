import java.util.*;

class Factorial {

	static int factorial(int n) {
		int fct = 1;

		while (n > 1)
			fct *= n--;
		return (fct);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("整数を入力せよ:");
		int x = input.nextInt();

		System.out.println(x + "の階乗は" + factorial(x) + "です。");
	}
}


