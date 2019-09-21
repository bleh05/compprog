import java.util.*;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigInteger;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int x = sc.nextInt();
		p[] arr = new p[x];
		for(int i=1;i<=x;i++) {
			arr[i-1]=new p(i,sc.nextInt());
		}
		Arrays.sort(arr);
		long total = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<x;i++) {
			total+=arr[i].b*i+1;
			sb.append(arr[i].a+" ");
		}
		pw.println(total);
		pw.println(sb);
		pw.close();
	}
	static class p implements Comparable<p>{
		int a;int b;
		p(int a,int b){
			this.a=a;
			this.b=b;
		}
		public int compareTo(p o) {
			return -1*Integer.compare(b,o.b);
		}
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