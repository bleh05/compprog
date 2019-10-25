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
		for(int i=0;i<n;i++){
			int ppl = sc.nextInt();
			long dol = sc.nextLong();
			ArrayList<pair> arr = new ArrayList<pair>();
			ArrayList<pair> arr2 = new ArrayList<pair>();
			for(int j=0;j<ppl;j++){
				arr.add(new pair(sc.nextInt(),sc.nextInt()));
				arr2.add(arr.get(j));
			}
			Collections.sort(arr, new pairx());
			Collections.sort(arr2, new pairy());
			int[] x = new int[ppl];
			for(int j=0;j<x.length;j++){
				x[j]=arr.get(j).x;
				dol-=arr.get(j).x;
			}
			int l = 0;
			int r = (int)1e9;
			int m = 0;
			while(r>=l){
	            m = l + (r - l) / 2;
	            if(fill(m,x,arr)==dol){
	            	r=m;
	            	break;
	            }
	            if(fill(m,x,arr)>dol){
	            	r = m-1;
	            }
	            else{
	            	l=m+1;
	            }
	            //System.out.println(r+" "+l);
			}
			//pw.println(l+" "+r);
			//pw.println(fill(r,x,arr2));
			pw.println(Math.min(Math.max(x[ppl/2],r),arr2.get(ppl/2).y));
		}
		pw.close();
	}
	static long fill(int dols, int[] x,ArrayList<pair> y){
		int mid = x.length/2;
		long sum = 0;
		for(int i = x.length-1;mid>=0;i--){
			if(i==-1){
				return Long.MAX_VALUE;
			}
			if(y.get(i).y<dols){
				continue;
			}
			else{
				sum+=Math.max(0, dols-x[i]);
				mid--;
			}
		}
		return sum;
	}
	static class pair {
		int x,y;
		public pair(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	static class pairx implements Comparator<pair>{
		public int compare(pair a, pair b){
			return Integer.compare(a.x,b.x);
		}
	}
	static class pairy implements Comparator<pair>{
		public int compare(pair a, pair b){
			return Integer.compare(a.y,b.y);
		}
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