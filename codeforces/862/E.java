
// Problem : E. Mahmoud and Ehab and the function
// Contest : Codeforces - Codeforces Round #435 (Div. 2)
// URL : https://codeforces.com/contest/862/problem/E
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
			int q = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[m];
			long sum = 0;
			long sum2 = 0;
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				sum += -1l * (i % 2 * 2 - 1) * a[i];
			}
			for(int i = 0; i < m; i++) {
				b[i] = sc.nextInt();
				if(i < n)
				sum2 += -1l * ((i + 1) % 2 * 2 - 1) * b[i];
			}
			long[] c = new long[m - n + 1];
			c[0] = sum2;
			for(int i = 0; i + n < m; i++) {
				sum2 *= -1;
				sum2 -= b[i];
				sum2 += -1l * (n % 2 * 2 - 1) * b[i+n];
				c[i+1] = sum2; 
			}
			sort(c);
			int zz = Arrays.binarySearch(c, -sum);
			if(zz >= 0) {
				pw.println(0);
			}
			else {
				long max = Long.MAX_VALUE;
				for(int j = Math.max(0, -zz - 3); j < Math.min(c.length, -zz + 4); j++) {
					max = Math.min(Math.abs(c[j] + sum), max);
				}
				pw.println(max);
			}
			for(int i = 0; i < q; i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				int k = sc.nextInt();
				int oddn = (r - l) / 2;
				if(l % 2 == 1 || r % 2 == 1) {
					oddn++;
				}
				int evn = (r - l + 1) - oddn;
				sum += (oddn - evn + 0l) * k;
				zz = Arrays.binarySearch(c, -sum);
				if(zz >= 0) {
					pw.println(0);
				}
				else {
					long max = Long.MAX_VALUE;
					for(int j = Math.max(0, -zz - 3); j < Math.min(c.length, -zz + 4); j++) {
						max = Math.min(Math.abs(c[j] + sum), max);
					}
					pw.println(max);
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