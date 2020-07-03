
// Problem : E. Hyakugoku and Ladders
// Contest : Codeforces - Codeforces Round #597 (Div. 2)
// URL : https://codeforces.com/contest/1245/problem/E
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
			int[][] grid = new int[10][10];
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			int y = 9;
			int x = 0;
			int count  = 0;
			int[][] compress = new int[10][10];
			while(true) {
				compress[y][x] = count++;
				if(y % 2 == 1) {
					if(x == 9) {
						y--;
					}
					else x++;
				}
				else{
					if(x == 0) y--;
					else x--;
				}
				if(x <= 0 && y < 0) break;
			}
			int[] f = new int[100];
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					f[compress[i][j]] = compress[i - grid[i][j]][j];
				}
			}
			double[] dp = new double[100];
			for(int i = 98; i >= 94; i--) {
				dp[i] = 1;
				for(int j = 1; j + i <= 99; j++) {
					dp[i] += dp[i + j] / 6.0;
				}
				dp[i] *= 6.0 / (99 - i);
			}
			for(int i = 93; i >= 0; i--) {
				dp[i] = 1;
				for(int j = 1; j <= 6; j++) {
					dp[i] += Math.min(dp[f[i + j]], dp[i + j]) / 6.0; 
				}
			}
			pw.println(dp[0]);
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