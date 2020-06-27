
// Problem : F. Scalar Queries
// Contest : Codeforces - Educational Codeforces Round 65 (Rated for Div. 2)
// URL : https://codeforces.com/contest/1167/problem/F
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
			tup[] arr = new tup[n];
			for(int i = 0; i < n; i++) {
				arr[i] = new tup(sc.nextInt(), i);
			}
			Arrays.sort(arr);
			bit left = new bit(n);
			bit righ = new bit(n);
			long sum = 0;
			for(int i = 0; i < n; i++) {
				sum += 1l * (arr[i].b + 1) * (n - arr[i].b) % 1000000007 * arr[i].a;
				sum %= 1000000007;
				sum += 1l * left.sum(arr[i].b - 1) % 1000000007 * (n - arr[i].b) % 1000000007 * arr[i].a;
				sum %= 1000000007;
				sum += 1l * righ.sum(n - 1, arr[i].b + 1) % 1000000007 * (arr[i].b + 1) % 1000000007 * arr[i].a;
				sum %= 1000000007;
				left.add(arr[i].b, arr[i].b + 1);
				righ.add(arr[i].b, n - arr[i].b);
			}
			pw.println(sum);
		}
		static class bit { 
			int n;
			long[] bit;
			public bit(int n) {
				this.n=n;
				bit=new long[n+1];
			}
			void add(int ind, long c) {
				for(; ind<n;ind|=(ind+1)) {
					bit[ind]+=c;
				}
			}
			long sum(int r) {
				long out =0;
				for(;r>=0;r=(r&(r+1))-1) {
					out+=bit[r];
				}
				return out;
			}
			long sum(int r, int l) {
				return sum(r)-sum(l-1);
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