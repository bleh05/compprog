
// Problem : D. Social Network
// Contest : Codeforces - VK Cup 2015 - Round 1
// URL : https://codeforces.com/contest/524/problem/D
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
			int m = sc.nextInt();
			int timet = sc.nextInt();
			PriorityQueue<tup> events = new PriorityQueue<tup>();
			for(int i = 0; i < n; i++) {
				String time[] = sc.nextLine().split(":");
				tup t1 = new tup(Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2]), i, 1);
				tup t2 = new tup(Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2]), i, -1);
				t2.add(timet);
				events.add(t1);
				events.add(t2);
			}
			int ptr = 0;
			int[] ans = new int[n];
			int[] etn = new int[100000];
			HashSet<Integer> people = new HashSet<Integer>();
			boolean thr = false;
			while(!events.isEmpty()) {
				tup t = events.poll();
				if(t.e == 1) {
					if(people.size() < m) {
						people.add(++ptr);
					}
					if(people.size() == m) {
						thr = true;
					}
					ans[t.d] = ptr;
					etn[ptr]++; 
				}
				else {
					etn[ans[t.d]]--;
					if(etn[ans[t.d]] == 0) {
						people.remove(ans[t.d]);
					}
				}
			}
			if(!thr){
				pw.println("No solution");
				return;
			}
			pw.println(ptr);
			for(int x : ans) {
				pw.println(x);
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
		int a, b, c; int d; int e;
		tup(int a,int b, int c, int d, int e){
			this.a=a;
			this.b=b;
			this.c=c;
			this.d=d;
			this.e=e;
		}
		@Override
		public int compareTo(tup o){
			return a == o.a ? b == o.b ? c == o.c ? Integer.compare(e, o.e) : Integer.compare(c, o.c) : Integer.compare(b, o.b) : Integer.compare(a, o.a);
		}
		void add(int time){
			int h = time / 3600;
			int m = time % 3600 / 60;
			int s = time % 60;
			c += s;
			b += c/60;
			c %= 60;
			b += m;
			a += b/60;
			b %= 60;
			a += h;
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