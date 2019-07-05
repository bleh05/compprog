import java.util.Arrays;
import java.util.Scanner;

public class thanossort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ncop=n;
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int out =1;
		loop:
		while(ncop>1) {
			for(int i=0;i<n;i+=ncop) {
				if(checkSort(Arrays.copyOfRange(arr,i,i+ncop))) {
					out = ncop;
					break loop;
				}
			}
			ncop/=2;
		}
		System.out.println(out);
	}
	public static boolean checkSort(int[] x) {
		for(int i=0;i<x.length-1;i++) {
			if(x[i]>x[i+1]) {
				return false;
			}
		}
		return true;
	}
}
