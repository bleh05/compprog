import java.util.*;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigInteger;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int[] x = new int[n];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			x[i]= sc.nextInt();
			max =Math.max(max, x[i]);
			min =Math.min(min, x[i]);
		}
		for(int i=0;i<n;i++) {
			x[i]-=min;
		}
		long tot = 0;
		for(int i=0;i<n;i++) {
			tot+=max-min-x[i];
		}
		int g = findGCD(x,n);
		pw.println(tot/g+" "+g);
		
		pw.close();
	}
	static int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
        return gcd(b % a, a); 
    } 
    static int findGCD(int arr[], int n) 
    { 
        int result = arr[0]; 
        for (int i = 1; i < n; i++) 
            result = gcd(arr[i], result); 
  
        return result; 
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