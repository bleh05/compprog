
// Problem : C. Bulmart
// Contest : Codeforces - 2016-2017 ACM-ICPC, NEERC, Southern Subregional Contest (Online Mirror, ACM-ICPC Rules, Teams Preferred)
// URL : https://codeforces.com/contest/730/problem/C
// Memory Limit : 512 MB
// Time Limit : 1500 ms
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
			int[][] arr = new int[n][n];
			int a = 0;
			int b =0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j] == 0 ) {a= i; b = j;}
				}
			}
			long rows[] =new long[n];
			long[] cols = new long[n];
			long diag1 = 0;
			long diag2 = 0;
			for(int i =0 ;i < n; i++) {
				for(int j = 0; j < n; j++) {
					rows[i] += arr[i][j];
					cols[j] += arr[i][j];
					if(i == j) {
						diag1 += arr[i][j];
					}
					if(i + j == n - 1) {
						diag2 += arr[i][j];
					}
				}
			}
			if(n == 1) {
				pw.println(1);
				return;
			}
			Arrays.sort(rows);
			Arrays.sort(cols);
			for(int i = 2; i < n; i++) {
				if(rows[i] != rows[i - 1]) {
					pw.println(-1);
					return;
				}
				if(cols[i] != cols[i - 1]) {
					pw.println(-1);
					return;
				}
				if(rows[i] != cols[i]) {
					pw.println(-1);
					return;
				}
			}
			if(n >= 2) {
				if(a != b && diag1 != rows[1]) {
					pw.println(-1);
					return;
				}
				if(a + b != n - 1 && diag2 != rows[1]) {
					pw.println(-1);
					return;
				}
				if(a + b == n - 1 && diag2 != rows[0]) {
					pw.println(-1);
					return;
				}
				if(a == b && diag1 != rows[0]) {
					pw.println(-1);
					return;
				}
				if(rows[1] != cols[1]) {
					pw.println(-1);
					return;
				}
				if(rows[1] == rows[0] || cols[1] == cols[0] ) {
					pw.println(-1);
					return;
				}
			}
			pw.println(rows[1] - rows[0]);
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