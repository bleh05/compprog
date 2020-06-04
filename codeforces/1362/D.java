
// Problem : D. Johnny and Contribution
// Contest : Codeforces - Codeforces Round #647 (Div. 2) - Thanks, Algo Muse!
// URL : https://codeforces.com/contest/1362/problem/D
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
			List<Integer>[] adjl = Stream.generate(ArrayList::new).limit(n).toArray(List[]::new);
			for(int i = 0; i < m; i++) {
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				adjl[a].add(b);
				adjl[b].add(a);
			}
			List<Integer>[] groups = Stream.generate(ArrayList::new).limit(n).toArray(List[]::new);
			int[] groups2 = new int[n];
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int i = 0; i < n; i++) {
				int k = 0;
				groups[k=sc.nextInt() - 1].add(i);
				groups2[i] = k;
				map.put(i, k);
			}
			for(int i = 0; i < n; i++) {
				if(groups[i].size() == 0) continue;
				for(int j : groups[i]) {
					boolean fuf = i==0;
					HashSet<Integer> hs = new HashSet<Integer>();
					for(int x : adjl[j]) {
						if(groups2[x] == i) {
							pw.println(-1);
							return;
						}
						int z;
						if((z=map.get(x)) < i) {
							hs.add(z);
						}
					}
					if(hs.size() < i) {
						pw.println(-1);
						return;
					}
				}
			}
			for(int i = 0; i < n; i++) {
				for(int x : groups[i]) {
					pw.print(x+1 + " ");
				}
			}
			pw.println();
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