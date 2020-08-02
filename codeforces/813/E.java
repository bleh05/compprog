
// Problem : E. Army Creation
// Contest : Codeforces - Educational Codeforces Round 22
// URL : https://codeforces.com/contest/813/problem/E
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
			TreeSet<Integer>[] tss = Stream.generate(TreeSet::new).limit(100002).toArray(TreeSet[]::new);
			int[] b = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				tss[arr[i]].add(i);
				if(tss[arr[i]].size() > m) {
					int c = tss[arr[i]].higher(-1);
					b[i] = c;
					tss[arr[i]].remove(c);
				}
				else{
					b[i] = -1;
				}
			}
			segt s = new segt(n);
			s.build(1, 0, n - 1, b);
			int q = sc.nextInt();
			int last = 0;
			for(int i = 0; i < q; i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				l += last;
				r += last;
				l %= n;
				r %= n;
				l++;
				r++;
				int c = Math.min(l, r) - 1;
				int d = Math.max(l, r) - 1;
				last = s.get(1, 0, n - 1, c, d);
				//pw.println(c + " " + d);
				pw.println(last);
			}
		}
	}
	static class segt {
		int[][] tree;
		int n;
		segt(int n) {
			this.n = n;
			this.tree = new int[4 * n][];
		}
		public void build(int v, int tl, int tr, int[] arr) {
			if(tl == tr) {
				tree[v] = new int[]{arr[tl]};
			}
			else {
				int tm = (tl + tr) >> 1;
				build(v * 2, tl, tm, arr);
				build(v * 2 + 1, tm + 1, tr, arr);
				int ptr1 = 0;
				int ptr2 = 0;
				tree[v] = new int[tr - tl + 1];
				while(ptr1 < (tm - tl + 1) || ptr2 < (tr - tm)) {
					if(ptr1 < (tm - tl + 1) && (ptr2 >= tr - tm || tree[v * 2][ptr1] < tree[v * 2 + 1][ptr2])) {
						tree[v][ptr1 + ptr2] = tree[v * 2][ptr1++];
					}
					else {
						tree[v][ptr1 + ptr2] = tree[v * 2 + 1][ptr2++];
					}
				}
			}
		}
		public int get(int v, int tl, int tr, int l, int r) {
			if(l <= tl && r >= tr) {
				int bl = 0; int br = (tr - tl);
				while(br - bl > 1) {
					int mid = (bl + br) >> 1;
					if(tree[v][mid] < l) {
						bl = mid;
					}
					else {
						br = mid - 1;
					}
				}
				if(tree[v][br] < l) return br + 1;
				else if(tree[v][bl] < l) return bl + 1;
				else return 0;
			}
			else if(tl > r || l > tr) return 0;
			else {
				int tm = (tl + tr) >> 1;
				return get(v * 2, tl, tm, l, r) + get(v * 2 + 1, tm + 1, tr, l, r);
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