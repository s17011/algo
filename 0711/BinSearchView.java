import java.util.Scanner;

class BinSearchView {
	static int binSearchView(int[] a, int n, int key) {
		System.out.print("   |");
		for (int k = 0; k < n; k++)
			System.out.printf("%4d", k);
		System.out.println();

		System.out.print("---+");
		for (int k = 0; k < 4 * n + 2; k++)
			System.out.print("-");
		System.out.println();

		int pl = 0;
		int pr = n - 1;

		do {
			int   pc = (pl + pr) / 2;
			System.out.print("   |");
			if (pl != pc)
				System.out.printf(String.format("%%%ds<-%%%ds+",(pl * 4) + 1, (pc - pl) * 4),"", "");
			else
				System.out.printf(String.format("%%%ds<-+",   pc * 4 + 1), "");
			if (pc != pr)
				System.out.printf(String.format("%%%ds->\n",(pr - pc) * 4 - 2), "");
			else
				System.out.println("->");
				System.out.printf("%3d|", pc);
			for (int k = 0; k < n; k++)
				System.out.printf("%4d", a[k]);
			System.out.println("\n   |");
			if (a[pc] == key)
				return pc;
			else if (a[pc] < key)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr);
		return -1;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		int[] x = {1,2,3,4,5,6,7,8,9,10};
		int num = x.length;
		
		System.out.print("探す値:");
		int ky = stdIn.nextInt();
		
		int idx = binSearchView(x, num, ky);
		
		if (idx == -1)
			System.out.println("その値の要素は存在しません。");
		else
			System.out.println("その値はx[" + idx + "]にあります。");
	}
}
