// int型集合クラスIntSetの利用例

public class IntSetTester {

	public static void main(String[] args) {
		IntSet s1 = new IntSet(20);
		IntSet s2 = new IntSet(20);
		IntSet s3 = new IntSet(20);

		s1.add(10);			// s1 = {10}
		s1.add(15);			// s1 = {10, 15}
		s1.add(20);			// s1 = {10, 15, 20}
		s1.add(25);			// s1 = {10, 15, 20, 25}

		s1.copyTo(s2);		// s2 = {10, 15, 20, 25}
		s2.add(12);			// s2 = {10, 15, 20, 25, 12}
		s2.remove(25);		// s2 = {10, 15, 20, 12}

		s3.copyFrom(s2);	// s3 = {10, 15, 20, 12}

		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);

		System.out.println("集合s1に15は" + (s1.contains(15) ? "含まれる" : "含まれない"));

		System.out.println("集合s2に25は" + (s2.contains(25) ? "含まれる" : "含まれない"));

		System.out.println("集合s1とs2は" + (s1.equalTo(s2) ? "等しい" : "等しくない"));

		System.out.println("集合s2とs3は" + (s2.equalTo(s3) ? "等しい" : "等しくない"));

		s3.unionOf(s1, s2);		// s3 ← s1 ∪ s2

		System.out.println("集合s1とs2の和集合は" + s3);
		System.out.println("集合s1は" + (s1.isEmpty() ? "空である" : "空でない"));
		System.out.println("集合s2は" + (s2.isEmpty() ? "満杯である" : "満杯でない"));
		System.out.println("集合s3を空にしました");
		s3.clear();
		System.out.println("s3 = " + s3);
	}
}
