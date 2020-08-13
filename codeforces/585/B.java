
// Problem : B. Phillip and Trains
// Contest : Codeforces - Codeforces Round #325 (Div. 1)
// URL : https://codeforces.com/problemset/problem/585/B
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
		int t = scan.nextInt();
		//int t = 1;
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
			int[][] grid = new int[3][n];
			int z = 0;
			for(int i = 0; i < 3; i++) {
				String str = sc.nextLine();
				for(int j = 0; j < n; j++) {
					grid[i][j] = str.charAt(j) == '.' ? 1 : 0;
					if(str.charAt(j) == 's') {
						grid[i][j] = 1;
						z = i;
					}
				}
			}
			int[][] dp = new int[3][n];
			dp[z][0] = 1;
			for(int j = 0; j < n - 3; j++) {
				for(int i = 0; i < 3; i++) {
					if(i - 1 >= 0) {
						if(dp[i][j] == 1 && grid[i][j+1] == 1 && grid[i-1][j+1] == 1 && grid[i-1][j+2] == 1 && grid[i-1][j+3] == 1) {
							dp[i-1][j+3] = 1;
						}
					}
					if(dp[i][j] == 1 && grid[i][j+1] == 1 && grid[i][j+2] == 1 && grid[i][j+3] == 1) {
						dp[i][j+3] = 1;
					}
					if(i + 1 <= 2) {
						if(dp[i][j] == 1 && grid[i][j+1] == 1 && grid[i+1][j+1] == 1 && grid[i+1][j+2] == 1 && grid[i+1][j+3] == 1) {
							dp[i+1][j+3] = 1;
						}
					}
				}
			}
			//pw.println(Arrays.toString(dp[0]));
			//pw.println(Arrays.toString(dp[1]));
			//pw.println(Arrays.toString(dp[2]));
			for(int i = 0; i < 3; i++) {
				for(int j = 1; j < n; j++) {
					if(dp[i][j-1] == 1 && grid[i][j] == 1) dp[i][j] = 1;
				}
			}
			pw.println(dp[0][n-1] + dp[1][n-1] + dp[2][n-1] > 0 ? "YES" : "NO");
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