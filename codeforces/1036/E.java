
// Problem : E. Covered Points
// Contest : Codeforces - Educational Codeforces Round 50 (Rated for Div. 2)
// URL : https://codeforces.com/contest/1036/problem/E
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
			long sum = 0;
			Line[] arr = new Line[n];
			for(int i = 0; i < n; i++) {
				arr[i] = new Line(new Point(sc.nextInt(), sc.nextInt()), new Point(sc.nextInt(), sc.nextInt()));
				sum += gcd(Math.abs(arr[i].s.x - arr[i].e.x), Math.abs(arr[i].s.y - arr[i].e.y)) + 1;
				//pw.println(gcd(Math.abs(arr[i].s.x - arr[i].e.x), Math.abs(arr[i].s.y - arr[i].e.y)) + 1);
				TreeSet<Point> ts = new TreeSet<>();
				for(int j = 0; j < i; j++) {
					Point p = findIntersection(arr[i], arr[j]);
					if(p == null) continue;
					long left1 = Math.min(arr[i].s.x, arr[i].e.x);
					long right1 = Math.max(arr[i].s.x, arr[i].e.x);
					long left2 = Math.min(arr[j].s.x, arr[j].e.x);
					long right2 = Math.max(arr[j].s.x, arr[j].e.x);
					if(p.x < Math.max(left1, left2) || p.x > Math.min(right1, right2)) {
						continue;
					}
					left1 = Math.min(arr[i].s.y, arr[i].e.y);
					right1 = Math.max(arr[i].s.y, arr[i].e.y);
					left2 = Math.min(arr[j].s.y, arr[j].e.y);
					right2 = Math.max(arr[j].s.y, arr[j].e.y);
					if(p.y < Math.max(left1, left2) || p.y > Math.min(right1, right2)) {
						continue;
					}
					ts.add(p);
				}
				sum -= ts.size();
			}
			pw.println(sum);
		}
		
	}
	static long gcd(long a, long b) {
		return a == 0 ? b : gcd(b % a, a);
	}
	static class Point implements Comparable<Point> {
        long x, y;
 
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
 
        @Override
        public String toString() {
            return String.format("{%d, %d}", x, y);
        }
        
        @Override
        public int compareTo(Point o) {
        	return o.x == x ? Long.compare(y, o.y) : Long.compare(x, o.x);
        }
    }
 
    static class Line {
        Point s, e;
 
        Line(Point s, Point e) {
            this.s = s;
            this.e = e;
        }
    }
 
    static Point findIntersection(Line l1, Line l2) {
    	if(l1.e.compareTo(l2.e) == 0) {
    		return l1.e;
    	}
    	if(l1.e.compareTo(l2.s) == 0) {
    		return l1.e;
    	}
    	if(l1.s.compareTo(l2.s) == 0) {
    		return l1.s;
    	}
    	if(l1.s.compareTo(l2.e) == 0) {
    		return l1.s;
    	}
        long a1 = l1.e.y - l1.s.y;
        long b1 = l1.s.x - l1.e.x;
        long c1 = a1 * l1.s.x + b1 * l1.s.y;
 
        long a2 = l2.e.y - l2.s.y;
        long b2 = l2.s.x - l2.e.x;
        long c2 = a2 * l2.s.x + b2 * l2.s.y;
 
        long delta = a1 * b2 - a2 * b1;
        if(delta == 0 || (b2 * c1 - b1 * c2) % delta != 0 || (a1 * c2 - a2 * c1) % delta != 0) {
        	return null;
        }
        return new Point((b2 * c1 - b1 * c2) / delta, (a1 * c2 - a2 * c1) / delta);
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