import java.util.*;
import java.io.*;
public class template {
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	    int n = sc.nextInt();
	    for(int r=0;r<n;r++){
	      int b = sc.nextInt();
	      int w = sc.nextInt();
	      if(w<b&&w*3+1>=b){
	        pw.println("YES");
	        int x = 2;
	        int y = 2;
	        while(w>0){
	          pw.println(x+" "+y);
	          pw.println(x-1+" "+y);
	          b--;
	          w--;
	          if(b-w>=2){
	            pw.println(x+" "+(y+1));
	            pw.println(x+" "+(y-1));
	            b-=2;
	          }
	          else if(b-w==1){
	            pw.println(x+" "+(y-1));
	            b--;
	          }
	          if(b==1&&w==0)
		            pw.println(x+1+" "+y);
	          x+=2;
	        }
	      }
	      else if(b<=w&&b*3+1>=w){
	        pw.println("YES");
	        int x = 3;
	        int y= 2;
	        while(b>0){
	          pw.println(x+" "+y);
	          pw.println(x-1+" "+y);
	          b--;
	          w--;
	          if(w-b>=2){
	            pw.println(x+" "+(y+1));
	            pw.println(x+" "+(y-1));
	            w-=2;
	          }
	          else if(w-b==1){
	            pw.println(x+" "+(y-1));
	            w--;
	          }
			  if(w==1&&b==0) {
				 pw.println(x+1+" "+y);
			  }
			  x+=2;
	        }
	      }
	      else pw.println("NO");
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