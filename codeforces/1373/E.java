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
		solver.init();
		int t = scan.nextInt();
		//int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}
	
	static class Task {
		static final int inf = Integer.MAX_VALUE;
		int[] sumd = new int[700010];
		public void init() {
			for(int i = 0; i < 700010; i++) {
				sumd[i] = sumd(i);
			}
		}
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			int n = sc.nextInt();
			int m = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			if(m == 0) {
				while(n > 9) {
					sb.append(9);
					n -= 9;
				}
				pw.println(n + sb.toString());
			}
			else if(m == 1) {
				if(n % 2 == 0) {
					if(n < 10) {
						pw.println(-1);
						return;
					}
					boolean thing = false;
					int x = (n - 10) / 2;
					if(x > 8) {
						thing = true;
						x -= 8;
					}
					while(x > 9) {
						sb.append(9);
						x -= 9;
					}
					if(thing)
						sb.append(8);
					if(x == 0) {
						pw.println(sb.toString() + '9');return;
					}
					pw.println(x + sb.toString() + '9');
					return;
				}
				else {
					if(n <= 18) {
						pw.println(n / 2);
						return;
					}
					n /= 2;
					if(n % 9 == 0) {
						sb.append(1);
						n--;
						while(n > 9) {
							sb.append(9);
							n -= 9;
						}
						sb.append(8);
						pw.println(sb);
					}
					else {
						
						while(n - 9 > 9) {
							sb.append(9);
							n -= 9;
						}
						n -= 9;
						pw.println((n + 1) + sb.toString() + "8");
					}
				}
			}
			else {
				int c = 0;
				for(int i = 1; i <= m + 1; i++)  {
					c += sumd[i];
				}
				if(c == n) {
					pw.println(1);
					return;
				}
				if(c - sumd[m + 1] == n) {
					pw.println(0);
					return;
				}
				for(int i = 2; i <= 699997; i++) {
					c -= sumd[i - 1];
					c += sumd[i + m];
					if(c == n) {
						pw.println(i);
						return;
					}
				}
				pw.println(-1);
			}
		}
		int sumd(int a) {
			int sum = 0;
			while(a > 0) {
				sum += a % 10;
				a /= 10;
			}
			return sum;
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