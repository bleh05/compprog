
// Problem : D. Olya and Energy Drinks
// Contest : Codeforces - Codeforces Round #442 (Div. 2)
// URL : https://codeforces.com/contest/877/problem/D
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
			int k = sc.nextInt();
			int[][] grid2 = new int[n][m];
			int[][] grid = new int[n][m];
			for(int i = 0; i < n; i++){
				String str = sc.nextLine();
				for(int j = 0; j < m; j++) {
					if(str.charAt(j) == '#') {
						grid[i][j] = 1;
					}
				}
			}
			for(int[] arr : grid2) {
				Arrays.fill(arr, inf);
			}
			int x1 = sc.nextInt()-1;
			int y1 = sc.nextInt()-1;
			int x2 = sc.nextInt()-1;
			int y2 = sc.nextInt()-1;
			ArrayDeque<Integer> q = new ArrayDeque<Integer>();
			q.add(x1 * 1000 + y1);
			grid2[x1][y1] = 0;
			while(!q.isEmpty()) {
				int t = q.poll();
				int x = t / 1000;
				int y = t % 1000;
				for(int i = 1; i <= k; i++) {
					if(y + i >= m || grid2[x][y+i] < grid2[x][y] + 1 || grid[x][y+i] == 1) {
						break;
					}
					if(grid2[x][y+i] > grid2[x][y] + 1) {
						grid2[x][y+i] = grid2[x][y] + 1;
						q.add(x*1000+y+i);
					}
				}
				for(int i = 1; i <= k; i++) {
					if(y - i < 0 || grid2[x][y-i] < grid2[x][y] + 1 || grid[x][y-i] == 1) {
						break;
					}
					if(grid2[x][y-i] > grid2[x][y] + 1) {
						grid2[x][y-i] = grid2[x][y] + 1;
						q.add(x*1000+y-i);
					}
				}
				for(int i = 1; i <= k; i++) {
					if(x + i >= n || grid2[x+i][y] < grid2[x][y] + 1 || grid[x+i][y] == 1) {
						break;
					}
					if(grid2[x + i][y] > grid2[x][y] + 1) {
						grid2[x+i][y] = grid2[x][y] + 1;
						q.add((x+i)*1000+y);
					}
				}
				for(int i = 1; i <= k; i++) {
					if(x - i < 0 || grid2[x-i][y] < grid2[x][y] + 1 || grid[x-i][y] == 1) {
						break;
					}
					if(grid2[x-i][y] > grid2[x][y] + 1) {
						grid2[x-i][y] = grid2[x][y] + 1;
						q.add((x-i)*1000+y);
					}
				}
			}
			pw.println(grid2[x2][y2]==inf ? -1 : grid2[x2][y2]);
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