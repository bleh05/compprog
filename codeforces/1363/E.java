
// Problem : E. Tree Shuffling
// Contest : Codeforces - Codeforces Round #646 (Div. 2)
// URL : https://codeforces.com/contest/1363/problem/E
// Memory Limit : 256 MB
// Time Limit : 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

import java.io.*;
import java.util.*;
import java.util.stream.*;

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
		ArrayList<ArrayList<Integer>> adjl2;
		tup[] arr;
		int lcca[];
		long[][] dp;
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			int n = sc.nextInt();
			// colors, 0, good, 1, 1 0, 2, 0 1
			arr = new tup[n];
			lcca = new int[n];
			boolean ccc = false;
			int k =0;
			for(int i = 0; i < n; i++) {
				int cost = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c;
				if(a == 0 && b == 1) c = 2;
				else if(a == 1 && b == 0) c = 1;
				else c = 0;
				if(c == 1) {
					k++;
				}
				else if(c==2){
					k--;
				}
				arr[i] = new tup(cost, c);
			}
			if(k != 0) {
				pw.println(-1);return;
			}
			dp = new long[2][n];
			HashSet<Integer>[] adjl = Stream.generate(HashSet::new).limit(n).toArray(HashSet[]::new);
			adjl2 = new ArrayList<>();
			for(int i = 0; i < n; i ++){ 
				adjl2.add(new ArrayList<Integer>());
			}
			for(int i = 1; i < n; i ++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				adjl[a].add(b);
				adjl[b].add(a);
				adjl2.get(a).add(b);
				adjl2.get(b).add(a);
			}
			ArrayDeque<Integer> q = new ArrayDeque<>();
			
			for(int i = 1; i < n; i++) {
				if(adjl[i].size() == 1) {
					q.add(i);
				} 
			}
			dfs(0, inf, 0, -1);
			while(!q.isEmpty()) {
				int t = q.poll();
				if(arr[t].b == 1){
					dp[0][t] ++;
				}
				if(arr[t].b == 2) {
					dp[1][t] ++;
				}
				if(arr[lcca[t]].a < arr[t].a){
					dp[0][lcca[t]] += dp[0][t];
					dp[1][lcca[t]] += dp[1][t];
					dp[0][t]=0;
					dp[1][t]=0;
				}
				for(int x : adjl[t]) {
					adjl[x].remove(t);
					if(x != 0 && adjl[x].size() == 1){
						q.add(x);
					}
				}
			}
			if(arr[0].b == 1){
				dp[0][0] ++;
			}
			if(arr[0].b == 2) {
				dp[1][0] ++;
			}
			pw.println(dfs2(0,-1));
		}
		void dfs(int a, int min, int p, int t) {
			lcca[a] = t;
			if(arr[a].a < min) {
				min = arr[a].a;
				t = a;
			}
			for(int x : adjl2.get(a)) {
				if(x != p) {
					dfs(x, min, a, t);
				}
			}
		}
		long dfs2(int a, int p) {
			long x = 0;
			for(int k : adjl2.get(a)) {
				if(k != p)
				x += dfs2(k, a);
			}
			
			if(a != 0) {
				dp[0][lcca[a]] += dp[0][a] - Math.min(dp[0][a],dp[1][a]);
				dp[1][lcca[a]] += dp[1][a] - Math.min(dp[0][a],dp[1][a]);
			}
			x += 2l * Math.min(dp[0][a], dp[1][a]) * arr[a].a;
			return x;
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
			return Integer.compare(a,o.a);
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