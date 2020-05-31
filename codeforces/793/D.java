
// Problem : D. Presents in Bankopolis
// Contest : Codeforces - Tinkoff Challenge - Elimination Round
// URL : https://codeforces.com/contest/793/problem/D
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
			int m = sc.nextInt();
			if(m == 1){pw.println(0);return;}
			List<tup>[] adjl = Stream.generate(ArrayList::new).limit(n+1).toArray(List[]::new);
			int[][][][] dp = new int[n+3][n+3][n+1][m + 1];
			for(int i = 0; i < n + 3; i ++) {
				for(int j = 0; j < n + 3; j++) {
					for(int l = 0; l < n + 1; l++) {
						for(int o = 0; o <= m; o++) {
							dp[i][j][l][o] = inf;
						}
					}
				}
			}
			ArrayDeque<Integer> q = new ArrayDeque<Integer>();
			int k = sc.nextInt();
			int ans = inf;
			for(int i = 0; i < k; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				adjl[a].add(new tup(b,c));
				if(a > b){
					dp[0][a][b][2] = Math.min(dp[0][a][b][2], c);
					if(m > 2)
					q.add((a)*10000 + b*100 + 2);
					else{
						ans = Math.min(c, ans);
					}
				}
				else{
					dp[a][n+1][b][2] = Math.min(dp[a][n+1][b][2], c);
					if(m > 2)
					q.add(a * 1000000 + (n+1)*10000 + b*100 + 2);
					else{
						ans = Math.min(c, ans);
					}
				}
			}
			while(!q.isEmpty()){ 
				int t = q.poll();
				int len = t%100;
				t/=100;
				int stn = t%100;
				t/=100;
				int r = t%100;
				t/=100;
				int l = t;
				for(tup x : adjl[stn]) {
					if(x.a > stn && x.a < r) {
						int nl = Math.max(stn, l);
						int nr = r;
						if(dp[nl][nr][x.a][len+1] > dp[l][r][stn][len] + x.b) {
							dp[nl][nr][x.a][len+1] = dp[l][r][stn][len] + x.b;
							if(len+1 == m) {
								ans = Math.min(ans, dp[nl][nr][x.a][len+1]);
							}
							else{
								q.add(nl*1000000 + nr*10000 + x.a*100 + len + 1);
							}
						}
					}
					if(x.a < stn && x.a > l) {
						int nl = l;
						int nr = Math.min(stn, r);
						if(dp[nl][nr][x.a][len+1] > dp[l][r][stn][len] + x.b) {
							dp[nl][nr][x.a][len+1] = dp[l][r][stn][len] + x.b;
							if(len+1 == m) {
								ans = Math.min(ans, dp[nl][nr][x.a][len+1]);
							}
							else{
								q.add(nl*1000000 + nr*10000 + x.a*100 + len + 1);
							}
						}
					}
				}
			}
			if(ans == inf) pw.println(-1);
			else pw.println(ans);
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