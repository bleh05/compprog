
// Problem : B. Destroying Roads
// Contest : Codeforces - Codeforces Round #302 (Div. 1)
// URL : https://codeforces.com/contest/543/problem/B
// Memory Limit : 256 MB
// Time Limit : 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

import java.io.*;
import java.util.*;

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
			ArrayList<ArrayList<Integer>> adjl = new ArrayList<>();
			for(int i = 0; i < n; i++){
				adjl.add(new ArrayList<Integer>());
			}
			for(int i = 0; i < m; i++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				adjl.get(a).add(b);
				adjl.get(b).add(a);
			}
			int t1 = sc.nextInt() - 1; int s1 = sc.nextInt() - 1; int tot1 = sc.nextInt();
			int t2 = sc.nextInt() - 1; int s2 = sc.nextInt() - 1; int tot2 = sc.nextInt();
			int[][] bfsmat = new int[n][n];
			Queue<Integer> q = new LinkedList<Integer>();
			for(int i = 0; i < n; i++){
				q.add(i);
				Arrays.fill(bfsmat[i] , inf);
				bfsmat[i][i] = 0;
				while(!q.isEmpty()){
					int t = q.poll();
					for(int x : adjl.get(t)){
						if(bfsmat[i][t] + 1 < bfsmat[i][x]) {
							q.add(x);
							bfsmat[i][x] = bfsmat[i][t] + 1;
						}
					}
				}
			}
			int min = inf;
			if(bfsmat[t1][s1] <= tot1 && bfsmat[t2][s2] <= tot2){
				min = bfsmat[t1][s1] + bfsmat[t2][s2];
			}
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					int d1 = Math.min(bfsmat[t1][i] + bfsmat[s1][j], bfsmat[t1][j] + bfsmat[s1][i]);
					int d2 = Math.min(bfsmat[t2][i] + bfsmat[s2][j], bfsmat[t2][j] + bfsmat[s2][i]);
					if(d1 + bfsmat[i][j] <= tot1 && d2 + bfsmat[i][j] <= tot2){
						min = Math.min(min, d1 + d2 + bfsmat[i][j]);
					}
				}
			}
			pw.println(min == inf ? -1 : m - min);
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