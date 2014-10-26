package sort;

public class QuickSort {
	
	public static void start() {
		int[] a = {5,7,8,4,7,3,7,2};
		QuickSort qs = new QuickSort();
		qs.qs(a, 0, a.length-1);
		for(int i = 0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
	}
	
	public void qs(int[] a, int low, int hight){
		if(low>=hight){
			return;
		}
		if((hight-low)==1){
			if(a[low]>a[hight])
				swap(a, low, hight);
			return;
		}
		int pivot = a[low];
		int i = low+1;
		int j = hight;
		while(true){	
			while(i<=j && a[i]<=pivot)
				i++;
			while(i<=j && a[j]>=pivot)
				j--;
			if(i<j)
				swap(a, i, j);
			else 
				break;
		}
		swap(a, low, j);
		qs(a, low, j-1);
		qs(a, j+1, hight);
	}
	
	public void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
