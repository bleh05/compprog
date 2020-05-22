
// Problem : E. Tree with Small Distances
// Contest : Codeforces - Codeforces Round #506 (Div. 3)
// URL : https://codeforces.com/contest/1029/problem/E
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

		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			int n = sc.nextInt();
			ArrayList<Integer>[] adjl = new ArrayList[n];
			for(int i = 0; i < n; i++){
				adjl[i] = new ArrayList<Integer>();
			}
			for(int i = 0; i < n - 1; i++){
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				adjl[a].add(b);
				adjl[b].add(a);
			}
			int[] bfs = new int[n];
			Queue<Integer> q = new LinkedList<>();
			q.add(0);
			Arrays.fill(bfs, inf);
			bfs[0] = 0;
			tup[] arr = new tup[n];
			TreeSet<tup> ts = new TreeSet<>();
			while(!q.isEmpty()){
				int t = q.poll();
				for(int x : adjl[t]){
					if(bfs[x] - 1 > bfs[t]) {
						bfs[x] = bfs[t] + 1;
						arr[x] = new tup(x, bfs[x]);
						if(bfs[x] > 2) { 
							ts.add(arr[x]);
						}
						q.add(x);
					}
				}
			}
			int ans = 0;
			while(!ts.isEmpty()) {
				int x = ts.higher(new tup(-1, 9999999)).a;
				ans ++;
				for(int y : adjl[x]) {
					if(bfs[y] == bfs[x] - 1) {x = y; break;}
				}
				if(ts.contains(arr[x])) ts.remove(arr[x]);
				for(int y : adjl[x]) {
					if(ts.contains(arr[y])) {
						ts.remove(arr[y]);
					}
				}
			}
			pw.println(ans);
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
			return b == o.b ? Integer.compare(a, o.a) : Integer.compare(o.b, b);
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