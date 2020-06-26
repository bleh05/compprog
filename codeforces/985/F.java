
// Problem : F. Isomorphic Strings
// Contest : Codeforces - Educational Codeforces Round 44 (Rated for Div. 2)
// URL : https://codeforces.com/contest/985/problem/F
// Memory Limit : 256 MB
// Time Limit : 3000 ms
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
	static class CharHash {
        private static int MOD = (int) (1e9 + 7);
        private int[] inverse;
        private int[][] hash;
        private int n;
        private int x;
 
        public CharHash(char[] data, int x) {
            n = data.length;
            inverse = new int[n];
            this.x = x;
            inverse[0] = 1;
            long inv = binpow(x, MOD - 2, MOD);
            for (int i = 1; i < n; i++) {
                this.inverse[i] = (int) (this.inverse[i - 1] * inv % MOD);
            }
 
            hash = new int[27][n];
            for(int i = 0; i < 27; i++) {
                char c = (char) (i + 'a');
                hash[i][n - 1] = data[n - 1] == c ? 1 : 0;
                long baseInc = 1;
                for (int j = n - 2; j >= 0; j--) {
                    baseInc = baseInc * x % MOD;
 
                    int dataval = data[j] == c ? 1 : 0;
 
                    hash[i][j] = (int) (((long) hash[i][j + 1] + dataval * baseInc) % MOD);
                }
            }
        }
        public int hash(int l, int r, char c) {
            int index = c - 'a';
            long hash = this.hash[index][l];
            if (r < n - 1) {
                hash = hash - this.hash[index][r + 1];
                if (hash < 0) {
                    hash += MOD;
                }
                hash = hash * inverse[n - 1 - r] % MOD;
            }
            return (int) hash;
    	}
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
			String dat = sc.nextLine();
			CharHash hashed31 = new CharHash(dat.toCharArray(), 31);
			CharHash hashed61 = new CharHash(dat.toCharArray(), 48491);
			boolean[] has = new boolean[27];
			for(int i = 0; i < m; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				int l = sc.nextInt();
				Arrays.fill(has, false);
				
				boolean ok = true;
				l:
				for(char c = 'a'; c <= 'z'; c++) {
					int xHash31 = hashed31.hash(x, x + l - 1, c);
					int xHash61 = hashed61.hash(x, x + l - 1, c);
					boolean find = false;
					for(char d = 'a'; d <= 'z' + 1; d++) {
						if(has[d-'a']) continue;
						int yHash31 = hashed31.hash(y, y + l - 1, d);
						int yHash61 = hashed61.hash(y, y + l - 1, d);
						if(xHash31 == yHash31 && xHash61 == yHash61) {
							has[d-'a'] = true;
							find = true;
							break;
						}
					}
					if(!find) {
						ok = false;
						break;
					}
				}
				pw.println(ok ? "YES" : "NO");
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