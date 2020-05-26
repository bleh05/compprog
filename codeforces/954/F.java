
// Problem : F. Runner's Problem
// Contest : Codeforces - Educational Codeforces Round 40 (Rated for Div. 2)
// URL : https://codeforces.com/contest/954/problem/F
// Memory Limit : 256 MB
// Time Limit : 4000 ms
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
			long m = sc.nextLong();
			tup[] arr = new tup[2*n];
			for(int i = 0; i < n; i++) {
				int a = sc.nextInt() - 1;
				long l = sc.nextLong();
				long r = sc.nextLong();
				arr[2 * i] = new tup(l, a, 1);
				arr[2 * i + 1] = new tup(r, a, -1);
			}
			Arrays.sort(arr);
			int[] state = new int[3];
			long[][] ans = {{0},{1},{0}};
			for(int i = -1; i < 2 * n; i++) {
				if(i != -1) {
					if(arr[i].c == 1) {
						state[arr[i].b] ++;
					}
					else {
						state[arr[i].b] --;
					}
				}
				long l = 0;
				long r = 0;
				if(i == -1) {
					l = 2;
				}
				else{
					if(arr[i].c == -1)
					{
						l = arr[i].a + 1;
					}
					else{
						l = arr[i].a;
					}
				}
				if(i == 2 * n - 1) {
					r = m + 1;
				}
				else{
					if(arr[i + 1].c == -1)
					{
						r = arr[i + 1].a + 1;
					}
					else{
						r = arr[i + 1].a;
					}
				}
				ans= power(ans, Math.max(0, r- l), state);
//				pw.println(Arrays.toString(state));
//				if(i > -1)
//				pw.println(arr[i].a+  " " + arr[i].b + " " + arr[i].c);
//				pw.println(Arrays.deepToString(ans) + " "  + (r-l));
			}
			long a = ans[1][0];
			pw.println(a%1000000007);
		}
		long[][] power(long res[][], long n, int[] k) 
	    {
			long[][] arr = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
	    	for(int i = 0; i < 3; i++) {
	    		if(k[i] > 0) {
	    			arr[i] = new long[]{0, 0, 0};
	    		}
	    	}
			while (n > 0) {
				if ((n & 1) == 1)
					res = mul(res, arr);
				arr = mul(arr,arr);
				n >>= 1;
			}
			return res;
	    } 
		long[][] mul (long[][] mat2, long[][] mat1) {
			long[][] arr = new long[mat1.length][mat2[0].length];
			for(int i = 0; i < mat1.length; i++) {
				for(int j = 0; j < mat2[0].length; j++) {
					long ans = 0;
					for(int k = 0; k < mat1.length; k++) {
						ans += mat1[i][k] * mat2[k][j];
						ans %= 1000000007;
					}
					arr[i][j] = ans;
				}
			}
			return arr;
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
		long a; int b, c;
		tup(long a, int b, int c){
			this.a=a;
			this.b=b;
			this.c=c;
		}
		@Override
		public int compareTo(tup o){
			return Long.compare(a, o.a) * 15 + Integer.compare(o.c, c);
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