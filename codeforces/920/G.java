
// Problem : G. List Of Integers
// Contest : Codeforces - Educational Codeforces Round 37 (Rated for Div. 2)
// URL : https://codeforces.com/contest/920/problem/G
// Memory Limit : 256 MB
// Time Limit : 5000 ms
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

		int[] pfac = new int[7];
		int[] stuffs = new int[1<<7];
		
		int ptr = 0;
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			stuffs = new int[1<<7];
			pfac = new int[7];
			ptr = 0;
			for(int i = 2; i * i <= m; i++) {
				if(m % i == 0) {
					pfac[ptr++] = i;
					while(m % i == 0) {
						//System.out.println("ASDDSD");
						m /= i;
					}
				}
			}
			if(m > 1) {
				pfac[ptr++] = m;
			}
			for(int i = 1; i < 1<<7; i++) {
				int prod = 1;
				int rr = 0;
				for(int j = 0; j < 7; j++) {
					if((i & (1<<j)) > 0) {
						rr++;
						prod *= pfac[j];
					}
				}
				if(prod > 0) {
					stuffs[i] = prod * ((rr % 2) * 2 - 1);
				}
			}
			long z = get(n);
			pw.println(search(z + k));
			
		}
		 long search(long k){
			long lo = 1, hi = 1000000000000000000l;
		    for(int i=0;i<63;i++) {
		        long mid = (lo+hi)/2;
		        if (get(mid) >= k) {
		            hi = mid;
		        } else {
		            lo = mid + 1;
		        }
		    }
		    if (get(Long.min(lo, hi)) >= k) {
		        return Long.min(lo, hi);
		    } else {
		        return Long.max(lo, hi);
		    }
		}
		long get(long a) {
			long c = 0;
			for(int i = 1; i < 1<<7; i++) {
				if(stuffs[i] != 0) {
					c += a / stuffs[i];
				}
			}
			return a - c;
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