
// Problem : D. Makoto and a Blackboard
// Contest : Codeforces - Hello 2019
// URL : https://codeforces.com/contest/1097/problem/D
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
			HashMap<Long, Integer> pfac = new HashMap<>();
			long n = sc.nextLong();
			int kr = sc.nextInt();
			for(long i = 2; 1l * i * i <= n; i++) {
				while(n % i == 0) {
					pfac.put(i, pfac.getOrDefault(i, 0) + 1);
					n /= i;
				}
			}
			if(n > 1) {
				pfac.put(n, pfac.getOrDefault(n, 0) + 1);
			}
			long mod = 1000000007;
			long ans = 1;
			for(long x : pfac.keySet()) {
				int power = pfac.get(x);
				long dp[][] = new long[kr+1][power+1];
				dp[0][power] = 1;
				for(int i = 1; i <= kr; i++) {
					for(int j = 0; j <= power; j++) {
						long inv = binpow(j + 1, mod - 2, mod);
						dp[i][j] = dp[i][j] + inv * dp[i - 1][j] % mod;
						dp[i][j] %= mod;
					}
					for(int j = power - 1; j >= 0; j--) {
						dp[i][j] += dp[i][j + 1];
						dp[i][j] %= mod;
					}
				}
				long val = 1;
				long suba = 0;
				for(int j = 0; j <= power; j++) {
					suba += val * dp[kr][j] % mod;
					suba %= mod;
					val *= x;
					val %= mod;
				}
				ans *= suba;
				ans %= mod;
			}
			pw.println(ans);
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