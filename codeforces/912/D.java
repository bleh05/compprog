
// Problem : D. Fishes
// Contest : Codeforces - Codeforces Round #456 (Div. 2)
// URL : https://codeforces.com/contest/912/problem/D
// Memory Limit : 256 MB
// Time Limit : 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

import java.io.*;
import java.util.*;

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
		int n; int m; int k;
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			int r = sc.nextInt();
			double ev = 0;
			PriorityQueue<Long> pq = new PriorityQueue<>(500000, new comp(n, m));
			int qpt = 0;
			int qpop = 0;
			HashSet<Long> vis = new HashSet<Long>();
			pq.add(100004l * (n / 2) + m / 2);
			vis.add(100004l * (n / 2) + m / 2);
			if(n % 2 == 0 && m % 2 == 0){
				pq.add(100004l * (n / 2 - 1) + m / 2);
				pq.add(100004l * (n / 2) + m / 2 - 1);
				pq.add(100004l * (n / 2 - 1) + m / 2 - 1);
				vis.add(100004l * (n / 2 - 1) + m / 2);
				vis.add(100004l * (n / 2) + m / 2 - 1);
				vis.add(100004l * (n / 2 - 1) + m / 2 - 1);
			}
			else if(n % 2 == 0){
				pq.add(100004l * (n / 2 - 1) + m / 2);
				vis.add(100004l * (n / 2 - 1) + m / 2);
				
			}
			else if(m % 2 == 0) {
				pq.add(100004l * (n / 2 - 1) + m / 2);
				vis.add(100004l * (n / 2 - 1) + m / 2);
			}
			while(qpop < r){
				long coord = pq.poll();
				qpop++;
				long x = coord / 100004;
				long y = coord % 100004;
				//pw.println(x + " " + y + " " + (Math.min(n - k, x) - Math.max(0, x - k + 1) + 1) *
				//	(Math.min(m - k, y) - Math.max(0, y - k) + 1));
				ev += 1l * (Math.min(n - k, x) - Math.max(0, x - k + 1) + 1l) *
					(Math.min(m - k, y) - Math.max(0, y - k + 1) + 1l);
				if(x < n - 1 && !vis.contains(100004l * (x + 1) + y)){
					pq.add(100004l * (x + 1) + y);
					vis.add(100004l * (x + 1) + y);
				}
				if(x > 0 && !vis.contains(100004l * (x - 1) + y)){
					pq.add(100004l * (x - 1) + y);
					vis.add(100004l * (x - 1) + y);
				}
				if(y < m - 1 && !vis.contains(100004l * x + y + 1)){
					pq.add(100004l * x + y + 1);
					vis.add(100004l * x + y + 1);
				}
				if(y > 0 && !vis.contains(100004l * x + y - 1)){
					pq.add(100004l * x + y - 1);
					vis.add(100004l * x + y - 1);
				}
			}
			ev /= 1l * (n - k + 1) * (m - k + 1);
			pw.println(ev);
		}
		long f(long x, long y){
			return (Math.min(n - k, x) - Math.max(0, x - k + 1) + 1) * (Math.min(m - k, y) - Math.max(0, y - k + 1) + 1);
		}
		class comp implements Comparator<Long>{
			int a, b;
			comp(int a, int b){
				this.a=a;
				this.b=b;
			}
			@Override
			public int compare(Long a, Long b){
				long ax = a / 100004;
				long ay = a % 100004;
				long bx = b / 100004;
				long by = b % 100004;
				return f(bx, by) == f(ax, ay) ? 1 : (Long.compare(f(bx, by), f(ax, ay)));
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
			return Integer.compare(o.b,b);
		}
	}
	static void shuffle(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	static void shuffle(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
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