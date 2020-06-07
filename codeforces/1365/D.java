
// Problem : D. Solve The Maze
// Contest : Codeforces - Codeforces Round #648 (Div. 2)
// URL : https://codeforces.com/contest/1365/problem/D
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
			int m = sc.nextInt();
			int[][] grid = new int[n][m];
			ArrayList<Integer> goods = new ArrayList<Integer>();
			for(int i = 0; i < n; i++) {
				String str = sc.nextLine();
				for(int j = 0; j < m; j++) {
					if(str.charAt(j) == '#') {
						grid[i][j] = -1;
					}
					if(str.charAt(j) == 'B') {
						if(i > 0) {
							grid[i - 1][j] = -1;
						}
						if(i < n-1) {
							grid[i + 1][j] = -1;
						}
						if(j > 0) {
							grid[i][j - 1] = -1;
						}
						if(j < m-1) {
							grid[i][j + 1] = -1;
						}
					}
					if(str.charAt(j) == 'G') {
						goods.add(i * 100 + j);
					}
				}
			}
			if(grid[n-1][m-1] == -1 && goods.size() > 0) {
				pw.println("No");
				return;
			} 
			ArrayDeque<Integer> q = new ArrayDeque<Integer>();
			int[][] vis=  new int[n][m];
			q.add(n*100-100 + m-1);
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0, 1, -1};
			while(!q.isEmpty()) {
				int t = q.poll();
				int x = t/100;
				int y = t%100;
				vis[x][y] = 1;
				for(int i = 0; i < 4; i++) {
					if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]<m && y+dy[i]>=0 && grid[x+dx[i]][y+dy[i]] == 0 && vis[x+dx[i]][y+dy[i]] == 0) {
						vis[x+dx[i]][y+dy[i]] = 1;
						q.add((x+dx[i])*100+y+dy[i]);
					}
				}
			}
			for(int t : goods) {
				int x = t/100;
				int y = t%100;
				if(vis[x][y] == 0) {
					pw.println("No");
					return;
				}
			}
			pw.println("Yes");
			
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