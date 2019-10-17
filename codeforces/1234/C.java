import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	 public static void main(String[] args) {
		 FastScanner sc = new FastScanner();
		 PrintWriter pw = new PrintWriter(System.out);
		 int t = sc.nextInt();
		 while(t-->0) {
			 int n = sc.nextInt();
			 char[]x = sc.nextToken().toCharArray();
			 char[]y = sc.nextToken().toCharArray();
			 int dir = 0;
			 boolean ret = false;
			 for(int i=0;i<n;i++) {
				 if(x[i]>'2'&&y[i]>'2') {
					 dir^=1;
				 }
				 else if(dir==0&&x[i]<'3') {
				 }
				 else if(dir==1&&y[i]<'3') {
				 }
				 else {
					 break;
				 }
				 if(i==n-1&&dir==1) {
					ret=true;
				 }
			 }
			 pw.println(ret?"YES":"NO");
			 
		 }
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