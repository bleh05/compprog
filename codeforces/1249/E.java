import java.util.*;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigInteger;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int n  = sc.nextInt();
		int c = sc.nextInt();
		int[] st = new int[n-1];
		int[] stsum = new int[n];
		for(int i=0;i<st.length;i++){
			st[i]=sc.nextInt();
			stsum[i+1]=stsum[i]+st[i];
		}
		int[] ele = new int[n-1];
		int[] eleum = new int[n];
		for(int i=0;i<st.length;i++){
			ele[i]=sc.nextInt();
			eleum[i+1]=eleum[i]+ele[i];
		}
		int[] dp = new int[n];
		int[] dp2 = new int[n];
		dp[1]=st[0];
		dp2[1]=ele[0]+c;
		for(int i=2;i<n;i++){
			dp[i]=Math.min(dp[i-1]+st[i-1], dp2[i-1]+ele[i-1]);

			dp2[i]=Math.min(dp[i-1]+st[i-1]+c, dp2[i-1]+ele[i-1]);
		}
		pw.print(0);
		for(int j=1;j<dp.length;j++){
			pw.print(" "+(Math.min(dp[j],dp2[j])));
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