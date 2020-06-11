
// Problem : A. Fight the Monster
// Contest : Codeforces - Codeforces Round #278 (Div. 1)
// URL : https://codeforces.com/problemset/problem/487/A
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
			int hp1 = sc.nextInt();
			int dps2 = sc.nextInt();
			int dps1 = -sc.nextInt();
			int hp2 = sc.nextInt();
			dps1 += sc.nextInt();
			dps2 -= sc.nextInt();
			int cost1 = sc.nextInt();
			int cost2 = sc.nextInt();
			int cost3 = sc.nextInt();
			long cc = Long.MAX_VALUE;
			//pw.println(dps1 + " " + dps2);
			dps1 = Math.max(dps1, 0);
			for(int i = hp1; i <= 1000; i++) {
				for(int j = dps1; j >= 0; j--) {
					for(int k = dps2; k <= 1000; k++) {
						long cost = (i - hp1) * cost1 + (dps1 - j) * cost3 + (k - dps2) * cost2;
						int time1;
						if(j <= 0) {
							time1 = inf;
						}
						else time1 = (i + j - 1) / j;
						int time2;
						if(k <= 0) {
							time2 = inf;
						}
						else 
						time2 = (hp2 + k - 1) / k;
						if(time1 > time2) {
							cc = Math.min(cost, cc);
							//if(cost <= 825)
							//pw.println(i + " " + j + " " + k);
						}
					}
				}
			}
			if(cc == Long.MAX_VALUE) {
				pw.println(0);
			}
			else
			pw.println(cc);
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