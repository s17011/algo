import java.util.Scanner;

class ChainHashName {

	static Scanner input = new Scanner(System.in);

	static class Data {
		static final int NO = 1;
		static final int NAME = 2;

		private Integer no;
		private String  name;

		String keyCode() {
			return name;
		}

		public String toString() {
			return Integer.toString(no);
		}

		void scan(String guide, int sw) {
			System.out.println(guide + "するデータを入力してください。");

			if ((sw & NO) == NO) {
				System.out.print("番号:");
				no = input.nextInt();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("名前:");
				name = input.next();
			}
		}
	}

	enum Menu {
		ADD("データ追加"),
		DELETE("データ削除"),
		SEARCH("データ探索"),
		DUMP("全データ表示"),
		FINISH("終了");

		private final String msg;

		static Menu MenuAt(int idx) {
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) {
			msg = string;
		}

		String getMsg() {
			return msg;
		}
	}

	static Menu SelectMenu() {
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMsg());
				if ((m.ordinal() % 3) == 2 &&
					  m.ordinal() != Menu.FINISH.ordinal())
					System.out.println();
			}
			System.out.print(":");
			key = input.nextInt();
		} while (key < Menu.ADD.ordinal() || key > Menu.FINISH.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu;
		Data data;
		Data tmp = new Data();

		ChainHash<String, Data> hash = new ChainHash<String, Data>(13);

		do {
			switch (menu = SelectMenu()) {
			 case ADD :	data = new Data();
				data.scan("追加", Data.NO | Data.NAME);
				int k = hash.add(data.keyCode(), data);
				switch (k) {
				case 1: System.out.println("そのキー値は登録済みです。");
							break;
				case 2: System.out.println("ハッシュ表が満杯です。");
							 break; 
				}
				break;

			 case DELETE :
				tmp.scan("削除", Data.NAME);
				hash.delete(tmp.keyCode());
				break;

			 case SEARCH :
				tmp.scan("探索", Data.NAME);
				Data t = hash.search(tmp.keyCode());
				if (t != null)
					System.out.println("そのキーをもつデータは" + t + "です");
				else
					System.out.println("該当するデータはありません");
				break;

			 case DUMP :
				hash.dump();
				break;
			}
		} while (menu != Menu.FINISH);
	}
}
