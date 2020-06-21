
// Problem : B. Alice and Hairdresser
// Contest : Codeforces - Mail.Ru Cup 2018 Round 2
// URL : https://codeforces.com/problemset/problem/1055/B
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
		void make_set(int v) {
		    parent[v] = v;
		}
		
		int find_set(int v) {
		    if (v == parent[v])
		        return v;
		    return find_set(parent[v]);
		}
		
		void union_sets(int a, int b) {
		    a = find_set(a);
		    b = find_set(b);
		    if (a != b)
		        parent[b] = a;
		}
		int[] parent = new int[100002];
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			int n = sc.nextInt();
			int q = sc.nextInt();
			int k = sc.nextInt();
			int numset = 0;
			long[] stuf = new long[n];
			Arrays.fill(parent, -1);
			for(int i = 0; i < n; i++) {
				stuf[i] = sc.nextInt();
				if(stuf[i] > k) {
					if(i == 0 || stuf[i-1] <= k) {
						make_set(i);
						numset++;
					}
					else if(i > 0){
						make_set(i);
						union_sets(i, i - 1);
					}
				}
			}
			for(int i = 0; i < q;i ++) {
				int zz = sc.nextInt();
				if(zz == 0) {
					pw.println(numset);
				}
				else {
					int ind = sc.nextInt()-1;
					int add = sc.nextInt();
					stuf[ind] += add;
					if(stuf[ind] > k && stuf[ind] - add <= k) {
						make_set(ind);
						boolean a1 = false;
						boolean a2 = false;
						if(ind > 0 && parent[ind - 1] != -1) {
							a1 = true;
						} 
						if(ind < n - 1 && parent[ind + 1] != -1) {
							a2 = true;
						} 
						if(!a1 && !a2) {
							numset++;
						}
						if(a1 && !a2) {
							union_sets(ind - 1, ind);
						}
						if(!a1 && a2) {
							union_sets(ind + 1, ind);
						}
						if(a1 && a2) {
							union_sets(ind + 1, ind);
							union_sets(ind - 1, ind);
							numset--;
						}
					}
				}
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