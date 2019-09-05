import java.util.*;
import java.io.*;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int a = sc.nextInt();
		for(int i=0;i<a;i++) {
			int q = sc.nextInt();
			int h = sc.nextInt();
			int maxd=(int) (-1e9-1),  maxh=0;
			for(int j=0;j<q;j++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				maxd= Math.max(maxd, c-r);
				maxh= Math.max(maxh, c);
			}
			if(maxh>=h)pw.println(1);
			else if(maxd<0)pw.println(-1);
			else pw.println(Math.max(-1, (int)Math.ceil(((h-maxh)*1.0)/maxd)+1));
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