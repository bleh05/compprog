import java.util.*;
import java.io.*;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int l = sc.nextInt();
		int rem= sc.nextInt();
		char[] x = sc.nextToken().toCharArray();
		int[] freq = new int[26];
		for(char z : x) {
			freq[z-'a']++;
		}
		int ind = 0;
		while(rem>0) {
			int r = Math.min(freq[ind], rem);
			freq[ind]-=r;
			rem-=r;
			ind++;
		}
		StringBuilder out = new StringBuilder();
		for(int i=l-1;i>=0;i--) {
			if(freq[x[i]-'a']>0) {
				out.append(x[i]);
				freq[x[i]-'a']--;
			}
		}
		pw.println(out.reverse());
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