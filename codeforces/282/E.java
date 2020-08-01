
// Problem : E. Sausage Maximization
// Contest : Codeforces - Codeforces Round #173 (Div. 2)
// URL : https://codeforces.com/contest/282/problem/E
// Memory Limit : 256 MB
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
			long[] arr = new long[n];
			node cent = new node(0);
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextLong();
			}
			long max = 0;
			long cuxor = 0;
			long[] cxsr = new long[n];
			cxsr[n - 1] = arr[n - 1];
			for(int i = n - 2; i >= 0; i--) {
				cxsr[i] = arr[i] ^ cxsr[i + 1];
			}
			node currs = cent;
			for(int i = 0; i < 39; i++) {
				currs.zr = new node(39 - i);
				currs = currs.zr;
			}
			for(int k = 0; k <= n; k++) {
				node curr = cent;
				if(k > 0) {
					long chk = cxsr[k - 1];
					max = Math.max(chk, max);
					curr = cent;
					long c = (1l<<40) - 1;
					for(int i = 39; i >= 0; i--) {
						if((chk & (1l<<i)) > 0) { 
							if(curr.zr == null) {
								curr = curr.on;
								c -= (1l<<i);
							}
							else curr = curr.zr;
						}
						else {
							if(curr.on == null) {
								curr = curr.zr;
								c -= (1l<<i);
							}
							else curr = curr.on;
						}
					}
					//pw.println(c);
					max = Math.max(max, c);
				}
				if(k == n) break;
				cuxor ^= arr[k];
				max = Math.max(cuxor, max);
				curr = cent;
				for(int i = 39; i >= 0; i--) {
					if((cuxor & (1l<<i)) > 0) {
						if(curr.on == null) curr.on = new node(i);
						curr = curr.on;
					}
					else {
						if(curr.zr == null) curr.zr = new node(i);
						curr = curr.zr;
					}
				}
			}
			pw.println(Math.max(cuxor, max));
		}
	}
	static class node {
		node zr;
		node on;
		int val;
		node(int a) {
			val = a;
		}
		public String toString(){
			return "" + val;
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