
// Problem : E. Vasya's Function
// Contest : Codeforces - Educational Codeforces Round 26
// URL : https://codeforces.com/contest/837/problem/E
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
			long a = sc.nextLong();
			long b=  sc.nextLong();
			HashMap<Long, Integer> factors = new HashMap<>();
			for(long i = 2; i * i <= a; i++) {
				if(a%i == 0) {
					factors.put(i, 0);
					while(a % i == 0) {
						a /= i;
						factors.put(i, factors.get(i) + 1);
					}
				}
			}
			if(a > 1) {
				factors.put(a, factors.getOrDefault(a, 0) + 1);
			}
			//pw.println(factors);
			long sum = 0;
			long c = 1;
			while(b > 0) {
				long min = Math.max(1, b);
				long d = 1;
				for(long x : factors.keySet()) {
					long rem = b - (b/(c*x)) * c*x;
					if(min > rem) {
						d = x;
						min = rem;
					}
				}
				if(d > 1) {
					factors.put(d, factors.get(d) - 1);
					if(factors.get(d) == 0) {
						factors.remove(d);
					}
				}
				b -= min;
				sum += min / c;
				c *= d;
				//pw.println(b + " " + c);
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