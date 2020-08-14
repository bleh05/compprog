
// Problem : E. Two Types of Spells
// Contest : Codeforces - Educational Codeforces Round 93 (Rated for Div. 2)
// URL : https://codeforces.com/contest/1398/problem/E
// Memory Limit : 256 MB
// Time Limit : 3500 ms
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
			HashSet<Integer> chx = new HashSet<>();
			int n = sc.nextInt();
			int[][] q = new int[n][2];
			for(int i = 0; i < n; i++) {
				q[i][0] = sc.nextInt();
				q[i][1] = sc.nextInt();
				if(q[i][1] > 0)
				chx.add(q[i][1]);
			}
			ArrayList<Integer> arr = new ArrayList<>();
			arr.addAll(chx);
			Collections.sort(arr);
			HashMap<Integer, Integer> bitc = new HashMap<Integer, Integer>();
			for(int i = 0; i < arr.size(); i++) {
				 bitc.put(arr.get(i), i);
			}
			bit sum = new bit(200003);
			bit num = new bit(200003);
			TreeSet<Integer> t1 = new TreeSet<Integer>();
			TreeSet<Integer> t2 = new TreeSet<Integer>();
			for(int[] x : q) {
				if(x[0] == 0) {
					if(x[1] > 0){
						t1.add(x[1]);
						sum.add(bitc.get(x[1]), x[1]);
						num.add(bitc.get(x[1]), 1);
					}
					else {
						t1.remove(-x[1]);
						sum.add(bitc.get(-x[1]), x[1]);
						num.add(bitc.get(-x[1]), -1);
					}
				}
				if(x[0] == 1) {
					if(x[1] > 0){
						t2.add(x[1]);
						sum.add(bitc.get(x[1]), x[1]);
						num.add(bitc.get(x[1]), 1);
					}
					else {
						t2.remove(-x[1]);
						sum.add(bitc.get(-x[1]), x[1]);
						num.add(bitc.get(-x[1]), -1);
					}
				}
				int l = 0; int r = 200003;
				while(r - l > 1) {
					int mid = (l+r) >> 1;
					if(num.sum(200003, mid) >= t2.size()) {
						l = mid;
					}
					else {
						r = mid - 1;
					}
				}
				if(num.sum(200003, r) >= t2.size()) l = r;
				long ans = sum.sum(200003) + sum.sum(200003, l);
				if(!t2.isEmpty() && !t1.isEmpty() && t2.first() > t1.last()) {
					ans -= t2.first();
					ans += t1.last();
				}
				else if(!t2.isEmpty() && t1.isEmpty()) {
					ans -= t2.first();
				}
				pw.println(ans);
				//pw.println(t1 + " " + t2);
			}
		}
		static class bit { 
			int n;
			long[] bit;
			public bit(int n) {
				this.n=n;
				bit=new long[n+1];
			}
			void add(int ind, long c) {
				for(; ind<n;ind|=(ind+1)) {
					bit[ind]+=c;
				}
			}
			long sum(int r) {
				long out =0;
				for(;r>=0;r=(r&(r+1))-1) {
					out+=bit[r];
				}
				return out;
			}
			long sum(int r, int l) {
				return sum(r)-sum(l-1);
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