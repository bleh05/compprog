
// Problem : D. Ralph And His Tour in Binary Country
// Contest : Codeforces - Codeforces Round #447 (Div. 2)
// URL : https://codeforces.com/contest/894/problem/D
// Memory Limit : 512 MB
// Time Limit : 2500 ms
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
			int[] wei = new int[n+1];
			for(int i = 1; i < n; i++) wei[i+1] = sc.nextInt();
			int[][] steg = new int[n + 2][];
			long[][] pref = new long[n + 2][];
			for(int i = n; i >= 1; i--) {
				int len = 0;
				if(i * 2 + 1 <= n) {
					len += steg[i*2+1].length + steg[i*2].length+1;
					steg[i] = new int[len];
					int ptr1 = 0;
					int ptr2 = 0;
					for(int j = 1; j < len; j++) {
						if(ptr1 < steg[i * 2].length && ((ptr2 >= steg[i*2+1].length || wei[i*2] + steg[i*2][ptr1] < wei[i*2+1] + steg[i*2+1][ptr2]))) {
							steg[i][j] = wei[i*2] + steg[i*2][ptr1++];
						}
						else {
							steg[i][j] = wei[i*2+1] + steg[i*2+1][ptr2++];
						}
					}
				}
				else if(i * 2 <= n) {
					len += steg[i*2].length + 1;
					steg[i] = new int[len];
					for(int j = 1; j < len; j++) {
						steg[i][j] = steg[2*i][j-1] + wei[i*2];
					}
				}
				else {
					len = 1;
					steg[i] = new int[1];
				}
				//System.out.println(Arrays.toString(steg[i]));
				pref[i] = new long[len];
				for(int k = 1; k < len; k++) {
					pref[i][k] = pref[i][k-1] + steg[i][k];
				}
			}
			for(int i = 0; i < m; i++) {
				int v = sc.nextInt();
				int h = sc.nextInt();
				long sum = 0;
				int l = 0; int r = steg[v].length - 1;
				while(r - l > 1) {
					int mid = (l + r) / 2;
					if(steg[v][mid] <= h) {
						l = mid;
					}
					else r = mid-1;
				}
				if(steg[v][r] < h) {
					l = r;
				}
				sum += 1l * h * (l + 1) - pref[v][l];
				h -= wei[v];
				//pw.println(sum + " " + l + " " + r);
				while(v > 1 && h > 0) {
					if((v ^ 1) <= n) {
						h -= wei[v ^ 1];
						l = 0; r = steg[v ^ 1].length - 1;
						while(r - l > 1) {
							int mid = (l + r) / 2;
							if(steg[v ^ 1][mid] <= h) {
								l = mid;
							}
							else r = mid-1;
						} 
						//pw.println(h + "zz" + " " + l + " " + r);
						if(steg[v ^ 1][r] < h) {
							l = r;
						}
						sum += Math.max(1l * h * (l + 1) - pref[v ^ 1][l], 0);
						h += wei[v ^ 1];
						v /= 2;
						sum += h;
						//pw.println(h + "ee");
						h -= wei[v];
					}
					else {
						v /= 2;
						sum += h;
						//pw.println(h + "ee");
						h -= wei[v];
					}
				}
				pw.println(sum);
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