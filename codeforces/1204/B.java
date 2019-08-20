import java.util.*;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigInteger;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		long[] arr = new long[a];
		long[] brr = new long[a];
		arr[0]=1;
		brr[0]=1;
		long sum=0;
		long sum2=0;
		for(int i=1;i<c;i++) {
			arr[i]=arr[i-1]*2;
		}
		for(int i=1;i<b;i++) {
			brr[i]=brr[i-1]*2;
		}
		for(int i=c;i<a;i++) {
			arr[i]=arr[i-1];
		}
		for(int i=b;i<a;i++) {
			brr[i]=1;
		}
		for(long i:arr) {
			sum+=i;
		}
		for(long i:brr) {
			sum2+=i;
		}
		pw.println(sum2+" "+sum);
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