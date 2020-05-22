
// Problem : D. Perfect Groups
// Contest : Codeforces - Codeforces Round #480 (Div. 2)
// URL : https://codeforces.com/contest/980/problem/D
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
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int[] reduction = new int[n];
			for(int i = 0; i < n; i++) {
				int t = arr[i];
				int z = 1;
				int k = 2;
				while(k <= Math.sqrt(Math.abs(t))) {
					int ctr = 0;
					while(t % k == 0){
						t /= k; ctr++;
					}
					if((ctr & 1) == 1) {
						z*=k;
					}
					k++;
				}
				if(t != 1) {
					z*=t;
				}
				reduction[i] = z;
			}
			HashMap<Integer, Integer> hm = new HashMap<>();
			int[] last = new int[n];
			Arrays.fill(last, -1);
			for(int i = 0; i < n; i++) {
				if(hm.containsKey(reduction[i])) {
					last[i] = hm.get(reduction[i]);
				}
				hm.put(reduction[i], i);
			}
			int ans[] = new int[n];
			for(int i = 0; i < n; i++) {
				int k = -1;
				boolean onlyc0 = true;
				for(int j = i; j < n; j++) {
					if(last[j] < i && reduction[j] != 0 && !onlyc0 || k == -1 ) {
						k++;
					}
					if(reduction[j] != 0){
						onlyc0 = false;
					}
					ans[k]++;
				}
			}
			for(int x : ans) {
				pw.print(x + " ");
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