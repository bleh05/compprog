import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		Integer[] arr = new Integer[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		int ct = 0;
		boolean[] ar = new boolean[n];
		for(int i=0;i<n;i++) {
			if(!ar[i]) {
				ar[i]=true;
				ct++;
				int x = arr[i];
				for(int j=0;j<n;j++) {
					if(arr[j]%x==0) {
						ar[j]=true;
					}
				}
			}
		}
		
		pw.println(ct);
		pw.close();
	}
}
@SuppressWarnings("all")
class FastScanner {
    BufferedReader br;
    StringTokenizer st;
    public FastScanner(BufferedReader d) {
        br=d;
    }
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