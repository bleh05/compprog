
// Problem : D. Vika and Segments
// Contest : Codeforces - Codeforces Round #337 (Div. 2)
// URL : https://codeforces.com/contest/610/problem/D
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
			long sum = 0; 
			HashMap<Integer, ArrayList<tup>> horz = new HashMap<>();
			HashMap<Integer, ArrayList<tup>> vert = new HashMap<>();
			int n = sc.nextInt();
			tup[] arr = new tup[n];
			for(int i = 0; i < n; i++) {
				int x1 = sc.nextInt();
				int y1 = sc.nextInt();
				int x2 = sc.nextInt();
				int y2 = sc.nextInt();
				int a = Math.min(x1, x2);
				int b = Math.max(x2, x1);
				int c = Math.min(y1, y2);
				int d = Math.max(y2, y1);
				x1 = a; x2 = b; y1 = c; y2 = d;
				tup th = new tup(x1, y1, x2, y2);
				if(x1 == x2) {
					if(!vert.containsKey(x1)) {
						vert.put(x1, new ArrayList<>());
					}
					vert.get(x1).add(th);
				}
				else {
					if(!horz.containsKey(y1)) {
						horz.put(y1, new ArrayList<>());
					}
					horz.get(y1).add(th);
				}
			}
			ArrayList<event> evnt = new ArrayList<>();
			TreeSet<Integer> yvals = new TreeSet<Integer>();
			for(ArrayList<tup> x : vert.values()) {
				Collections.sort(x, new compy()); 
				tup curr = x.get(0);
				for(int i = 1; i < x.size(); i++) {
					if(curr.y2 + 1 >= x.get(i).y1) {
						curr.y2 = Math.max(curr.y2, x.get(i).y2);
					}
					else{
						evnt.add(new event(curr.x1, curr.y1, curr.y2, 1));
						sum += curr.y2 - curr.y1 + 1;
						yvals.add(curr.y1);
						yvals.add(curr.y2);
						curr = x.get(i);
					}
				}
				evnt.add(new event(curr.x1, curr.y1, curr.y2, 1));
				yvals.add(curr.y1);
				yvals.add(curr.y2);
				sum += curr.y2 - curr.y1 + 1;
			}
			for(ArrayList<tup> x : horz.values()) {
				Collections.sort(x, new compx()); 
				tup curr = x.get(0);
				yvals.add(curr.y1);
				for(int i = 1; i < x.size(); i++) {
					if(curr.x2 + 1 >= x.get(i).x1) {
						curr.x2 = Math.max(curr.x2, x.get(i).x2);
					}
					else{
						evnt.add(new event(curr.x1, curr.y1, 1, 0));
						evnt.add(new event(curr.x2, curr.y2, -1, 2));
						sum += curr.x2 - curr.x1 + 1;
						curr = x.get(i);
					}
				}
				evnt.add(new event(curr.x1, curr.y1, 1, 0));
				evnt.add(new event(curr.x2, curr.y2, -1, 2));
				sum += curr.x2 - curr.x1 + 1;
			}
			HashMap<Integer, Integer> compry = new HashMap<>();
			int k = 0;
			for(int c : yvals) {
				compry.put(c, k++);
			}
			Collections.sort(evnt);
			bit b = new bit(300000);
			for(event x : evnt) {
				if(x.type == 2) {
					int c = compry.get(x.v1);
					b.add(c, -1);
				}
				else if(x.type == 1) {
					int c = compry.get(x.v1);
					int d = compry.get(x.v2);
					sum -= b.sum(d, c);
				}
				else {
					int c = compry.get(x.v1);
					b.add(c, 1);
				}
			}
			pw.println(sum);
		}
		class event implements Comparable<event> {
			int x;
			int v1, v2;
			int type;
			event(int x, int v1, int v2, int type) {
				this.x = x;
				this.v1 = v1; 
				this.v2 = v2;
				this.type = type;
			}
			public int compareTo(event o) {
				return x == o.x ? Integer.compare(type, o.type) : Integer.compare(x, o.x);
			}
		}	
		class compx implements Comparator<tup> {
			compx(){}
			@Override
			public int compare(tup a, tup b) {
				return Integer.compare(a.x1, b.x1);
			}
		}
		class compy implements Comparator<tup> {
			compy(){}
			@Override
			public int compare(tup a, tup b) {
				return Integer.compare(a.y1, b.y1);
			}
		}
	}
	static class bit { 
		int n;
		int[] bit;
		public bit(int n) {
			this.n=n;
			bit=new int[n+1];
		}
		void add(int ind, int c) {
			for(; ind<n;ind|=(ind+1)) {
				bit[ind]+=c;
			}
		}
		int sum(int r) {
			int out =0;
			for(;r>=0;r=(r&(r+1))-1) {
				out+=bit[r];
			}
			return out;
		}
		int sum(int r, int l) {
			return sum(r)-sum(l-1);
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
		int x1, y1, x2, y2;
		tup(int x1,int y1, int x2, int y2){
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
		@Override
		public int compareTo(tup o){
			return Integer.compare(1, 1);
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