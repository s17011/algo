import java.util.*;

class GqueueTester {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Gqueue<String> s = new Gqueue<String>(100);

		while (true) {
			System.out.println("現在のデータ数:" + s.size() + " / " + s.capacity());
			System.out.print("(1)エンキュー (2)デキュー (3)ピーク " + "(4)ダンプ (5)探索 (0)終了:");

			int menu = input.nextInt();
			if (menu == 0) break;

			int idx;
			String x;

			switch (menu) {
			case 1: 
				System.out.print("データ:");
				x = input.next();
				try {
					s.enque(x);
				} catch (Gqueue.OverflowGqueueException e) {
					System.out.println("キューが満杯です。");
				}
				break;

			case 2: 
				try {
					x = s.deque();
					System.out.println("デキューしたデータは" + x + "です。");
				} catch (Gqueue.EmptyGqueueException e) {
					System.out.println("キューが空です。");
				}
				break;

			case 3: 
				try {
					x = s.peek();
					System.out.println("ピークしたデータは" + x + "です。");
				} catch (Gqueue.EmptyGqueueException e) {
					System.out.println("キューが空です。");
				}
				break;

			case 4: 
				s.dump();
				break;

			case 5: 
				System.out.print("探索するデータ:");
				x = input.next();
				idx = s.search(x);
				if (idx != -1)
					System.out.println("そのデータは" + idx + "番目に存在します。");
				else
					System.out.println("そのデータは存在しません。");
				break;
			}
		}
	}
}
