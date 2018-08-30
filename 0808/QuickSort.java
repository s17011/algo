import java.util.*;

class QuickSort {
	static void quickSort(int[] list,int left,int right){
		int pl = left;
		int pr = right;
		int mid = list[(pl+pr)/2];
		
		System.out.printf("list[%d]~list[%d] : {",left,right);
		for(int i=left;i<right;i++){
			System.out.printf("%d,",list[i]);
		}
		System.out.printf("%d}\n",list[right]);
		
		do{
			while(list[pl] < mid){
				pl++;
			}
			while(list[pr] > mid){
				pr--;
			}
			if(pl <= pr){
				swap(list,pl++,pr--);
			}
		}while(pl <= pr);
		
		if(pl-left < right-pr){
			int tmp;
			tmp = left;
			left = pl;
			pl = tmp;
			
			tmp = right;
			right = pr;
			pr = tmp;
		}
		
		if(left < pr){
			quickSort(list,left,pr);
		}
		if(pl < right){
			quickSort(list,pl,right);
		}
	}
	
	static void swap(int[] list,int d1,int d2){
		int tmp;
		tmp = list[d1];
		list[d1] = list[d2];
		list[d2] = tmp;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random csl = new Random();
	
		System.out.printf("クイックソート\n");
		System.out.printf("要素数:");
		int size = input.nextInt();
		
		int[] list = new int[size];
		for(int i=0;i<size;i++){
			list[i] = csl.nextInt(99) + 1;
		}
	
		System.out.printf("ソート前\n");
		show(list);
		System.out.printf("\n");
		
		quickSort(list,0,size-1);
		
		System.out.printf("\n");
		System.out.printf("ソート後\n");
		show(list);
	}
	
	static void show(int[] list){
		int size = list.length;
		for(int i=0;i<size;i++){
			System.out.printf("%d ",list[i]);
		}
		System.out.printf("\n");
	}
}
