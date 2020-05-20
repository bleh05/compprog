
// Problem : C. Greg and Friends
// Contest : Codeforces - Codeforces Round #179 (Div. 1)
// URL : https://codeforces.com/contest/295/problem/C
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
			int we = sc.nextInt() / 50;
			int[] ppl = new int[n];
			int a = 0;	
			int b = 0;
			int mod = 1000000007;
			for(int i = 0; i < n; i++) {
				ppl[i] = sc.nextInt() / 50;
				a += ppl[i] & 1;
				b += ppl[i] / 2;
			}
			long[][] choose = new long[52][52];
			for(int i = 1; i <= 50; i++) {
				for(int j = 0; j <= i; j++) {
					choose[i][j] = choose_mod_one(i, j, mod);
				}
			}
			long[][][] dp = new long[200][52][52]; 
			dp[0][0][0] = 1;
			choose[0][0] = 1;
			for(int i = 1; i < 200; i ++) {
				for(int j = 0; j <= a; j++) {
					for(int k = 0; k <= b; k++) {
						if((i & 1) == 1) {
							for(int l = 0; l <= j; l++) {
								for(int m = 0; m <= k; m++) {
									if(l == j && m == k) continue;
									int num1s = j - l;
									int num2s = k - m;
									int left1s = a - l;
									int left2s = b - m;
									if(num1s * 1 + num2s * 2 > we) continue;
									dp[i][j][k] += dp[i - 1][l][m] * choose[left1s][num1s] % mod * 
										choose[left2s][num2s] % mod;
									dp[i][j][k] %= mod;
								}
							}
						}
						else {
							for(int l = j; l <= a; l++) {
								for(int m = k; m <= b; m++) {
									if(l == j && m == k) continue;
									int num1s = l - j;
									int num2s = m - k;
									int left1s = l;
									int left2s = m;
									if(num1s * 1 + num2s * 2 > we) continue;
									dp[i][j][k] += dp[i - 1][l][m] * choose[left1s][num1s] % mod * 
										choose[left2s][num2s] % mod;
									dp[i][j][k] %= mod;
								}
							}
						}
					}
				}
				if(dp[i][a][b] > 0) break;
			}
			for(int i = 0; i < 200; i++) {
				if(dp[i][a][b] > 0) {
					pw.println(i);
					pw.println(dp[i][a][b]);
					return;
				}
			}
			pw.println(-1);
			pw.println(0);
		}
		long choose_mod_one(long n, long k, long p)
		{
		    // For small k, no recursion is necessary
		    if (k < p) return choose_mod_two(n,k,p);
		    long q_n, r_n, q_k, r_k, choose;
		    q_n = n / p;
		    r_n = n % p;
		    q_k = k / p;
		    r_k = k % p;
		    choose = choose_mod_two(r_n, r_k, p);
		    choose *= choose_mod_one(q_n, q_k, p);
		    return choose % p;
		}
		
		// Preconditions: 0 <= k <= min(n,p-1); p > 1 prime
		long choose_mod_two(long n, long k, long p)
		{
		    n %= p;
		    if (n < k) return 0;
		    if (k == 0 || k == n) return 1;
		    if (k > n/2) k = n-k;
		    long num = n, den = 1;
		    for(n = n-1; k > 1; --n, --k)
		    {
		        num = (num * n) % p;
		        den = (den * k) % p;
		    }
		    den = invert_mod(den,p);
		    return (num * den) % p;
		}
		long invert_mod(long k, long m)
		{
		    if (m == 0) return (k == 1 || k == -1) ? k : 0;
		    if (m < 0) m = -m;
		    k %= m;
		    if (k < 0) k += m;
		    boolean neg = true;
		    long p1 = 1, p2 = 0, k1 = k, m1 = m, q, r, temp;
		    while(k1 > 0) {
		        q = m1 / k1;
		        r = m1 % k1;
		        temp = q*p1 + p2;
		        p2 = p1;
		        p1 = temp;
		        m1 = k1;
		        k1 = r;
		        neg = !neg;
		    }
		    return neg ? m - p2 : p2;
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