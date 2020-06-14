
// Problem : C. Exponential notation
// Contest : Codeforces - Educational Codeforces Round 14
// URL : https://codeforces.com/problemset/problem/691/C
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
			String str = sc.nextLine();
			
			int ind = 0;
			for(; ind < str.length(); ind++) {
				if(str.charAt(ind) != '0') break;
			}
			str = str.substring(ind);
			int dotp = str.length();
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '.') {
					dotp = i;
					str = str.substring(0, i) + str.substring(i + 1);
				}
			}
			ind = str.length()-1;
			for(; ind >= 0; ind--) {
				if(str.charAt(ind) != '0') break;
			}
			str = str.substring(0, ind+1);
			if(str.length() == 0) {
				pw.println(0);
				return;
			}
			int exp = dotp - 1;
			StringBuilder sb = new StringBuilder();
			boolean ddd = false;boolean eee = false;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) != '0' || ddd) {
					sb.append(str.charAt(i));
					if(ddd) {eee=true;
					}
					if(!ddd) {
						sb.append('.');
						exp -= i;
					}
					ddd = true;
				}
			}
			if(exp == 0) {
				if(!eee) {
					pw.println(sb.toString().substring(0, sb.length()-1));
					return;
				}
				pw.println(sb);
				return;
			}
			if(!eee) {
				pw.println(sb.toString().substring(0, sb.length()-1) + "E" + exp);
				return;
			}
			pw.println(sb + "E" + exp);
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