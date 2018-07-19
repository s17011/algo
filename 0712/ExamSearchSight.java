import java.util.*;

class ExamSearchSight {

	static class data{
		String name;
		int height;
		double sight;

		public data(String name,int height,double sight){
			this.name = name;
			this.height = height;
			this.sight = sight;
		}

		public String toString(){
			return name + " " + height + " " + sight;
		}

		public static final Comparator<data> SIGHT_ORDER = new SightOrderComparator();

		public static class SightOrderComparator implements Comparator<data> {
			public int compare(data d1, data d2) {
				return (d1.sight > d2.sight) ? 1 : (d1.sight < d2.sight) ? -1 : 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		data[] x = {
			new data("赤坂忠雄",162,0.3),
			new data("長浜良一",168,0.4),
			new data("加藤富明",173,0.7),
			new data("松富明雄",169,0.8),
			new data("浜田哲明",174,1.2),
			new data("武田信也",171,1.5),
			new data("斉藤正二",175,2.0)
		};
		System.out.print("探す視力:");
		double sight = input.nextDouble();
		
		int idx = Arrays.binarySearch(x, new data("", 0, sight),data.SIGHT_ORDER);

		if (idx < 0){
			System.out.println("その視力のデータは存在しません。");
		}
		else{
			System.out.println("その値はx[" + idx + "]にあります。");
			System.out.println("データ:" + x[idx]);
		}
	}
}
