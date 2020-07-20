
// Problem : E. Sum Queries?
// Contest : Codeforces - Educational Codeforces Round 72 (Rated for Div. 2)
// URL : https://codeforces.com/contest/1217/problem/E
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

		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			segt s = new segt(n);
			s.build(1, 0, n - 1, arr);
			for(int i = 0; i < m; i++) {
				int typ = sc.nextInt();
				if(typ == 1) {
					s.update(1, 0, n - 1, sc.nextInt() - 1, sc.nextInt());
				}
				else {
					long c = s.min(1, 0, n - 1, sc.nextInt() - 1, sc.nextInt() - 1).best;
					pw.println(c > 2e9 ? -1 : c);
				}
			}
		}
		class node {
			int[] bestbyd; long best;
			public node(int c) {
				bestbyd = new int[10];
				best = inf * 200l;
				int ptr = 0;
				int k = c;
				while(ptr < 10) {
					if(c % 10 > 0) {
						bestbyd[ptr] = k;
					}
					else{
						bestbyd[ptr] = inf/2;
					}
					ptr++;
					c /= 10;
				}
			}
			public node(node l, node r){
				bestbyd = new int[10];
				best = Math.min(l.best, r.best);
				for(int i = 0; i < 10; i++) {
					bestbyd[i] = Math.min(l.bestbyd[i], r.bestbyd[i]);
					if(l.bestbyd[i] != inf/2 && r.bestbyd[i] != inf/2) {
						best = Math.min(l.bestbyd[i] + r.bestbyd[i], best);
					}
				}
			}
		}
		class segt {
			node[] t;
			public segt(int n) {
				t = new node[4 * n];
			}
			void build(int v, int tl, int tr, int[] x) {
				if(tl == tr) {
					t[v] = new node(x[tl]);
				}
				else{
					int tm = (tl + tr) >> 1;
					build(v * 2, tl, tm, x);
					build(v * 2 + 1, tm + 1, tr, x);
					t[v] = new node(t[v * 2], t[v * 2 + 1]);
				}
			}
			node min(int v, int tl, int tr, int l, int r) {
				if(tl > tr || l > tr || r < tl) {
					return new node(inf / 2);
				}
				if(l <= tl && r >= tr) {
					return t[v];
				}
				else{
					int tm = (tl + tr) >> 1;
					node lres = min(v * 2, tl, tm, l, r);
					node rres = min(v * 2 + 1, tm + 1, tr, l, r);
					return new node(lres, rres);
				}
			}
			void update(int v, int tl, int tr, int ind, int val) {
				if(tl == tr && tl == ind) {
					t[v] = new node(val);
				}
				else if(ind < tl || ind > tr){
					return;
				}
				else{
					int tm = (tl + tr) >> 1;
					update(v * 2, tl, tm, ind, val);
					update(v * 2 + 1, tm + 1, tr, ind, val);
					t[v] = new node(t[v * 2], t[v * 2 + 1]);
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