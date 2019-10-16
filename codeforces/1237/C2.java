import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	 public static void main(String[] args) {
		 FastScanner sc = new FastScanner();
		 PrintWriter pw = new PrintWriter(System.out);
		 int n = sc.nextInt();
		 PriorityQueue<point> pq = new PriorityQueue<point>();
		 for(int i=0;i<n;i++) {
			 pq.add(new point(i+1,sc.nextInt(),sc.nextInt(),sc.nextInt()));
		 }
		 PriorityQueue<point> pq2 = new PriorityQueue<point>();
		 point curr = pq.poll();
		 while(!pq.isEmpty()) {
			 point temp = pq.poll();
			 if(curr.x==temp.x&&curr.y==temp.y) {
				 pw.println(curr.ind+" "+temp.ind);
				 curr=pq.poll();
				 if(pq.isEmpty()&&curr!=null)pq2.add(curr);
			 }
			 else {
				 pq2.add(curr);
				 curr = temp;
				 if(pq.isEmpty()&&curr!=null)pq2.add(temp);
			 }
		 }
		 PriorityQueue<point> pq3 = new PriorityQueue<point>();
		 if(!pq2.isEmpty()) {
			 curr = pq2.poll();
			 while(!pq2.isEmpty()) {
				 point temp = pq2.poll();
				 if(curr.x==temp.x) {
					 pw.println(curr.ind+" "+temp.ind);
					 curr=pq2.poll();
					 if(pq2.isEmpty()&&curr!=null)pq3.add(curr);
				 }
				 else {
					 pq3.add(curr);
					 curr = temp;
					 if(pq2.isEmpty()&&curr!=null)pq3.add(temp);
				 }
			 }
		 }
		 if(!pq3.isEmpty()) {
			 while(!pq3.isEmpty()) {
				 point a = pq3.poll();
				 point b = pq3.poll();
				 pw.println(a.ind+" "+b.ind);
			 }
		 }
		 pw.close();
		 
	 }
	 static class point implements Comparable<point>{
		 int ind, x,y,z;
		 point(int ind,int x,int y,int z){
			 this.ind=ind;
			 this.x =x;
			 this.y =y;
			 this.z=z;
		 }
		 @Override
		 public int compareTo(point o) {
			 if(o.x==x) {
				 if(o.y==y) {
					 return Integer.compare(z, o.z);
				 }
				 return Integer.compare(y,o.y);
			 }
			 return Integer.compare(x, o.x);
		 }
		 public String toString() {
			 return x+" "+y+" "+z;
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