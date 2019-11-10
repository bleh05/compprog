import java.util.*;
import java.io.*;
public class template {
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    int k = sc.nextInt();
	    ArrayList<edge> ar = new ArrayList<edge>();
	    for(int i=0;i<m;i++) {
	    	int a;
	    	int b;
	    	int c;
	    	ar.add(new edge(a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt()));
	    	//System.out.println(a+" " + b+" "+c);
	    }
	    
	    Collections.sort(ar);
	    ArrayList<ArrayList<pair>> adjm = new ArrayList<ArrayList<pair>>();
	    for(int i=0;i<n;i++) {
	    	adjm.add(new ArrayList<pair>());
	    }
	    for(int i=0;i<Math.min(k,m);i++) {
	    	int a = ar.get(i).start-1;
	    	int b = ar.get(i).to-1;
	    	int c = ar.get(i).weight;
	    	adjm.get(a).add(new pair(b,c));
	    	adjm.get(b).add(new pair(a,c));
	    }
	    HashMap<pair,Long> out = new HashMap<pair,Long>();
	    for(int i=0;i<n;i++) {
	    	HashMap<Integer,Long> dp = new HashMap<Integer,Long>();
	    	Queue<pair2> bfs = new LinkedList<pair2>();
	    	bfs.add(new pair2(i,0));
	    	dp.put(i,(long)0);
	    	while(!bfs.isEmpty()) {
	    		pair2 cur = bfs.poll();
	    		for(pair x : adjm.get(cur.root)) {
	    			//System.out.println(dp.get(x.to)+" "+(cur.len+x.weight));
	    			if(dp.get(x.to)==null||dp.get(x.to)>cur.len+x.weight) {
	    				//System.out.println(x.weight);
	    				bfs.add(new pair2(x.to,cur.len+x.weight));
	    				dp.put(x.to,(long)cur.len+x.weight);
	    			}
	    			
	    		}
	    		
	    	}
	    	//System.out.println(dp);
	    	for(int ea : dp.keySet()) {
	    		if(dp.get(ea)!=0) {
	    			if(ea>i)
	    			out.put(new pair(i,ea),dp.get(ea));
	    		}
	    	}
	    }
	    ArrayList<Long> oo = new ArrayList<Long>(out.values());
	    Collections.sort(oo);
	    pw.println(oo.get(k-1));
	    pw.close();
	}
	static class edge implements Comparable<edge>{
		int start;
		int to;
		int weight;
		public edge(int s, int t, int w) {
			start=s;
			to=t;
			weight=w;
		}
		@Override
		public int compareTo(edge o) {
			return Integer.compare(weight, o.weight);
		}
		public String toString() {
			return start+" "+to+" " + weight;
		}
		
	}
	static class pair {
		int to;
		long weight;
		public pair(int to, long weight) {
			this.to=to;
			this.weight=weight;
		}
		public boolean equals(pair o) {
			return (o.to==weight&&o.weight==to)||(o.to==to&&o.weight==weight);
		}
		public String toString() {
			return to+" " + weight;
		}
	}
	static class pair2 { 
		int root;
		long len;
		public pair2(int root, long l) {
			this.root=root;
			this.len=l;
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