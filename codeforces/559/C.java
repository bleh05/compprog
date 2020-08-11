
// Problem : C. Gerald and Giant Chess
// Contest : Codeforces - Codeforces Round #313 (Div. 1)
// URL : https://codeforces.com/contest/559/problem/C
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
		long mod = 1000000007;
		long[] fact = new long[200002];
		long[] inv = new long[200002];
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			fact[0] = 1;
			for(int i = 1; i < 200002; i++) {
				fact[i] = fact[i-1] * i;
				fact[i] %= mod;
			}
			for(int i = 0; i < 200002; i++) {
				inv[i] = binpow(fact[i], mod - 2, mod);
			}
			tup[] arr = new tup[k+1];
			for(int i = 0; i < k; i++) {
				arr[i] = new tup(sc.nextInt(), sc.nextInt());
			}
			arr[k] = new tup(n, m);
			Arrays.sort(arr);
			long[] d = new long[k+1];
			for(int i = 0; i < k+1; i++) {
				d[i] = choose(arr[i].a + arr[i].b - 2, arr[i].a - 1);
				for(int j = 0; j < i; j++) {
					if(arr[j].a <= arr[i].a && arr[j].b <= arr[i].b) {
						d[i] -= d[j] * choose(arr[i].b+arr[i].a-arr[j].b-arr[j].a, arr[i].a-arr[j].a);
						d[i] %= mod;
						if(d[i] < 0) d[i] += mod;
					}
				}
			}
			pw.println(d[k]);
		}
		public long choose(int n, int m) {
			return fact[n] * inv[m] % mod * inv[n-m] % mod;
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
			return a != o.a ? Integer.compare(a, o.a) : Integer.compare(b,o.b);
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