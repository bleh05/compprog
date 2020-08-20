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
			int m = sc.nextInt();
			double[] arr = new double[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextDouble();
			}
			List<Integer>[] iter = Stream.generate(ArrayList::new).limit(n+1).toArray(List[]::new);
			double[] dp = new double[1<<n];
			dp[0] = 1;
			for(int i = 0; i < (1<<n); i++) {
                double sum = 0;
                boolean bad = false;
                for (int j = 0; j < n; j++) {
					if((i >> j & 1) == 0) {
						sum += arr[j];
					}
					else if (arr[j] == 0) {
						bad = true;
						break;
					}
				}
				if (bad) {
					continue;
				}
				for(int j = 0; j < n; j++) {
					if((i >> j & 1) == 1) {
						dp[i] += dp[i - (1 << j)] * arr[j] / (arr[j] + sum);
					}
				}
			}
			double[] result = new double[n];
			int cc = n;
			for(double x : arr) {
				if(x == 0) cc--;
			}
			int ctr = Math.min(m, cc);
			
            for (int i = 0; i < (1 << n); i++) {
                if (Integer.bitCount(i) == ctr) {
                    for (int j = 0; j < n; j++) {
                        if ((i >> j & 1) == 1) {
                            result[j] += dp[i];
                        }
                    }
                }
            }
			for(double x : result) {
				pw.print(x + " ");
			}
			pw.println();
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