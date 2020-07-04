
// Problem : E. Chemistry in Berland
// Contest : Codeforces - Educational Codeforces Round 28
// URL : https://codeforces.com/contest/846/problem/E
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
			long[] curr;
			long[] goal;
			List<tup>[] adjl;			
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			int n = sc.nextInt();
			curr = new long[n];
			goal = new long[n];
			adjl = Stream.generate(ArrayList::new).limit(n).toArray(List[]::new);

			for(int i = 0; i < n; i++) curr[i] = sc.nextLong();
			for(int i = 0; i < n; i++) goal[i] = sc.nextLong();
			for(int i = 1; i < n; i++) {
				int nd = sc.nextInt();
				adjl[nd - 1].add(new tup(i, sc.nextLong()));
			}
			if(dfs(0) >= 0) {
				pw.println("YES");
			}
			else{
				pw.println("NO");
			}
		}
		long dfs(int n) {
			long ans = 0;
			for(tup x : adjl[n]) {
				long c = dfs((int)x.a);
				if(c < 0) {
					if(c < -1_000_000_000_000_000_000l/x.b) {
						System.out.println("nO");
						System.exit(0);
					}
					ans += c * x.b;
					if(ans < -1_000_000_000_000_000_000l) {
						System.out.println("No");
						System.exit(0);
					}
				}
				else { 
					ans += c;
				}
			}
			ans += curr[n];
			ans -= goal[n];
			return ans;
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
			return Long.compare(o.b,b);
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