
// Problem : Q - Flowers
// Contest : Educational DP Contest
// URL : https://atcoder.jp/contests/dp/tasks/dp_q
// Memory Limit : 1024 MB
// Time Limit : 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		FastReader scan = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		//int t = scan.nextInt();
		int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}

	static class Task {

		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			int n = sc.nextInt();
			int[][] x = new int[2][n];
			for(int i=0;i<n;i++){
				x[0][i]=sc.nextInt();
			}
			for(int i=0;i<n;i++){
				x[1][i]=sc.nextInt();
			}
			long max = 0;
			segt s = new segt(200004);
			for(int i=0;i<n;i++){
				long ss = s.get_max(1,0,200003,0,x[0][i])+x[1][i];
				max=Math.max(ss,max);
				s.update(1,0,200003,x[0][i],ss);
			}
			pw.println(max);
		}
	}
	
	static class segt {
		long[] t;
		public segt(int n) {
			t = new long[4*n];
		}
		void build(int a[], int v, int tl, int tr) {
			if (tl == tr) {
				t[v] = a[tl];
			} else {
				int tm = (tl + tr) / 2;
				build(a, v*2, tl, tm);
				build(a, v*2+1, tm+1, tr);
				t[v] = Math.max(t[v*2], t[v*2+1]);
			}
		}
		long get_max(int v, int tl, int tr, int l, int r) {
			if (l > r)
				return Integer.MIN_VALUE;
			if (l == tl && r == tr)
				return t[v];
			int tm = (tl + tr) / 2;
			return Math.max(get_max(v*2, tl, tm, l, Math.min(r, tm)),
					get_max(v*2+1, tm+1, tr, Math.max(l, tm+1), r));
		}
			void update(int v, int tl, int tr, int pos, long new_val) {
			if (tl == tr) {
				t[v] = new_val;
			} else {
				int tm = (tl + tr) / 2;
				if (pos <= tm)
					update(v*2, tl, tm, pos, new_val);
				else
					update(v*2+1, tm+1, tr, pos, new_val);
				t[v] = Math.max(t[v*2], t[v*2+1]);
			}
		}
	}
	static void shuffle(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	static void shuffle(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
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