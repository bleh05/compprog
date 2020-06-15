
// Problem : C. Case of Chocolate
// Contest : Codeforces - Codeforces Round #310 (Div. 1)
// URL : https://codeforces.com/contest/555/problem/C
// Memory Limit : 256 MB
// Time Limit : 3000 ms
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

		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			int n = sc.nextInt();
			int m = sc.nextInt();
			TreeSet<Integer> hs = new TreeSet<Integer>();
			int[][] queries = new int[m][3];
			for(int i = 0; i < m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int dir = sc.next().equals("U") ? 1 : 0;
				queries[i][0] = x;
				queries[i][1] = y;
				queries[i][2] = dir;
				hs.add(x);
				hs.add(y);
			}
			HashMap<Integer, Integer> compress = new HashMap<>();
			int[] compres = new int[hs.size()+1];
			int c = 1;
			for(int x : hs) {
				compress.put(x, c);
				compres[c++] = x;
			}
			segt cols = new segt(hs.size());
			segt rows = new segt(hs.size());
			for(int i = 0; i < m; i++) {
				int x = compress.get(queries[i][0]);
				int y = compress.get(queries[i][1]);
				int dir = queries[i][2];
				if(dir == 1) {
					int stop = cols.max(1, 0, hs.size(), x, x);
					pw.println(compres[y] - compres[stop]);
					rows.update(1, 0, hs.size(), stop, y, x);
					cols.update(1, 0, hs.size(), x, x, y);
				}
				else {
					int stop = rows.max(1, 0, hs.size(), y, y);
					pw.println(compres[x] - compres[stop]);
					cols.update(1, 0, hs.size(), stop, x, y);
					rows.update(1, 0, hs.size(), y, y, x);
				}
			}
		}
		class segt {
			int[] tree;
			int[] lazy;
			segt(int n) {
				tree = new int[4*n];
				lazy = new int[4*n];
			}
			int max(int v, int tl, int tr, int l, int r) {
				if(tr - tl < 0 || tr < l || tl > r) {
					return Integer.MIN_VALUE;
				}
				if(tl >= l && tr <= r) {
					return tree[v];
				}
				if(tl == tr) {
					return Integer.MIN_VALUE;
				}
				push(v);
				int tm = (tl + tr) / 2;
				return Math.max(max(v*2, tl, tm, l, r), max(v*2+1, tm+1, tr, l, r));
			}
			void update(int v, int tl, int tr, int l, int r, int val) {
				if(tr - tl < 0 || tr < l || tl > r) {
					return;
				}
				if(tl >= l && tr <= r) {
					lazy[v] = Math.max(val, lazy[v]);
					tree[v] = Math.max(val, tree[v]);
					return;
				}
				int tm = (tl + tr) / 2;
				update(v*2, tl, tm, l, r, val); 
				update(v*2+1, tm+1, tr, l, r, val);
			}
	        void push(int v) {
	            tree[v*2] = Math.max(tree[v*2], lazy[v]);
	            lazy[v*2] = Math.max(tree[v*2], lazy[v]);
	            tree[v*2+1] = Math.max(tree[v*2+1], lazy[v]);
	            lazy[v*2+1] = Math.max(tree[v*2+1], lazy[v]);
	            lazy[v] = 0;
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