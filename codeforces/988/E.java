
// Problem : E. Divisibility by 25
// Contest : Codeforces - Codeforces Round #486 (Div. 3)
// URL : https://codeforces.com/contest/988/problem/E
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
			int[] pos = new int[5];
			Arrays.fill(pos, -1);
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '0') {
					pos[4] = pos[0];
					pos[0] = i;
				}
				if(str.charAt(i) == '2') {
					pos[1] = i;
				}
				if(str.charAt(i) == '5') {
					pos[2] = i;
				}
				if(str.charAt(i) == '7') {
					pos[3] = i;
				}
			}
			int n = str.length();
			int min = inf;
			if(pos[0] > -1 && pos[4] > -1) {
				min = Math.min(min, str.length() - pos[0] + str.length() - pos[4] - 3);
			}
			if(pos[1] > -1 && pos[2] > -1) {
				int addend = 0;
				if(pos[2] < pos[1]) {
					addend = 1;
				}
				if(pos[1] == 0 || pos[2] == 0) {
					for(int i = 1; i < n; i++) {
						if(str.charAt(i) != '0') {
							break;
						}
						addend++;
					}
				}
				if(pos[1] == n - 1 && pos[2] == n - 2) {
					min = Math.min(1, min);
				}
				min = Math.min(min, n - pos[1] + n - pos[2] - 3 + addend);
			}
			if(pos[0] > -1 && pos[2] > -1) {
				int addend = 0;
				if(pos[0] < pos[2]) {
					addend = 1;
				}
				if(pos[0] == 0 || pos[2] == 0) {
					for(int i = 1; i < n; i++) {
						if(str.charAt(i) != '0') {
							break;
						}
						if(i != pos[0])
						addend++;
					}
				}
				if(pos[2] == n - 1 && pos[0] == n - 2) {
					min = Math.min(1, min);
				}
				min = Math.min(min, n - pos[2] + n - pos[0] - 3 + addend);
			}
			if(pos[3] > -1 && pos[2] > -1) {
				int addend = 0;
				if(pos[2] < pos[3]) {
					addend = 1;
				}
				if(pos[3] == 0 || pos[2] == 0) {
					for(int i = 1; i < n; i++) {
						if(str.charAt(i) != '0') {
							break;
						}
						addend++;
					}
				}
				if(pos[3] == n - 1 && pos[2] == n - 2) {
					min = Math.min(1, min);
				}
				min = Math.min(min, n - pos[3] + n - pos[2] - 3 + addend);
			}
			if(min == inf) {
				pw.println(-1);
			}
			else{
				pw.println(min);
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