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
			int n = sc.nextInt();
			int bat = sc.nextInt();
			int cap = sc.nextInt();
			int r = cap;
			int[] path = new int[n];
			for(int i = 0;i<n;i++){
				path[i]=sc.nextInt();
			}
			int d = 0;
			for(int x : path){
				if(cap>=r){
					cap--;
					d++;
				}
				else if(bat>0&&x==1){
					bat--;
					cap=Math.min(cap+1, r);
					d++;
				}
				else if(cap>0){
					cap--;
					d++;
				}
				else if(bat>0){
					bat--;
					d++;
				}
				else{
					break;
				}
			}
			pw.println(d);
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