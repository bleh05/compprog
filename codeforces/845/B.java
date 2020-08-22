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
			String str = sc.nextLine();
			int diff = str.charAt(4) + str.charAt(5) + str.charAt(3) - str.charAt(0) - str.charAt(1) - str.charAt(2);
			int[] dec1 = new int[6];
			int[] inc1 = new int[6];
			dec1[0] = str.charAt(0) - '0';
			dec1[1] = str.charAt(1) - '0';
			dec1[2] = str.charAt(2) - '0';
			inc1[0] = -str.charAt(0) + '9';
			inc1[1] = -str.charAt(1) + '9';
			inc1[2] = -str.charAt(2) + '9';
			inc1[3] = str.charAt(3) - '0';
			inc1[4] = str.charAt(4) - '0';
			inc1[5] = str.charAt(5) - '0';
			dec1[3] = -str.charAt(3) + '9';
			dec1[4] = -str.charAt(4) + '9';
			dec1[5] = -str.charAt(5) + '9';
			Arrays.sort(dec1);
			Arrays.sort(inc1);
			if(diff == 0) {
				pw.println(0);
			}
			else if(diff > 0) {
				int sum = 0;
				for(int i = 5; i >= 0; i--) {
					sum += inc1[i];
					if(sum >= diff) {
						pw.println(6 - i);
						return;
					}
				}
			}
			else {
				diff *= -1;
				int sum = 0;
				for(int i = 5; i >= 0; i--) {
					sum += dec1[i];
					if(sum >= diff) {
						pw.println(6 - i);
						return;
					}
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