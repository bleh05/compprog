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
			int n = sc.nextInt(); int end = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int ptr1 = 0;
		int ptr2 = n - 1;
		PriorityQueue<tup> pq = new PriorityQueue<tup>();
		double speed1 = 1.0;
		double speed2 = 1.0;
		double currpos1 = 0;
		double currpos2 = end;
		pq.add(new tup(arr[ptr1] / speed1, 1));
		pq.add(new tup((currpos2 - arr[ptr2]) / speed2, 2));
		double time1 = 0.0;
		double time2 = 0.0;
		
		while(!pq.isEmpty()) {
			tup c = pq.poll();
			if(c.b == 2) {
				speed2 += 1.0;
				currpos2 = arr[ptr2];
				time2 = c.a;
				ptr2--;
				if(ptr2 >= 0)
				pq.add(new tup((currpos2 - arr[ptr2]) / speed2 + time2, 2));
			}
			else {
				speed1 += 1.0;
				currpos1 = arr[ptr1];
				time1 = c.a;
				ptr1++;
				if(ptr1 < n)
				pq.add(new tup((arr[ptr1] - currpos1) / speed1 + time1, 1));
			}
			if(ptr1 == ptr2 + 1) {
				if(time2 < time1) {
					currpos2 -= (time1 - time2) * speed2;
					time2 = time1;
				}
				else {
					currpos1 += (time2 - time1) * speed1;
					time1 = time2;
				}
				double l = 0.0; double r = 1e13;
				while(r - l > 1e-7) {
					double mid = (l + r) / 2.0;
					if(currpos1 + mid * speed1 < currpos2 - mid * speed2) {
						l = mid;
					}
					else {
						r = mid;
					}
				}
				pw.println(time1 + l);
				break;
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
		double a; int b;
		tup(double a,int b){
			this.a=a;
			this.b=b;
		}
		@Override
		public int compareTo(tup o){
			return a == o.a ? Integer.compare(b,o.b) : Double.compare(a, o.a);
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