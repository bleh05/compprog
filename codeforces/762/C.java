
// Problem : C. Two strings
// Contest : Codeforces - Educational Codeforces Round 17
// URL : https://codeforces.com/contest/762/problem/C
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
			String str = sc.nextLine();
			String str2 = sc.nextLine();
			int[] pref1 = new int[str2.length() + 1];
			int[] pref2 = new int[str2.length() + 1];
			
			int n = str2.length();
			int ctr = 0;
			pref1[0] = -1;
			for(int i = 1; i <= n; i++) {
				while(ctr < str.length() && str.charAt(ctr) != str2.charAt(i - 1)) {
					ctr++;
				}
				ctr = Math.min(ctr, str.length());
				pref1[i] = ctr++;
			} 
			pref2[0] = str.length();
			ctr = str.length() - 1;
			for(int i = 1; i <= n; i++) {
				while(ctr > -1 && str.charAt(ctr) != str2.charAt(n - i)) {
					ctr--;
				}
				ctr = Math.max(ctr, -1);
				pref2[i] = ctr--;
			}
			int ctr2 = n;
			int max = 0;
			int l = 0;
			int r = 0;
			for(int i = 0; i <= n; i++) {
				ctr2 = Math.min(n - i, ctr2);
				while(ctr2 != -1 && pref2[ctr2] <= pref1[i]) {
					ctr2--;
				}
				if(max < ctr2 + i && ctr2 != -1 && pref2[ctr2] != -1 && pref1[i] != str.length()) {
					l = i;
					r = ctr2;
					max = l + r;
				}
			}
			if(l == 0 && r == 0) {
				pw.println('-');
			}
			pw.println(str2.substring(0, l) + str2.substring(n - r));
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