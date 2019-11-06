import java.util.*;
import java.io.*;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(".out")));
		PrintWriter pw = new PrintWriter(System.out);
		long l =sc.nextLong();
		long r = 0;
		int ct=0;
		for(long i=2; i*i<=l;i++) {
			if(l%i==0) {
				ct++;
				r=i;
				while(l%i==0) {
					l/=i;
				}
			}
		}
		if(l>1) {
			ct++;
			r=l;
		}
		if(ct==1) {
			pw.println(r);
		}
		else pw.println(1);
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