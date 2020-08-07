
// Problem : B. Applejack and Storages
// Contest : Codeforces - Codeforces Round #662 (Div. 2)
// URL : https://codeforces.com/contest/1393/problem/B
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
			int[] freq = new int[100002];
			for(int i = 0; i < n; i++) {
				freq[sc.nextInt()]++;
			}
			TreeSet<tup> ts = new TreeSet<tup>();
			tup[] arr = new tup[100002];
			for(int i = 0; i < 100002; i++) {
				ts.add(arr[i] = new tup(i, freq[i]));
			}
			int q = sc.nextInt();
			for(int i = 0; i < q; i++) {
			 	String str = sc.next();
			 	int d = sc.nextInt();
			 	if(str.charAt(0) == '+') {
			 		ts.remove(arr[d]);
			 		arr[d].b++;
			 		ts.add(arr[d]);
			 	}
			 	else {
			 		ts.remove(arr[d]);
			 		arr[d].b--;
			 		ts.add(arr[d]);
			 	}
				tup a = ts.first();
				tup b = ts.higher(a);
				tup c = ts.higher(b);
				if(a.b >= 4 && b.b >= 2 && c.b >= 2) {
					pw.println("YES");
				}
				else if(a.b >= 6 && b.b >= 2) {
					pw.println("YES");
				}
				else if(a.b >= 4 && b.b >= 4) {
					pw.println("YES");
				}
				else if(a.b >=8) {
					pw.println("YES");
				}
				else {
					pw.println("NO");
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
		int a, b;
		tup(int a,int b){
			this.a=a;
			this.b=b;
		}
		@Override
		public int compareTo(tup o){
			return b == o.b ? Integer.compare(a, o.a) : Integer.compare(o.b,b);
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