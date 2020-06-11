
// Problem : B. Shuffle
// Contest : Codeforces - Educational Codeforces Round 89 (Rated for Div. 2)
// URL : https://codeforces.com/contest/1366/problem/B
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
		int t = scan.nextInt();
		//int t = 1;
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
			int x = sc.nextInt();
			int m = sc.nextInt();
			int[] cand = new int[m];
			int[][] bord = new int[m][2];
			for(int i = 0; i < m; i++) {
				bord[i][0] = sc.nextInt(); 
				bord[i][1] = sc.nextInt(); 
			}
			l:
			for(int i = 0; i < m; i++) {
				if(bord[i][0] <= x && x <= bord[i][1]) {
					cand[i]++;
					continue;
				}
				for(int j = 0; j < i; j++) {
					if(cand[j] > 0 && (bord[j][1] >= bord[i][0] && bord[j][0] <= bord[i][1])) {
						cand[i]++;
						continue l;
					}  
				}
			}
			long sum = 0;
			ArrayList<tup> tups = new ArrayList<tup>();
			for(int i = 0; i < m; i++) {
				if(cand[i] == 1) {
					tups.add(new tup(bord[i][0], bord[i][1]));
				}
			}
			tups.add(new tup(x, x));
			Collections.sort(tups);
			long curr = 0;
			long lasty = -1;
			for(tup t : tups) {
				if(lasty < t.a) {
					sum += curr;
					curr = 0;
					curr += (t.b - t.a) + 1;
					lasty = t.b;
				}
				else{
					curr += Math.max(0, t.b - lasty);
					lasty = Math.max(t.b, lasty);
				}
			}
			sum += curr;
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
			return Integer.compare(a,o.a);
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