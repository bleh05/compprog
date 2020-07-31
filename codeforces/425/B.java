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
			int k = sc.nextInt();
			int[][] arr;
			if(m > n) {
				n ^= m;
				m ^= n;
				n ^= m;
				arr = new int[n][m];
				for(int i = 0; i < m; i++) {
					for(int j = 0; j < n; j++) {
						arr[j][i] = sc.nextInt();
					}
				}
			}
			else {
				arr = new int[n][m];
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < m; j++) {
						arr[i][j] = sc.nextInt();
					}
				}
			}
			//pw.println(n + " " + m);
			int min = inf;
			if(n <= k && m <= k) {
				for(int i = 0; i < (1<<m); i++) {
					int[] ch = new int[m];
					for(int j = 0; j < m; j++) {
						if((i & (1<<j)) > 0) ch[j] = 1;
					}
					int sum = 0;
					for(int j = 0; j < n; j++) {
						int a = 0;
						for(int l = 0; l < m; l++) {
							a += ch[l] ^ arr[j][l];
						}
						sum += Math.min(m - a, a);
					}
					min = Math.min(sum, min);
				}
			}
			else {
				for(int i = 0; i < n; i++) {
					int[] ch = arr[i];
					int sum = 0;
					for(int j = 0; j < n; j++) {
						int a = 0;
						for(int l = 0; l < m; l++) {
							a += ch[l] ^ arr[j][l];
						}
						sum += Math.min(m - a, a);
					}
					min = Math.min(sum, min);
				}
			}
			if(min <= k) pw.println(min);
			else pw.println(-1);
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