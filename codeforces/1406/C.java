
// Problem : C. Link Cut Centroids
// Contest : Codeforces - Codeforces Round #670 (Div. 2)
// URL : https://codeforces.com/contest/1406/problem/C
// Memory Limit : 512 MB
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
		int t = scan.nextInt();
		//int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}

	static class Task {
		static final int inf = Integer.MAX_VALUE;
		int[] subt;
		int cno;
		int cp;
		int sno;
		int sp;
		List<Integer>[] adjl;
		int n;
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			n = sc.nextInt();
			adjl = Stream.generate(ArrayList::new).limit(n).toArray(List[]::new);
			for(int i = 0; i < n - 1; i++) {
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				adjl[a].add(b);
				adjl[b].add(a);
			}
			subt = new int[n];
			cno = -1;
			cp = -1;
			if(n % 2 == 1) {
				pw.println(1 + " " + (adjl[0].get(0) + 1));
				pw.println(1 + " " + (adjl[0].get(0) + 1));
				return;
			}
			dfs(0, 0);
			if(cno == -1) {
				pw.println(1 + " " + (adjl[0].get(0) + 1));
				pw.println(1 + " " + (adjl[0].get(0) + 1));
				return;
			}
			dfs2(cno, cp);
			pw.println(sno + 1 + " " + (sp + 1));
			pw.println(sno + 1 + " " + (cp + 1));
		}
		void dfs(int no, int p) {
			for(int x : adjl[no]){
				if(x == p) {
					continue;
				}
				dfs(x, no);
				subt[no] += subt[x];
			}
			subt[no]++;
			if(subt[no] == n / 2) {
				cno = no;
				cp = p;
			}
		}
		void dfs2(int no, int p) {
			
			sno = no;
			sp = p;
			for(int x : adjl[no]){
				if(x == p) {
					continue;
				}
				dfs2(x, no);
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