
// Problem : D. Replace by MEX
// Contest : Codeforces - Codeforces Global Round 9
// URL : https://codeforces.com/contest/1375/problem/D
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
			tup[] arr = new tup[n];
			PriorityQueue<tup> q = new PriorityQueue<>();
			for(int i = 0; i < n; i++) {
				int k = sc.nextInt();
				arr[i] = new tup(i + 1, k);
			}
			ArrayList<Integer> ans = new ArrayList<>();
			
			int[] temp = new int[n + 3];
			for(int j = 0; j < n; j++) {
				temp[arr[j].b] = 1;
			}
			int mex = inf;
			for(int j = 0; j < n + 3; j++) {
				if(temp[j] == 0) {
					mex = j;
					break;
				}
			}
			while(mex < n) {
				ans.add(mex + 1);
				arr[mex].b = mex;
				temp = new int[n + 3];
				for(int j = 0; j < n; j++) {
					temp[arr[j].b] = 1;
				}
				mex = inf;
				for(int j = 0; j < n + 3; j++) {
					if(temp[j] == 0) {
						mex = j;
						break;
					}
				}
				
			}
			
			for(int i = 0; i < n; i++) {
				q.add(arr[i]); 
			}
			for(int i = 0; i < n; i++) {
				boolean good = true;
				for(int is = 1; is < n; is++) {
					if(arr[is].b < arr[is - 1].b) {
						good = false;
					}
				}
				if(good) break;
				if(arr[i].b == i) {
					q.remove(arr[i]);
					continue;
				}
				while(q.peek().b <= i) {
					tup t = q.poll();
					ans.add(t.a);
					temp = new int[n + 3];
					for(int j = 0; j < n; j++) {
						temp[arr[j].b] = 1;
					}
					mex = inf;
					for(int j = 0; j < n + 3; j++) {
						if(temp[j] == 0) {
							mex = j;
							break;
						}
					}
					q.add(arr[t.a - 1] = new tup(t.a, mex));
				}
				ans.add(i + 1);
				q.remove(arr[i]);
				arr[i].b = i;
			}
			pw.println(ans.size());
			for(int x : ans) {
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
			return b == o.b ? Integer.compare(a, o.a) : Integer.compare(b,o.b);
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