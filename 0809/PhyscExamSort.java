import java.util.*;

class PhyscExamSort {
	static class data {
		String name;
		int	 height;
		double sight;
		
		public data(String name, int height, double sight) {
			this.name = name;  this.height = height;  this.sight = sight;
		}
		
		public String toString() {
			return name + " " + height + " " + sight;
		}
		
		static final Comparator<data> SIGHT_ORDER = new SightOrderComparator();

		private static class SightOrderComparator
										implements Comparator<data> {
			public int compare(data d1, data d2) {
				return (d1.sight < d2.sight) ?  1 :
						 (d1.sight > d2.sight) ? -1 : 0;
			}
		}
	}
	
	public static void main(String[] args) {
		data[] x = {
				new data("赤坂忠雄", 162, 0.3),
				new data("加藤富明", 173, 0.7),
				new data("斉藤正二", 175, 2.0),
				new data("武田信也", 171, 1.5),
				new data("長浜良一", 168, 0.4),
				new data("浜田哲明", 174, 1.2),
				new data("松富明雄", 169, 0.8),
			};
			
		Arrays.sort(x, data.SIGHT_ORDER);
		
		System.out.println("■ 身体検査一覧表 ■");
		System.out.println(" 氏名      身長 視力");
		System.out.println("--------------------");
		for (int i = 0; i < x.length; i++)
			System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].sight);
	}
}


