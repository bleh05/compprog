
// Problem : C. Brackets
// Contest : Codeforces - Codeforces Beta Round #92 (Div. 1 Only)
// URL : https://codeforces.com/contest/123/problem/C
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
			long k = sc.nextLong();
			int c = n + m - 1;
			tup d[] = new tup[c];
			char s[] = new char[200];
		    for (int i = 0; i < c; i++)
		    {
		       d[i] = new tup(i, n * m);
		    }
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					d[i + j].b = Math.min(sc.nextInt(), d[i + j].b);
				}
			}
			Arrays.sort(d);
			long[][] f = new long[201][201];
			for (int I = 0; I < c; I++){
			        s[d[I].a] = '(';	
			 
			        f[0][0] = 1;
			        for (int i = 0; i < c; i++)
			            for (int j = i & 1; j <= i && j <= c - i; j += 2)
			                if (f[i][j] > 0)
			                {
			                    if (f[i][j] > k) f[i][j] = k;
			 
			                    if (s[i] != ')') f[i + 1][j + 1] += f[i][j];
			                    if (s[i] != '(' && j > 0) f[i + 1][j - 1] += f[i][j];
			                    f[i][j] = 0;
			                }
			        if (k > f[c][0])
			        {
			            k -= f[c][0];
			            s[d[I].a] = ')';
			        }
		        f[c][0] = 0;
		    }
		    for(int i = 0; i < n; i++) {
		    	for(int j = 0; j < m; j++) {
		    		pw.print(s[i + j]);
		    	}
		    	pw.println();
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
			return Integer.compare(b,o.b);
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