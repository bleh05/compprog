
// Problem : R - Walk
// Contest : Educational DP Contest
// URL : https://atcoder.jp/contests/dp/tasks/dp_r
// Memory Limit : 1024 MB
// Time Limit : 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		FastReader scan = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		//PrintWriter out = new PrintWriter("file.out");
		Task solver = new Task();
		//int t = scan.nextInt();
		int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}

	static class Task {
		static final int inf = Integer.MAX_VALUE;
		static final int mod = 1000000007;
		long[][] a;
		int x;
		long[][] r;
		long[][] tp;
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			x= sc.nextInt();
			long k = sc.nextLong();
			a=new long[x][x];
			r=new long[x][x];
			tp = new long[x][x];
			for(int i=0;i<x;i++){
				for(int j=0;j<x;j++){
					a[i][j]=sc.nextInt();
				}
			}
			for(int i=0;i<x;i++)r[i][i]++;
			while(k>0){
				if((k&1)>0){
					mul(r,a);
				}
				mul(a,a);
				k>>=1;
			}
			long sum = 0;
			for(long[] x : r){
				for(long y : x){
					sum+=y;
					sum%=mod;
				}
			}
			pw.println(sum);
		}
		
		void mul(long[][] a, long[][]b) {
			int i, j, k;long val;
			
			for (i = 0; i < x; i++) {
				for (j = 0; j < x; j++) {
					val = 0;
					for (k = 0; k < x; k++)val = (val+ (a[i][k]) * b[k][j]) % 1000000007;
					tp[i][j] = val;
				}
			}
			for (i = 0; i < x; i++) {
				for (j = 0; j < x; j++) a[i][j] = tp[i][j];
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
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	static void shuffle(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
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