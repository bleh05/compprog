
// Problem : G1. Playlist for Polycarp (easy version)
// Contest : Codeforces - Codeforces Round #568 (Div. 2)
// URL : https://codeforces.com/contest/1185/problem/G1
// Memory Limit : 256 MB
// Time Limit : 5000 ms
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
			tup[] arr = new tup[n];
			for(int i = 0; i < n; i++) {
				arr[i] = new tup(sc.nextInt(), sc.nextInt()-1);
			}
			List<Integer>[] arr2 = Stream.generate(ArrayList::new).limit(16).toArray(List[]::new);
			for(int i = 1; i < (1<<n); i++) {
				int t = i;
				int bits = 0;
				while(t > 0) {
					if((t & 1) == 1) bits ++;
					t>>=1;
				}
				arr2[bits].add(i);
			}
			int[][] dp = new int[1<<n][3];
			dp[0] = new int[]{1, 1, 1};
			long c = 0;
			for(int i = 1; i <= n; i++) {
				for(int x : arr2[i]) {
					int totallen = 0;
					ArrayList<Integer> active = new ArrayList<>();
					for(int j = 0; j < n; j++) {
						if((x & (1 << j)) > 0){
							active.add(j);
							totallen += arr[j].a;
						}
					}
					for(int y : active) {
						if(i == 1) dp[x][arr[y].b]++;
						else dp[x][arr[y].b] += dp[x - (1<<y)][(arr[y].b+1)%3] + dp[x - (1<<y)][(arr[y].b+2)%3];
						dp[x][arr[y].b] %= 1000000007;
					}
					if(totallen == m) {
						c += dp[x][0] + dp[x][1] + dp[x][2];
						c %= 1000000007;
					}
				}
			}
			pw.println(c);
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