import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    int f = sc.nextInt();
    for(int j=0;j<f;j++){
      int n = sc.nextInt();
      int div = sc.nextInt();
      int oddc=0;
      ArrayList<Integer> arrd = new ArrayList<Integer>();
      int[] arr = new int[n];
      for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
        if(arr[i]%2==1){
          oddc++;
          arrd.add(i);
        }
      }
      if(oddc>=div&&((oddc-div+1)%2)==1){
        pw.println("YES");
        for(int i=0;i<div-1;i++){
          pw.print(arrd.get(i)+1+" ");
        }
        pw.print(n);
        pw.println();
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