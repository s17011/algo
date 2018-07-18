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

		System.out.print("要素数:");
		int num = stdIn.nextInt();
		int[] x = new int[num];      // 要素数numの配列

		System.out.println("昇順に入力してください。");

		System.out.print("x[0]:");      // 先頭要素の読込み
		x[0] = stdIn.nextInt();

		for (int i = 1; i < num; i++) {
			do {
			System.out.print("x[" + i + "]:");
			x[i] = stdIn.nextInt();
			} while (x[i] < x[i - 1]);   // 一つ前の要素より小さければ再入力
		}

		System.out.print("探す値:");      // キー値の読込み
		int ky = stdIn.nextInt();

		int idx = binSearchView(x, num, ky);   // 配列xから値がkyの要素を探索

		if (idx == -1)
			System.out.println("その値の要素は存在しません。");
		else
			System.out.println("その値はx[" + idx + "]にあります。");
	}
}
