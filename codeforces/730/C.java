
// Problem : C. Bulmart
// Contest : Codeforces - 2016-2017 ACM-ICPC, NEERC, Southern Subregional Contest (Online Mirror, ACM-ICPC Rules, Teams Preferred)
// URL : https://codeforces.com/contest/730/problem/C
// Memory Limit : 512 MB
// Time Limit : 1500 ms
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
			boolean kek = false;
			List<Integer>[] adjl = Stream.generate(ArrayList::new).limit(n).toArray(List[]::new);
			for(int i = 0; i < m; i++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				adjl[a].add(b);
				adjl[b].add(a);
				if(a == 0 && b == 276) {
					kek = true;
				}
			}
			int stores = sc.nextInt();
			tup store[] = new tup[stores];
			
			for(int i = 0; i < stores; i ++) {
				tup t = new tup(sc.nextInt() - 1, sc.nextInt(), sc.nextInt()); // city, num, cost
				store[i] = t;
			}
			
			Arrays.sort(store);
			int[] q = new int[5005];
			int qs = sc.nextInt();
			for(int i = 0; i < qs; i++) {
				int start = sc.nextInt() - 1;
				int num = sc.nextInt();
				int money = sc.nextInt();
				int[] bfs = new int[n];
				int qptr = 0;
				int qpop = 0;
				q[qptr++] = start;
				Arrays.fill(bfs, inf);
				bfs[start] = 0;
				while(qptr != qpop) {
					int t = q[qpop++];
					for(int x : adjl[t]) {
						if(bfs[x] - 1 > bfs[t]){ 
							bfs[x] = bfs[t] + 1;
							q[qptr++] = x;
						}
					}
				}
				int lo = 0, hi = n;
				while(lo!=hi){
			        int mid = (lo+hi)/2;
			        if (get(bfs, store, mid, num, money)) {
			            hi = mid;
			        } else {
			            lo = mid + 1;
			        }
			    }
			    if(lo == n) {
			    	pw.println(-1);
			    }
			    else{
			    	pw.println(lo);
			    }
			}
		}
		boolean get(int[] dist, tup[] stores, int a, int need, int goal) {
			int ptr = 0;
			long sum = 0;
			while(need > 0 && ptr < stores.length) {
				if(dist[stores[ptr].a] <= a){
					if(need > stores[ptr].b) {
						sum += 1l * stores[ptr].b * stores[ptr].c;
						need -= stores[ptr].b;
					}
					else{
						sum += 1l * need * stores[ptr].c;
						need = 0;
					}
				}
				ptr++;
			}
			return need == 0 && sum <= goal;
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
			return Integer.compare(c,o.c);
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