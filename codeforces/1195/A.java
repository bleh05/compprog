import java.util.*;
import java.io.*;
public class template {
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		HashMap<Integer, Integer> h = new HashMap<Integer,Integer>();
		int k = sc.nextInt();
		for(int i=1;i<=k;i++) {
			h.put(i,0);
		}
		for(int i=0;i<n;i++) {
			int z = sc.nextInt();
			h.put(z, h.get(z)+1);
		}
		int ct =0;
		for(int i=1;i<=k;i++) {
			if(h.get(i)%2==1)ct++;
		}
		pw.println(n-ct/2);
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