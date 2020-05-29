
// Problem : A. Greg and Array
// Contest : Codeforces - Codeforces Round #179 (Div. 1)
// URL : https://codeforces.com/contest/295/problem/A
// Memory Limit : 256 MB
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
			int m = sc.nextInt();
			int q = sc.nextInt();
			long arr[] = new long[n];
			int[][] par = new int[m][3];
			for(int i = 0; i < n; i++){
				arr[i] = sc.nextInt();
			}
			for(int j = 0; j < m; j ++) {
				par[j] = new int[]{sc.nextInt()-1,sc.nextInt(),sc.nextInt()};
			}
			PriorityQueue<tup> pq = new PriorityQueue<tup>();
			for(int i = 0; i < q; i++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt();
				pq.add(new tup(1, a));
				pq.add(new tup(-1, b));
			}
			for(int i = 0; i < m; i++) {
				pq.add(new tup(Long.MAX_VALUE, i));
			}
			int[] multf = new int[m];
			int z = 0;
			while(!pq.isEmpty()) {
				tup t = pq.poll();
				if(t.a == 1) {
					z++;
				}
				if(t.a > 1) {
					multf[(int)t.b] = z;
				}
				if(t.a == -1) {
					z--;
				}
			}
			PriorityQueue<tup> pq2 = new PriorityQueue<tup>();
			for(int i = 0; i < m; i++) {
				pq2.add(new tup( 1l * par[i][2] * multf[i], par[i][0]));
				pq2.add(new tup(-1l * par[i][2] * multf[i], par[i][1]));
			}
			for(int i = 0; i < n; i++) {
				pq2.add(new tup(Long.MAX_VALUE, i));
			}
			long zz = 0;
			while(!pq2.isEmpty()) {
				tup t = pq2.poll();
				if(t.a == Long.MAX_VALUE) {
					arr[(int)t.b] += zz;
				}
				else {
					zz += t.a;
				}
			}
			for(long x : arr){
				pw.print(x + " ");
			}
			pw.println();
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
		long a, b;
		tup(long a,long b){
			this.a=a;
			this.b=b;
		}
		@Override
		public int compareTo(tup o){
			return b == o.b ? 
			 Long.compare(a, o.a) :Long.compare(b,o.b);
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