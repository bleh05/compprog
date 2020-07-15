
// Problem : F. Restoring the Expression
// Contest : Codeforces - Codeforces Round #451 (Div. 2)
// URL : https://codeforces.com/contest/898/problem/F
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
			String str = sc.nextLine();
			int l3 = 1;
			CharHash ch = new CharHash(str.toCharArray(), 10, 1000000007);
			CharHash ch2 = new CharHash(str.toCharArray(), 10, 1000000009);
			int n = str.length();
			for(; l3 * 2 <= n; l3++) {
				int l1 = l3;
				int l2 = n - l1 - l3;
				if(l2 <= l3 && l1 > 0 && l1 + l2 < n && (ch.hash(0, l1 - 1) +
				 ch.hash(l1, l1 + l2 - 1)) % 1000000007 == 
				 ch.hash(l1 + l2, n - 1) && (ch2.hash(0, l1 - 1) +
				 ch2.hash(l1, l1 + l2 - 1)) % 1000000009 == 
				 ch2.hash(l1 + l2, n - 1)) {
				 	if((l1 == 1 || str.charAt(0) > '0') && (l2 == 1 || str.charAt(l1) > '0') && (l3 == 1 || str.charAt(l1 + l2) > '0')) {
						pw.println(str.substring(0, l1) + "+" + str.substring(l1, l1 + l2) + "=" + str.substring(l1 + l2, n));
						return;
					}
				}
				l1 = l3 - 1;
				l2 = n - l1 - l3;
				if(l2 <= l3 && l1 > 0 && l1 + l2 < n && (ch.hash(0, l1 - 1) +
				 ch.hash(l1, l1 + l2 - 1)) % 1000000007 == 
				 ch.hash(l1 + l2, n - 1) && (ch2.hash(0, l1 - 1) +
				 ch2.hash(l1, l1 + l2 - 1)) % 1000000009 == 
				 ch2.hash(l1 + l2, n - 1)) {
				 	if((l1 == 1 || str.charAt(0) > '0') && (l2 == 1 || str.charAt(l1) > '0') && (l3 == 1 || str.charAt(l1 + l2) > '0')) {
						pw.println(str.substring(0, l1) + "+" + str.substring(l1, l1 + l2) + "=" + str.substring(l1 + l2, n));
						return;
					}
				}
				l2 = l3;
				l1 = n - l2 - l3;
				if(l1 <= l3 && l1 > 0 && l1 + l2 < n && (ch.hash(0, l1 - 1) + 
				ch.hash(l1, l1 + l2 - 1)) % 1000000007 == 
				ch.hash(l1 + l2, n - 1) && (ch2.hash(0, l1 - 1) +
				 ch2.hash(l1, l1 + l2 - 1)) % 1000000009 == 
				 ch2.hash(l1 + l2, n - 1)) {
				 	if((l1 == 1 || str.charAt(0) > '0') && (l2 == 1 || str.charAt(l1) > '0') && (l3 == 1 || str.charAt(l1 + l2) > '0')) {
						pw.println(str.substring(0, l1) + "+" + str.substring(l1, l1 + l2) + "=" + str.substring(l1 + l2, n));
						return;
					}
				}
				l2 = l3 - 1;
				l1 = n - l2 - l3;
				if(l1 <= l3 && l1 > 0 && l1 + l2 < n && (ch.hash(0, l1 - 1) + 
				ch.hash(l1, l1 + l2 - 1)) % 1000000007 == 
				ch.hash(l1 + l2, n - 1) && (ch2.hash(0, l1 - 1) +
				 ch2.hash(l1, l1 + l2 - 1)) % 1000000009 == 
				 ch2.hash(l1 + l2, n - 1)) {
				 	if((l1 == 1 || str.charAt(0) > '0') && (l2 == 1 || str.charAt(l1) > '0') && (l3 == 1 || str.charAt(l1 + l2) > '0')) {
						pw.println(str.substring(0, l1) + "+" + str.substring(l1, l1 + l2) + "=" + str.substring(l1 + l2, n));
						return;
					}
				}
			}
		}
		static class CharHash {
	        private long MOD;
	        private long[] inverse;
	        private long[] hash;
	        private	int n;
	        private int x;
	 
	        public CharHash(char[] data, int x, long mod) {
	        	MOD = mod;
	            n = data.length;
	            inverse = new long[n];
	            this.x = x;
	            inverse[0] = 1;
	            long inv = pow(x, MOD - 2);
	            for (int i = 1; i < n; i++) {
	                this.inverse[i] = (int) (this.inverse[i - 1] * inv % MOD);
	            }
	 
	            hash = new long[n];
	            hash[n - 1] = data[n - 1] - '0';
	            long baseInc = 1;
	            for (int i = n - 2; i >= 0; i--) {
	                baseInc = baseInc * x % MOD;
	
	                int dataval = data[i] - '0';
	
	                hash[i] = (hash[i + 1] + dataval * baseInc) % MOD;
	            }
	        }
	 
	        public long pow(long x, long n) {
	            int bit = 63 - Long.numberOfLeadingZeros(n);
	            long product = 1;
	            for (; bit >= 0; bit--) {
	                product = product * product % MOD;
	                if (((1 << bit) & n) != 0) {
	                    product = product * x % MOD;
	                }
	            }
	            return product;
	        }
	 
	        public long hash(int l, int r) {
	            long hash = this.hash[l];
	            if (r < n - 1) {
	                hash = hash - this.hash[r + 1];
	                if (hash < 0) {
	                    hash += MOD;
	                }
	                hash = hash * inverse[n - 1 - r] % MOD;
	            }
	            return hash;
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