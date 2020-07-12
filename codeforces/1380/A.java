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
			tup[] arr = new tup[n];;
			int ind = 0;
			for(int i = 0; i < n; i++) {
				arr[i] = new tup(i, sc.nextInt());
			}
			Arrays.sort(arr);
			int[] arrs = new int[n + 2];
			for(int i = 0; i < n; i++) {
				arrs[arr[i].a] = 1;
				int ind1 = -1, ind2 = -1;
				for(int k = 0; k < n + 2; k++) {
					if(arrs[k] == 1 && k < arr[i].a) {
						ind1 = k + 1;
					}
					if(arrs[k] == 1 && k > arr[i].a) {
						ind2 = k + 1;
					}
				}
				if(ind1 > 0 && ind2 > 0) {
					pw.println("YES\n" + ind1 + " " + (arr[i].a + 1) + " " +ind2);
					return;
				}
			}
			pw.println("NO");
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
			return Integer.compare(b,o.b);
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