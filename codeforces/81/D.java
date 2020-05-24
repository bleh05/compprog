
// Problem : D. Polycarp's Picture Gallery
// Contest : Codeforces - Yandex.Algorithm Open 2011: Qualification 1
// URL : https://codeforces.com/contest/81/problem/D
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
			tup[] arr = new tup[m];
			int c = 0;
			int freq[] = new int[m];
			for(int i = 0; i < m; i++) {
				arr[i] = new tup(i + 1, sc.nextInt());
				c += arr[i].b;
				freq[i] = arr[i].b;
			}
			if(c < n || m <= 2 && n % 2 == 1) {
				pw.println(-1);
				return;
			}
			Arrays.sort(arr);
			int[] x = new int[n];
			int ptr = 0;
			loop:
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < arr[i].b; j++) {
					if(ptr >= n) {
						break loop;
					}
					x[ptr] = arr[i].a;
					freq[arr[i].a - 1]--;
					ptr += 2;
				}
			}
			ptr = n % 2;
			
			loop2:
			for(int i = m - 1; i >= 0; i--) {
				for(int j = 0; j < arr[i].b; j++) {
					if(ptr >= n) {
						break loop2;
					}
					x[n - ptr - 1] = arr[i].a;
					freq[arr[i].a - 1]--;
					ptr += 2;
				}
			}
			if(x[0] == x[n - 1]) {
				for(int i = 0; i < m; i++) {
					if(x[n - 2] != i + 1 && x[0] != i + 1 && x[i] > 0) {
						x[n - 1] = i + 1;
						break;
					}
					if(i == m - 1) {
						pw.println(-1);
						return;
					}
				}
			}
			for(int i = 1; i < n; i ++) {
				if(x[i] == x[i - 1]) {
					pw.println(-1);
					return;
				}
			}
			
			for(int y : x) {
				pw.print(y+ " ");
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
		int a, b;
		tup(int a,int b){
			this.a=a;
			this.b=b;
		}
		@Override
		public int compareTo(tup o){
			return Integer.compare(b,o.b);
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