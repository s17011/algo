import java.util.*;

class E2_11{
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.printf("西暦何年?");
		int y = stdIn.nextInt();
		System.out.printf("何月?");
		int m = stdIn.nextInt();
		System.out.printf("何日?");
		int d = stdIn.nextInt();
		
		
		YMD ymd = new YMD(y,m,d);
		System.out.printf("何日後/前?");
		int n = stdIn.nextInt();
		
		
		YMD aft = ymd.after(n);
		System.out.printf("%d日後は%d/%d/%d\n",n,aft.year,aft.month,aft.day);
		YMD bef = ymd.before(n);
		System.out.printf("%d日前は%d/%d/%d\n",n,bef.year,bef.month,bef.day);
	}
}
