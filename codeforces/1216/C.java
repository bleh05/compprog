import java.util.*;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigInteger;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int x1=sc.nextInt();
		int y1=sc.nextInt();
		int x12=sc.nextInt();
		int y12=sc.nextInt();
		int x2=sc.nextInt();
		int y2=sc.nextInt();
		int x22=sc.nextInt();
		int y22=sc.nextInt();
		int x3=sc.nextInt();
		int y3=sc.nextInt();
		int x32=sc.nextInt();
		int y32=sc.nextInt();
		long max1x = Math.max(x1,x2);
		long max1y = Math.max(y1,y2);
		long min1x = Math.min(x12,x22);
		long min1y = Math.min(y12,y22);
		long max2x = Math.max(x1,x3);
		long max2y = Math.max(y1,y3);
		long min2x = Math.min(x12,x32);
		long min2y = Math.min(y12,y32);
		long max3x = Math.max(x1,Math.max(x2,x3));
		long max3y = Math.max(y1,Math.max(y2,y3));
		long min3x = Math.min(x12,Math.min(x22,x32));
		long min3y = Math.min(y12,Math.min(y22,y32));
		long a0 = (long)(x12-x1)*(long)(y12-y1);
		if((min1x-max1x<0||min1y-max1y<0)&&(min2x-max2x<0||min2y-max2y<0)) {
			pw.println("YES");
		}
		else {
			long a1 = Math.max(0,(min1x-max1x)*(min1y-max1y));
			long a2 = Math.max(0,(min2x-max2x)*(min2y-max2y));
			long a3 = Math.max(0,(min3x-max3x)*(min3y-max3y));
			pw.println(a1+a2-a3>=a0?"NO":"YES");
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