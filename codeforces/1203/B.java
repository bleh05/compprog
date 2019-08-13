import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int l = sc.nextInt();
		for(int i = 0;i<l;i++) {
			int n = sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for(int j=0;j<4*n;j++) {
				arr.add(sc.nextInt());
			}
			Collections.sort(arr);
			int[] ar = new int[n];
			boolean ret = true;
			int area = arr.get(0)*arr.get(arr.size()-1);
			int area2 = 0;
			for(int j=0;j<n;j++) {
				ar[j]=arr.get(0)*arr.get(arr.size()-1);
				area2= ar[j];
				if(area2!= area) {
					ret=false;
				}
				if(arr.get(0).equals(arr.get(1))) {
					arr.remove(0);
					arr.remove(0);
				}
				else {
					ret=false;
				}
				if(arr.get(arr.size()-1).equals(arr.get(arr.size()-2))) {
					arr.remove(arr.size()-1);
					arr.remove(arr.size()-1);
				}
				else {
					ret=false;
				}
			}
			if(ret)pw.println("YES");else pw.println("NO");			
		}
		pw.close();
	}
}
@SuppressWarnings("all")
class FastScanner {
    BufferedReader br;
    StringTokenizer st;
 
    public FastScanner(String s) {
        try {
            br = new BufferedReader(new FileReader(s));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
 
    String nextToken() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
 
    int nextInt() {
        return Integer.parseInt(nextToken());
    }
 
    long nextLong() {
        return Long.parseLong(nextToken());
    }
 
    double nextDouble() {
        return Double.parseDouble(nextToken());
    }
}