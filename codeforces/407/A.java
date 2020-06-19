
// Problem : A. Triangle
// Contest : Codeforces - Codeforces Round #239 (Div. 1)
// URL : https://codeforces.com/problemset/problem/407/A
// Memory Limit : 256 MB
// Time Limit : 1000 ms
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
			int x1=0, y1=0;
			int x2=0, y2=0;
			int k = gcd(n, m);
			if(k == 1) {
				pw.println("NO");
				return;
			}
			l:
			for(int i = 1; i <= 1000; i++) {
				for(int j = 1; j <= 1000; j++) {
					if(i * i + j * j == k * k) {
						x2 = i;
						y2 = j;
						break l;
					}
				}
			}
			if(x2 == 0 || y2 == 0 ) {
				pw.println("NO");
				return;
			}
			
			if(x2 * n == y2 * m) {
				pw.println("YES");
				pw.printf("%d %d%n%d %d%n%d %d%n", x1, y1, x2 * n/k, y2* n/k, -y2 * m/k, x2 * m/k);
				return;
			}
			if(x2 * m == y2 * n) {
				pw.println("YES");
				pw.printf("%d %d%n%d %d%n%d %d%n", x1, y1, y2* n/k, x2 * n/k, x2 * -m/k, y2 * m/k);
				return;
			}
			pw.println("YES");
			pw.printf("%d %d%n%d %d%n%d %d%n", x1, y1, x2 * n/k, y2* n/k, y2 * m/k, x2 * -m/k);
		}
		int gcd(int a, int b) {
			return a == 0 ? b : gcd(b%a, a);
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