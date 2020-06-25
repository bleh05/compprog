
// Problem : C. Tokitsukaze and Duel
// Contest : Codeforces - Codeforces Round #573 (Div. 1)
// URL : https://codeforces.com/contest/1190/problem/C
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
			int k = sc.nextInt();
			int[] arr = new int[n];
			String str = sc.nextLine();
			for(int i = 0; i < n; i++) {
				arr[i] = str.charAt(i);
			}
			int[] pref1 = new int[n+1];
			int[] pref2 = new int[n+1];
			int[] pref3 = new int[n+1];
			int[] pref4 = new int[n+1];
			for(int i = 0; i < n; i++) {
				if(arr[i] == '0') {
					pref1[i+1]++;
				}
				else{
					pref2[i+1]++;
				}
				pref1[i+1] += pref1[i];
				pref2[i+1] += pref2[i];
			}
			for(int i = n; i > 0; i--) {
				if(arr[i - 1] == '0') {
					pref3[i - 1]++;
				}
				else{
					pref4[i - 1]++;
				}
				pref3[i - 1] += pref3[i];
				pref4[i - 1] += pref4[i];
			}
			for(int i = 0; i + k < n; i++) {
				if(pref1[i] + pref3[i + k] + k >= n || pref2[i] + pref4[i + k] + k >= n) {
					pw.println("tokitsukaze");
					return;
				}
			}
			for(int i = n - 1; i >= 0; i--) {
				if(i - k < 0) {
					pw.println("tokitsukaze");
					return;
				}
				if(i < n - 1 && arr[i+1] != arr[i]) {
					break;
				}
			}
			if(k == 1 || n > k * 2) {
				pw.println("once again");
				return;
			}
			int len = n - k - 1;
			for(int i = 1; i < len; i++) {
				if(arr[i] != arr[i-1] || arr[n - i] != arr[n - i - 1]) {
					pw.println("once again");return;
				}
			}
			if(arr[0] == arr[n - 1] || arr[len - 1] == arr[len] || arr[n - len] == arr[n - len - 1]) {
				pw.println("once again");return;
			}
			pw.println("quailty");
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