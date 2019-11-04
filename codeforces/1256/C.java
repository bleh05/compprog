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
			int p = sc.nextInt();
			int j = sc.nextInt();
			int[] plat = new int[p];
			for(int i=0;i<p;i++){
				plat[i]=sc.nextInt();
			}
			int sum = 0;
			int ct = 0;
			int[] arr = new int[n];
			for(int i: plat){
				sum+=i+j-1;
				ct+=i;
			}
			sum+=j;
			int ind = 1;
			int pt=0;
			for(int i : plat){
				int st = Math.min(n-ct, pt+j-1);
				pt = st;
				for(;pt<st+i;pt++){
					arr[pt]=ind;
				}
				ct-=i;
				ind++;
			}
			if(sum>n){
				pw.println("YES");
				pw.println(arr[0]);
				for(int i = 1;i<arr.length;i++){
					pw.println(" "+arr[i]);
				}
			}
			else{
				pw.println("NO");
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