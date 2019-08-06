import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int l = sc.nextInt();
		int t = sc.nextInt();
		Node[] n = new Node[l];
		for(int i=0;i<l;i++)n[i]=new Node(i+1);
		int out =0;
		for(int i=0;i<t;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			n[x-1].addc(n[y-1]);
		}
		for(int i=0;i<l;i++) {
			out=Math.max(out, getLayer(n[i]));
		}
		pw.println(out);
		pw.close();
	}
	public static int getLayer(Node n) {
		if(n.layer>-1)return n.layer;
		else if(n.c.isEmpty())return 0;
		else {
			int temp =0;
			for(Node x : n.c) {	
				temp=Math.max(temp, getLayer(x)+1);
			}
			n.layer=temp;
			return temp;
		}
	}
	static class Node{
		int layer;
		int val;
		ArrayList<Node> c;
		public Node(int v) {
			val=v;
			layer=-1;
			c=new ArrayList<Node>();
		}
		public void addc(Node n) {
			c.add(n);
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