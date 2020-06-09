
// Problem : E. Minimal Segment Cover
// Contest : Codeforces - Educational Codeforces Round 66 (Rated for Div. 2)
// URL : https://codeforces.com/contest/1175/problem/E
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
			int q = sc.nextInt();
			int[][] dp = new int[500001][20];
			for(int i = 0; i < 500001; i++) {
				dp[i][0] = -1;
			}
			for(int i = 0; i < n; i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				dp[l][0] = Math.max(r, dp[l][0]);
			}
			for(int i = 1; i < 500001; i++) {
				if(dp[i-1][0] >= i) {
					dp[i][0] = Math.max(dp[i][0], dp[i-1][0]);
				}
			}
			for(int i = 500000; i >= 0; i--) {
				if(dp[i][0] != -1) {
					for(int j = 1; j < 20; j ++) {
						dp[i][j] = dp[dp[i][j-1]][j-1];
					}
				}
			}
			for(int i = 0; i < q; i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				if(dp[l][0] == -1 || dp[l][19] < r) {
					pw.println(-1);
					continue;
				}
				int ans = 0;
				for(int j = 19; j >= 0; j--) {
					if(dp[l][j] < r) {
						ans += 1 << j;
						l = dp[l][j];
					}
				}
				ans++;
				pw.println(ans);
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