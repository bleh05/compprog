import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class template {
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		long[] arr = new long[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextLong();
		}
		long[] digits = new long[String.valueOf(arr[0]).length()*2+2];
		for(long x : arr) {
			long temp=x;
			int ct =0;
			while(temp>0) {
				digits[ct]+=temp%10*n;
				digits[ct+1]+=temp%10*n;
				ct+=2;
				temp/=10;
			}
		}
		
		
		BigInteger b = BigInteger.valueOf(0) ;
		for(int ct = 0;ct<digits.length;ct++) {
			BigInteger d = BigInteger.valueOf(digits[ct]) ;
			b=b.add(d.multiply(BigInteger.valueOf(10).pow(ct)));
		}
		pw.println(b.mod(new BigInteger("998244353")));
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