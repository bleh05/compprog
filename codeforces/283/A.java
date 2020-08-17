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
			long sum = 0;
			int num = 1;
			segt s = new segt(300000);
			for(int i = 0; i < n; i++) {
				int c = sc.nextInt();
				if(c == 1) {
					int zz = sc.nextInt();
					long cd = sc.nextLong();
					s.update(1, 0, 300000, 0, zz, cd);
					sum += zz * cd;
				}
				else if(c == 2) {
					int k = sc.nextInt();
					num++;
					s.update(1, 0, 300000, num, num, k);
					sum += k;
				}
				else {
					long k;
					sum -= k = s.max(1, 0, 300000, num, num);
					s.update(1, 0, 300000, num, num, -k);
					num--;
				}
				pw.println((1.0 * sum) / (1.0 * num));
			}
		}
		class segt {
			long[] tree;
			long[] lazy;
			segt(int n) {
				tree = new long[4*n];
				lazy = new long[4*n];
			}
			long max(int v, int rl, int rr, int l, int r) {
				if(rr - rl < 0 || rl > r || rr < l) {
					return Integer.MIN_VALUE;
				}
				if(rl >= l && rr <= r) {
					return tree[v];
				}
				push(v);
				int rm = (rl + rr) / 2;
				return Math.max(max(v*2, rl, rm, l, r), max(v*2+1, rm+1, rr, l, r));
			}
			void update(int v, int rl, int rr, int l, int r, long val) {
				if(rr - rl < 0 || rl > r || rr < l) {
					return;
				}
				if(rl >= l && rr <= r) {
					lazy[v] += val;
					tree[v] += val;
					return;
				}
				push(v);
				int rm = (rl + rr) / 2;
				update(v*2, rl, rm, l, r, val); 
				update(v*2+1, rm+1, rr, l, r, val);
			}
	        void push(int v) {
	            tree[v*2] += lazy[v];
	            lazy[v*2] += lazy[v];
	            tree[v*2+1] += lazy[v];
	            lazy[v*2+1] += lazy[v];
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