
// Problem : D. The Best Vacation
// Contest : Codeforces - Codeforces Round #645 (Div. 2)
// URL : https://codeforces.com/contest/1358/problem/D
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
		long pref1[];
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			int n = sc.nextInt();
			long k = sc.nextLong();
			long[] arr = new long[2 * n];
			long max = 0; 
			for(int i = 0; i < n; i++) {
				arr[i + n] = arr[i] = sc.nextInt();
			}
			long[] weights = new long[2 * n];
			for(int i = 0; i < 2 * n; i++) {
				weights[i] = arr[i] * (arr[i] + 1) / 2;
			}
			pref1 = new long[2 * n + 1];
			long[] pref2 = new long[2 * n + 1];
			for(int i = 1; i <= 2 * n; i++) {
				pref1[i] = pref1[i - 1] + arr[i - 1];
				pref2[i] = pref2[i - 1] + weights[i - 1];
			}
			int ptr2 = 0;
			for(int i = 1; i <= 2 * n; i++) {
				if(pref1[i] - k <= 0) continue;
				int idx = search(pref1[i] - k);
				long weight = pref2[i] - pref2[idx];
				long rem = k - pref1[i] + pref1[idx];
				weight += sumofR(arr[idx - 1], rem);
				max = Math.max(weight, max);
			}
			pw.println(max);
			
		}
		
		public int search(long a){
			int lo = 1, hi = pref1.length;
		    for(int i=0;i<33;i++) {
		        int mid = (lo+hi)/2;
		        if (pref1[mid] >= a) {
		            hi = mid;
		        } else {
		            lo = mid+1;
		        }
		    }
		    
		    if (pref1[Math.min(lo, hi)] >= a) {
		        return Math.min(lo, hi);
		    } else {
		        return Math.max(lo, hi);
		    }
		}
		
		long sumofR(long st, long amt) {
			if(amt > st) {
				return st * (st + 1) / 2;
			}
			else return st * (st + 1) / 2 - ((st-amt) * (st-amt +1) / 2);
		}
		long sumofL(long st) {
			if(st > 0) {
				return st * (st + 1) / 2;
			}
			return 0;	
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