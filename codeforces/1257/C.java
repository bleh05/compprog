import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
 
public class DominatedSubarray {
 
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		for (int i=0;i<n;i++)
		{
			int min = 10000000;
			int size = sc.nextInt();
			sc.nextLine();
			String[] arr = sc.nextLine().split(" ");
			int[] arr1 = new int[size];
//			for (int a = 0;a<size;a++)
//			{
//				arr1[a]=Integer.parseInt(arr[a]);
//			}
	//		System.out.println(Arrays.toString(arr1));
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); 
			
			for(int b = 0;b<size;b++)
			{
				arr1[b]=Integer.parseInt(arr[b]);
				if (!map.containsKey(arr1[b]))
				{
					map.put(arr1[b],new ArrayList<Integer>());
					ArrayList<Integer> thing = map.get(arr1[b]);
					thing.add(b);
					map.replace(arr1[b], thing);
				}
				else
				{
					ArrayList<Integer> thing = map.get(arr1[b]);
					thing.add(b);
					map.replace(arr1[b], thing);
						min = Math.min(min, thing.get(thing.size()-1)-thing.get(thing.size()-2)+1);
				}
 
			}
			if(min==10000000)
				System.out.println(-1);
			else 
				System.out.println(min);
		}
	}
 
}