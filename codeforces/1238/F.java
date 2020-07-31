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
		int t = scan.nextInt();
		//int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}

	static class Task {
		static final int inf = Integer.MAX_VALUE;
		int[][] dp;
		List<Integer>[] adjl;
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			int n = sc.nextInt();
			adjl = Stream.generate(ArrayList::new).limit(n).toArray(List[]::new);
			for(int i = 0; i < n - 1; i++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				adjl[a].add(b);
				adjl[b].add(a);
			}
			if(n == 2) {
				pw.println(2);
				return;
			}
			dp = new int[n][2];
			for(int i = 0; i < n; i++) {
				if(adjl[i].size() > 1) {
					dfs(i, -1);
					pw.println(dp[i][0]);
					break;
				}
			}
		}
		void dfs(int v, int p) {
			ArrayList<Integer> ar = new ArrayList<>();
			for(int x : adjl[v]) {
				if(x == p) continue;
				dfs(x, v);
				dp[v][0] = Math.max(dp[x][0], dp[v][0]);
				ar.add(dp[x][1]);
			}
			Collections.sort(ar);
			int[] max = new int[2];
			for(int i = ar.size() - 1; i > Math.max(ar.size() - 3, -1); i--) {
				max[ar.size() - 1 - i] = ar.get(i);
			}
			dp[v][0] = Math.max(dp[v][0], adjl[v].size() + 1 + max[0] + max[1]);
			dp[v][1] = adjl[v].size() - 1 + max[0];
			
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