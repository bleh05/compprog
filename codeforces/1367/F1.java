
// Problem : F2. Flying Sort (Hard Version)
// Contest : Codeforces - Codeforces Round #650 (Div. 3)
// URL : https://codeforces.com/contest/1367/problem/F2
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
			int[] arr = new int[n];
			tup[] arr2 = new tup[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				arr2[i] = new tup(i, arr[i]);
			}
			Arrays.sort(arr2);
			tup max = new tup(inf, 0);
			TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
			for(int i = 0; i < n; i++) {
				if(!tm.containsKey(arr2[i].b)) {
					tm.put(arr2[i].b, new ArrayList<>());
				}
				tm.get(arr2[i].b).add(arr2[i].a);
			}
			for(ArrayList<Integer> x : tm.values()) {
				Collections.sort(x, Collections.reverseOrder());
			}
			int ptr = 0;
			int max2 = 0;
			TreeSet<Integer> ts = new TreeSet<Integer>();
			for(Integer x : tm.keySet()) {
				ArrayList<Integer> kk = tm.get(x);
				int cct = 0;
				for(int i : kk) {
					if(ts.size() == 0 || i > ts.lower(inf)) {
						cct++;
					}
				}
				max2 = Math.max(max2, cct + ts.size());
				int lowest = kk.get(kk.size() - 1);
				while(ptr < n && ts.size() != 0 && ts.lower(inf) > lowest) {
					int c = arr2[ptr].a;
					ts.remove(c);
					int high;
					if(ts.size() > 0) { 
						high = ts.lower(inf);
					}
					else{
						high = inf;
					}
					for(; cct < kk.size(); cct++) {
						if(kk.get(cct) < high) break; 
					}
					max2 = Math.max(max2, cct + ts.size());
					ptr++;
				}
				for(int i : kk) {
					ts.add(i);
				}
				max2 = Math.max(max2, ts.size());
			}
			pw.println(n - max2);
			
		}
		class comp implements Comparator<tup> {
			comp(){}
			@Override
			public int compare(tup a, tup b) {
				return Integer.compare(a.a, b.a);
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
			return b == o.b ? Integer.compare(o.a, a) : Integer.compare(b, o.b);
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