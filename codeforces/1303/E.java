
// Problem : E. Erase Subsequences
// Contest : Codeforces - Educational Codeforces Round 82 (Rated for Div. 2)
// URL : https://codeforces.com/contest/1303/problem/E
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
			String str = sc.nextLine();
			int n = str.length();
			String str2 =sc.nextLine();
			int m = str2.length();
			int[][] nxt = new int[n+1][26];
			for(int[] arr : nxt) {
				Arrays.fill(arr, inf-1);
			}
			for(int i = n-1; i >= 0; i--) {
				nxt[i][str.charAt(i) - 'a'] = i;
					for(int j = 0; j < 26; j++) {
						nxt[i][j] = Math.min(nxt[i][j], nxt[i+1][j]);
					}
			}
			for(int i = 0; i < m; i++) {
				int[][] dp = new int[i+1][m - i+1];
				for(int[] x : dp) {
					Arrays.fill(x, inf);
				}
				dp[0][0] = 0;
				for(int j = 0; j <= i; j++) {
					for(int k = 0; k <= m - i; k++) {
						if(k > 0) {
							if(dp[j][k-1] < inf)
							dp[j][k] = Math.min(dp[j][k], nxt[dp[j][k-1]][str2.charAt(i + k-1) - 'a']+1);
						}
						if(j > 0) {
							if(dp[j-1][k] < inf)
							dp[j][k] = Math.min(dp[j][k], nxt[dp[j-1][k]][str2.charAt(j-1) - 'a']+1);
						}
					}
				}
				if(dp[i][m-i] < inf/2) {
					pw.println("YES");
					return;
				}
			}
			pw.println("NO");
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