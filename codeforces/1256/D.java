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
			int t = sc.nextInt();
			while(t-->0){
				int n = sc.nextInt();
				long sw = sc.nextLong();
				ArrayList<Integer> ind1 = new ArrayList<Integer>();
				ArrayList<Integer> ind0 = new ArrayList<Integer>();
				String str = sc.nextToken();
				for(int i = 0 ;i<str.length();i++){
					if(str.charAt(i)=='1'){
						ind1.add(i);
					}
					else{
						ind0.add(i);
					}
				}
				char[] x = new char[n];
				int ind =0;
				while(sw>0&&ind<ind0.size()){
					x[(int) Math.max(ind, ind0.get(ind)-sw)]='0';
					sw-=ind0.get(ind)-ind;
					ind++;
				}
				for(int i = ind;i<ind0.size();i++){
					x[ind0.get(i)]='0';
				}
				for(int i = 0;i<n;i++){
					if(x[i]!='0'){
						x[i]='1';
					}
				}
				pw.println(new String(x));
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