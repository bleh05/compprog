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
		long[] x = new long[39];
		for(int i=0;i<39;i++){
			x[i]=get3p(i);
		}
		for(int i =0 ;i<n;i++){
			long f = sc.nextLong();
			long r = f;
			StringBuilder t = new StringBuilder();
			for(int j=38;j>=0;j--){
				int app = 0;
				while(f>=x[j]){
					f-=x[j];
					app++;
				}
				t.append(app);
			}
			String str = t.toString();
			if(str.replaceAll("[01]", "").equals("")){
				pw.println(r);
			}
			else{
				int s=0;
				int ind = 0;
				for(int j =0;j<str.length();j++){
					if(str.charAt(j)>'0'&&s==0){
						s=j;
					}
					if(str.charAt(j)=='0'){
						ind = j;
					}
					if(str.charAt(j)=='2'){
						break;
					}
				}
				if(ind ==0){
					if(s==0){
						pw.println(0);
					}
					else{
						pw.println(get3p(39-s));
					}
				}
				else {
					long o = get3p(39-ind-1);
					for(int j = 0;j<ind;j++){	
						if(str.charAt(j)>'0'){
							o+=get3p(39-j-1);
						}
					}
					pw.println(o);
				}
			}
			
		}
		pw.close();
	}
	static long get3p(int x){
		long i = 1;
		for(int j = 0;j<x;j++){
			i*=3;
		}
		return i;
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