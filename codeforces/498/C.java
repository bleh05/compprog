
// Problem : C. Array and Operations
// Contest : Codeforces - Codeforces Round #284 (Div. 1)
// URL : https://codeforces.com/contest/498/problem/C
// Memory Limit : 256 MB
// Time Limit : 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

import java.io.*;
import java.util.*;

public class a implements Runnable{
	
    public static void main(String[] args) {
        new Thread(null, new a(), "process", 1<<26).start();
    }
	public void run() {
		FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		//PrintWriter out = new PrintWriter("file.out");
		Task solver = new Task();
		//int t = scan.nextInt();
		int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}

	static class Task {
		static final int inf = Integer.MAX_VALUE;

		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			int n = sc.nextInt();
			int m = sc.nextInt();
			HashMap<Integer, Integer>[] arr = new HashMap[n];
			HashSet<Integer> primes = new HashSet<>();
			for(int i = 0 ; i < n; i++){
				int t = sc.nextInt();
				arr[i] = new HashMap<>();
				int k = 2;
				while(k <= Math.sqrt(t)) {
					int deg = 0;
					while(t % k == 0){
						deg++;
						t /= k;
						primes.add(k);
					}
					if(deg > 0) {
						arr[i].put(k, deg);
					}
					k++;
				}
				if(t > 1) {
					arr[i].put(t, arr[i].getOrDefault(t, 0) + 1);
					primes.add(t);
				}
			}
			int[][] arr2 = new int[m][2];
			for(int i = 0; i < m; i++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				if(a % 2 == 1) {
					int t = a;
					a = b;
					b = t; 
				}
				arr2[i][0] = a;
				arr2[i][1] = b;
			}
			long sum = 0;
			for(int p : primes) {
				List<Edge>[] mf = mflow.createGraph(200);
				for(int i = 0; i < n; i++) {
					int a = arr[i].getOrDefault(p, 0);
					if(i % 2 == 0) {
						mflow.addEdge(mf, n, i, a);
					}
					else {
						mflow.addEdge(mf, i, n+1, a);
					}
				}
				for(int i = 0; i < m; i++){
					mflow.addEdge(mf, arr2[i][0], arr2[i][1], 1000);
				}
				int t = mflow.maxFlow(mf, n, n+1);
				sum += t;
			}
			pw.println(sum);
		}
		static class Edge {
			int s, t, rev, cap, f;
		
			public Edge(int s, int t, int rev, int cap) {
			  this.s = s;
			  this.t = t;
			  this.rev = rev;
			  this.cap = cap;
			}
		}
		static class mflow {
		  public static List<Edge>[] createGraph(int nodes) {
		    List<Edge>[] graph = new List[nodes];
		    for (int i = 0; i < nodes; i++)
		      graph[i] = new ArrayList<>();
		    return graph;
		  }
		
		  public static void addEdge(List<Edge>[] graph, int s, int t, int cap) {
		    graph[s].add(new Edge(s, t, graph[t].size(), cap));
		    graph[t].add(new Edge(t, s, graph[s].size() - 1, 0));
		  }
		
		  public static int maxFlow(List<Edge>[] graph, int s, int t) {
		    int flow = 0;
		    int[] q = new int[graph.length];
		    while (true) {
		      int qt = 0;
		      q[qt++] = s;
		      Edge[] pred = new Edge[graph.length];
		      for (int qh = 0; qh < qt && pred[t] == null; qh++) {
		        int cur = q[qh];
		        for (Edge e : graph[cur]) {
		          if (pred[e.t] == null && e.cap > e.f) {
		            pred[e.t] = e;
		            q[qt++] = e.t;
		          }
		        }
		      }
		      if (pred[t] == null)
		        break;
		      int df = Integer.MAX_VALUE;
		      for (int u = t; u != s; u = pred[u].s)
		        df = Math.min(df, pred[u].cap - pred[u].f);
		      for (int u = t; u != s; u = pred[u].s) {
		        pred[u].f += df;
		        graph[pred[u].t].get(pred[u].rev).f -= df;
		      }
		      flow += df;
		    }
		    return flow;
		  }
 	   }
	}
	static long binpow(long a, long b, long m) {
		a %= m;
		long res = 1;
		while (b > 0) {
			if ((b & 1) == 1)
				res = res * a % m;
			a = a * a % m;
			b >>= 1;
		}
		return res;
	}
	static void sort(int[] x){
		shuffle(x);
		Arrays.sort(x);
	}
	static void sort(long[] x){
		shuffle(x);
		Arrays.sort(x);
	}
	static class tup implements Comparable<tup>{
		int a, b;
		tup(int a,int b){
			this.a=a;
			this.b=b;
		}
		@Override
		public int compareTo(tup o){
			return Integer.compare(o.b,b);
		}
	}
	static void shuffle(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(i + 1);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	static void shuffle(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(i + 1);
			long temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}