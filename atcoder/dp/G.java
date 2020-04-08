
// Problem : G - Longest Path
// Contest : Educational DP Contest
// URL : https://atcoder.jp/contests/dp/tasks/dp_g
// Memory Limit : 1024 MB
// Time Limit : 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		FastReader scan = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
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
			int n = sc.nextInt();
			HashSet<Integer>[] adjl1 = new HashSet[n];
			HashSet<Integer>[] adjl2 = new HashSet[n];
			int m = sc.nextInt();
			for(int i=0;i<n;i++){
				adjl1[i]=new HashSet<Integer>();
				adjl2[i] = new HashSet<Integer>();
			}
			for(int i = 0;i < m;i++){
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				adjl1[a].add(b);
				adjl2[b].add(a);
			}
			Queue<Integer> q = new LinkedList<Integer>();
			for(int i = 0;i < n; i++){
				if(adjl1[i].size() == 0){
					q.add(i);
				}
			}
			int bfs[] = new int[n];
			while(!q.isEmpty()){
				int t = q.poll();
				for(int x : adjl2[t]){
					if(bfs[x]<bfs[t]+1){
						bfs[x]=bfs[t]+1;
					}
					adjl1[x].remove(t);
					if(adjl1[x].size() == 0){
						q.add(x);
					}
				}
			}
			int max = 0;
			for(int x : bfs){
				max=Math.max(x,max);
			}
			pw.println(max);
		}
	}
	long binpow(long a, long b, long m) {
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
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	static void shuffle(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
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