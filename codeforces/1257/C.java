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
				int[] arr = new int[n];
				HashMap<Integer,ArrayList<Integer>> hm = new HashMap<Integer,ArrayList<Integer>>();
				for(int i=0;i<n;i++){
					arr[i]=sc.nextInt();
				}
				for(int i=0;i<n;i++){
					if(hm.get(arr[i])==null){
						hm.put(arr[i],new ArrayList<Integer>());
						hm.get(arr[i]).add(i);
					}
					else{
						hm.get(arr[i]).add(i);
					}
				}
				int min = Integer.MAX_VALUE;
				for(ArrayList<Integer> d : hm.values()){
					for(int i=0;i<d.size()-1;i++){
						min = Math.min(d.get(i+1)-d.get(i), min);
					}
				}
				pw.println(min==Integer.MAX_VALUE?-1:min+1);
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