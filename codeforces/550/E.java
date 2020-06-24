
// Problem : E. Brackets in Implications
// Contest : Codeforces - Codeforces Round #306 (Div. 2)
// URL : https://codeforces.com/contest/550/problem/E
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
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			if(arr[n - 1] == 1) {
				pw.println("NO");
				return;
			}
			if(n > 1) {
				for(int i = 0; i < n; i++) {
					if(!(i <= n - 3 && arr[i] == 1 || i > n - 3 && arr[i] == 0)) {
						break;
					}
					if(i == n - 1) {
						pw.println("NO");
						return;
					}
				}
			}
			pw.println("YES");
			if(n == 1) {
				pw.println(0);
				return;
			}
			if(arr[n - 2] == 1) {
				for(int i = 0; i < n; i++) {
					pw.print(arr[i]);
					if(i != n - 1) {
						pw.print("->");
					}
				}
				pw.println();
			}
			else {
				boolean ok = false;
				int first = -1;
				int second = -1;
				for(int i = n - 2; i >= 0; i--) {
					if(arr[i] == 0) {
						if(first == -1) {
							first = i;
						}
						else{
							second = i;
							break;
						}
					}
				}
				for(int i = 0; i < n; i++) {
					if(i == second) {
						pw.print('(');
					}
					if(i == second + 1 && i != first) {
						pw.print('(');
					}
					pw.print(arr[i]);
					if(i == first) {
						if(i != second + 1) {
							pw.print(')');
						}
						pw.print(')');
					}
					
					if(i != n - 1) {
						pw.print("->");
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