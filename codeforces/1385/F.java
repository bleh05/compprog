
// Problem : F. Removing Leaves
// Contest : Codeforces - Codeforces Round #656 (Div. 3)
// URL : https://codeforces.com/contest/1385/problem/F
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
			int m = sc.nextInt();
			List<Integer>[] adjl = Stream.generate(ArrayList::new).limit(n).toArray(List[]::new);
			int[] leac = new int[n];
			for(int i = 0; i < n - 1; i++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				adjl[a].add(b);
				adjl[b].add(a);
			}
			if(m == 1) {
				pw.println(n - 1);
				return;
			}
			boolean[] isl = new boolean[n];
			ArrayDeque<Integer> adq = new ArrayDeque<>();
			for(int i = 0; i < n; i++) {
				if(adjl[i].size() == 1) {
					isl[i] = true;
					leac[adjl[i].get(0)]++;
					if(leac[adjl[i].get(0)] == m) {
						adq.add(adjl[i].get(0));
					}
				}
			}
			int sum = 0;
			while(!adq.isEmpty()) {
				int t = adq.poll();
				sum += leac[t] / m;
				leac[t] %= m;
				int leaf = -1;
				if(leac[t] == 0) {
					isl[t] = true;
					for(int i : adjl[t]) {
						if(!isl[i]) {
							if(leaf != -1){ 
								isl[t] = false;
								leaf = -1;
								break;
							}
							leaf = i;
						}
					} 
					if(leaf > -1) {
						leac[leaf]++;
						if(leac[leaf] == m) adq.add(leaf);
					}
				}
			}
			pw.println(sum);
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