
// Problem : B. Tree Tag
// Contest : Codeforces - Codeforces Round #668 (Div. 1)
// URL : https://codeforces.com/contest/1404/problem/B
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
		int t = scan.nextInt();
		//int t = 1;
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
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			int da = sc.nextInt();
			int db = sc.nextInt();
			List<Integer>[] adjl = Stream.generate(ArrayList::new).limit(n).toArray(List[]::new);
			for(int i = 0; i < n-1; i++) {
				int as = sc.nextInt() - 1;
				int bs = sc.nextInt() - 1;
				adjl[as].add(bs);
				adjl[bs].add(as);
			}
			if(da * 2 >= db) {
				pw.println("Alice");
				return;
			}
			int[] bfs = new int[n];
			Arrays.fill(bfs, inf);
			bfs[a] = 0;
			ArrayDeque<Integer> q = new ArrayDeque<>();
			q.add(a);
			while(q.size() > 0) {
				int t = q.poll();
				for(int x : adjl[t]) {
					if(bfs[x] > bfs[t] + 1) {
						bfs[x] = bfs[t] + 1;
						q.add(x);
					}
				}
			}
			if(bfs[b] <= da) {
				pw.println("Alice");
				return;
			}
			int ind = 0;
			int max = 0;
			for(int i = 0; i < n; i++) {
				if(bfs[i] > max) {
					max = bfs[i];
					ind = i;
				}
			}
			q.add(ind);
			int[] bfs2 = new int[n];
			Arrays.fill(bfs2, inf);
			bfs2[ind] = 0;
			while(q.size() > 0) {
				int t = q.poll();
				for(int x : adjl[t]) {
					if(bfs2[x] > bfs2[t] + 1) {
						bfs2[x] = bfs2[t] + 1;
						q.add(x);
					}
				}
			}
			int dia = 0;
			for(int i = 0; i < n; i++) {
				dia = Math.max(dia, bfs2[i]+1);
			}
			if(dia / 2 <= da) {
				pw.println("Alice");
			}
			else {
				pw.println("Bob");
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