import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int l = sc.nextInt();
		for(int i = 0;i<l;i++) {
			int n = sc.nextInt();
			int ind = 0;
			int ind2 = 0;
			int[] x  = new int[n];
			for(int j = 0;j<n;j++) {
				x[j]=sc.nextInt();
				if(x[j]==1)ind = j;
				if(x[j]==n)ind2 = j;
				
			}
			boolean fax = true;
			boolean fax2 = true;
			for(int j=ind+1;;j++) {
				if(x[j%n]==1)break;
				if(x[j%n]-x[(j-1)%n]!=1) {
					fax = false;
				}
			}
			for(int k= ind2+1;;k++) {
				if(x[k%n]==n)break;
				if(x[k%n]-x[(k-1)%n]!=-1) {
					fax2 = false;
				}
			}
			if(fax2||fax)pw.println("YES");
			else  pw.println("NO");
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