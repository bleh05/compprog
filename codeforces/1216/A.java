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
		String str = sc.nextToken();
		StringBuilder sb = new StringBuilder();
		int a = 0;
		int op = 0;
		for(int i=0;i<x;i++) {
			if(i%2==0) {
				sb.append(str.charAt(i));
				if(str.charAt(i)=='a') {
					a++;
				}
				else {
					a--;
				}
			}
			if(i%2==1&&a!=0) {
				if(a==1) {
					if(str.charAt(i)=='a')
					op++;
					sb.append('b');
					a--;
				}
				else {
					if(str.charAt(i)=='b')
					op++;
					sb.append('a');
					a++;
				}
			}
		}
		pw.println(op+"\n"+sb);
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