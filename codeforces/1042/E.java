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
			tup[] arr = new tup[n * m];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					arr[i * m + j] = new tup(i, j, sc.nextInt());
				}
			}
			Arrays.sort(arr);
			long[] sum = new long[6];
			long mod = 998244353;
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			long[] subsum = new long[6];
			for(int i = 0; i < n * m; i++) {
				if(i > 0 && arr[i - 1].c != arr[i].c) {
					sum[0] += subsum[0];
					sum[1] += subsum[1];
					sum[2] += subsum[2];
					sum[3] += subsum[3];
					sum[4] += subsum[4];
					sum[5] += subsum[5];
					sum[0] %= mod;
					sum[1] %= mod;
					sum[2] %= mod;
					sum[3] %= mod;
					sum[4] %= mod;
					sum[5] %= mod;
					Arrays.fill(subsum, 0);
				}
				long ns = binpow(sum[5], mod - 2, mod);
				
				long ev; 
				if(ns == 0) ev = 0;
				else {
					ev = sum[0] * ns % mod;
					ev += arr[i].a * arr[i].a;
					ev += arr[i].b * arr[i].b;
					ev %= mod;
					ev += sum[3] * ns % mod;
					ev += sum[4] * ns % mod;
					ev %= mod;
					ev -= 2 * sum[1] * arr[i].a % mod * ns % mod;
					if(ev < 0) ev += mod;
					ev -= 2 * sum[2] * arr[i].b % mod * ns % mod;
					if(ev < 0) ev += mod;
					ev %= mod;
				}
				subsum[0] += ev;
				subsum[0] %= mod;
				subsum[1] += arr[i].a;
				subsum[1] %= mod;
				subsum[2] += arr[i].b;
				subsum[2] %= mod;
				subsum[3] += arr[i].a * arr[i].a;
				subsum[3] %= mod;
				subsum[4] += arr[i].b * arr[i].b;
				subsum[4] %= mod;
				subsum[5]++;
				
				if(arr[i].a == x && arr[i].b == y) {
					pw.println(ev);
					return;
				}
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
		int a, b, c;
		tup(int a,int b, int c){
			this.a=a;
			this.b=b;
			this.c = c;
		}
		@Override
		public int compareTo(tup o){
			return Integer.compare(c, o.c);
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