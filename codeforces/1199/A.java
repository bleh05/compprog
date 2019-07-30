import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int bef = sc.nextInt();
		int af = sc.nextInt();
		for(int i=0;i<n;i++) {arr[i]=sc.nextInt();}
		loop:
		for(int i=0;i<n;i++) {
			
			for(int j=Math.max(0,i-bef);j<Math.min(n, i+af+1);j++) {
				if(arr[j]<arr[i])continue loop;
			}
			pw.println(i+1);
			break;
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