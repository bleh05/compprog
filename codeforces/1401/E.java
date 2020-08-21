
// Problem : E. Divide Square
// Contest : Codeforces - Codeforces Round #665 (Div. 2)
// URL : https://codeforces.com/contest/1401/problem/E
// Memory Limit : 384 MB
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
			int n = sc.nextInt();
			int m = sc.nextInt();
			PriorityQueue<tup> events = new PriorityQueue<tup>();
			long sum = 1;
			for(int i = 0; i < n; i++) {
				int y1 = sc.nextInt();
				int x1 = sc.nextInt();
				int x2 = sc.nextInt();
				if(x1 == 0 && x2 == 1000000) {
					sum++;
				}
				events.add(new tup(x1, y1, -2));
				events.add(new tup(x2, y1, 10000022));
			}
			for(int j = 0; j < m; j++) {
				int x1 = sc.nextInt();
				int y1 = sc.nextInt();
				int y2 = sc.nextInt();
				if(y1 == 0 && y2 == 1000000) {
					sum++;
				}
				events.add(new tup(x1, y1, y2));
			}
			bit b = new bit(1000002);
			while(!events.isEmpty()) {
				tup t = events.poll();
				if(t.c == -2) {
					b.add(t.b, 1);
				}
				else if(t.c == 10000022) {
					b.add(t.b, -1);
				}
				else {
					sum += b.sum(t.c, t.b);
					//pw.println(t.a + " " + t.b + " " + t.c + " " + b.sum(t.c, t.b));
				}
				//pw.println(t.a + " " + t.b + " " + t.c);
			}
			pw.println(sum);
		}
		static class bit { 
			int n;
			int[] bit;
			public bit(int n) {
				this.n=n;
				bit=new int[n+1];
			}
			void add(int ind, int c) {
				for(; ind<n;ind|=(ind+1)) {
					bit[ind]+=c;
				}
			}
			int sum(int r) {
				int out =0;
				for(;r>=0;r=(r&(r+1))-1) {
					out+=bit[r];
				}
				return out;
			}
			int sum(int r, int l) {
				return sum(r)-sum(l-1);
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
		int a, b, c;
		tup(int a,int b, int c){
			this.a=a;
			this.b=b;
			this.c=c;
		}
		@Override
		public int compareTo(tup o){
			return a == o.a ? Integer.compare(c, o.c) : Integer.compare(a, o.a);
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