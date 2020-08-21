
// Problem : D. Maximum Distributed Tree
// Contest : Codeforces - Codeforces Round #665 (Div. 2)
// URL : https://codeforces.com/contest/1401/problem/D
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
		int t = scan.nextInt();
		//int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}

	static class Task {
		static final int inf = Integer.MAX_VALUE;
		List<Integer>[] adjl;
		HashMap<Long, Integer> stf;
		long[] weights;
		int[] subsz;
		int n;
		long mod = 1_000_000_007;
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			n = sc.nextInt();
			adjl = Stream.generate(ArrayList::new).limit(n).toArray(List[]::new);
			stf = new HashMap<Long, Integer>();
			weights = new long[n-1];
			subsz = new int[n];
			for(int i = 0; i < n - 1; i++) {
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				adjl[a].add(b);
				adjl[b].add(a);
				stf.put(a * 100005l + b, i);
				stf.put(b * 100005l + a, i);
			}
			dfs(0, 0);
			dfs2(0, 0);
			sort(weights);
			int c = sc.nextInt();
			long[] pms = new long[Math.max(c, n - 1)];
			Arrays.fill(pms, 1);
			for(int i = 0; i < c; i++) {
				pms[i] = sc.nextLong();
			}
			Arrays.sort(pms);
			for(int i = c - 1; i >= n - 1; i--) {
//				System.out.println(n - 1);
				pms[i-1] = pms[i] * pms[i-1] % mod;
				pms[i] = 0;
			}
			long sum = 0;
			for(int i = n - 2; i >= 0; i--) {
				sum += pms[i] * (weights[i] % mod) % mod;
				sum %= mod;
			}
			//pw.println(Arrays.toString(weights));
			//pw.println(Arrays.toString(pms));
			pw.println(sum);
		}
		int dfs(int v, int p) {
			for(int x : adjl[v]) {
				if(x != p) {
					subsz[v] += dfs(x, v);
				}
			}
			subsz[v]++;
			return subsz[v];
		}
		void dfs2(int v, int p) {
			for(int x : adjl[v]) {
				if(x != p) {
					weights[stf.get(x * 100005l + v)] = subsz[x] * 1l * (n - subsz[x]);
					dfs2(x, v);
				}
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