import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    int n = sc.nextInt();
    for(int i=0;i<n;i++){
      int bottomr = -100000;
      int topr = 100000;
      int leftr=-100000;
      int rightr=100000;
      int  q = sc.nextInt();
      for(int f=0;f<q;f++){
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(sc.nextInt()==0)leftr=Math.max(leftr,x);
        if(sc.nextInt()==0)topr=Math.min(topr,y);
        if(sc.nextInt()==0)rightr=Math.min(rightr,x);
        if(sc.nextInt()==0)bottomr=Math.max(bottomr,y);
      }
    if(bottomr>topr||leftr>rightr)pw.println(0);
    else pw.println(1+" "+leftr+" "+bottomr);
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