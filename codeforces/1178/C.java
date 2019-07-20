import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class template {
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int x = sc.nextInt();
		int y = sc.nextInt();
		long r = power(2,x,998244353);
		long d = power(2,y,998244353);
		pw.println((r*d)%998244353);
		pw.close();
	}
	static long power(long x, long y, long p) 
	{ 
		long res = 1;      
	    x = x % p;  
	  
	    while (y > 0) 
	    { 
	        if((y & 1)==1) 
	            res = (res * x) % p; 
	        y = y >> 1;  
	        x = (x * x) % p;  
	    } 
	    return res; 
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