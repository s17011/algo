import java.util.Scanner;

class E2_9 {
	// 各月の日数
	static int[][] mdays = {
		{31,28,31,30,31,30,31,31,30,31,30,31},
		{31,29,31,30,31,30,31,31,30,31,30,31}
	};
	
	//西暦year年は閏年か (閏年:1/平年:0)
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}
	
	static int leftDayOfYear(int y, int m, int d) {
		int days = 0;
		
		for (int i = mdays[0].length; i > m+1; i--) {
			days += mdays[isLeap(y)][i-1];
		}
		days += mdays[isLeap(y)][m-1] - d;
		return days;
		
//		for (int i = 1; i < m; i++) {
//			days += mdays[isLeap(y)][i-1];
//		}
//		return 365 + isLeap(y) - days;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int retry;
		
		System.out.println("年内の残り日数を調べます");
		
		do {
			System.out.print("年:"); int year  = stdIn.nextInt();
			System.out.print("月:"); int month = stdIn.nextInt();
			System.out.print("日:"); int day   = stdIn.nextInt();
			
			System.out.printf("あと%d日残っています \n",leftDayOfYear(year, month, day));
			
			System.out.print("もう1度しますか? (1...はい/0...いいえ) : ");
			retry = stdIn.nextInt();
		} while (retry == 1);
	}
}
