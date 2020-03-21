
// Problem : A - Range Flip Find Route
// Contest : AtCoder Grand Contest 043
// URL : https://atcoder.jp/contests/agc043/tasks/agc043_a
// Memory Limit : 1024 MB
// Time Limit : 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		FastReader scan = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		//int t = scan.nextInt();
		int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}

	static class Task {

		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] grid = new int[n][m];
			for(int i=0;i<n;i++){
				String str = sc.nextLine();
				for(int j=0;j<m;j++){
					grid[i][j]=str.charAt(j)=='.'?0:1;
				}
			}
			int[][] bfs = new int[n][m];
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					bfs[i][j]=100000;
				}
			}
			bfs[0][0]=0;
			if(grid[0][0]==1)bfs[0][0]++;
			
			int[] q = new int[1000000];
			int qpt = 1;
			int qpo = 0;
			while(qpo<qpt){
				int pop = q[qpo++];
				int x = pop/1000;
				int y = pop%1000;
				//pw.println(x+" "+y);
				if(y<m-1&&bfs[x][y]+(grid[x][y+1]*(1-grid[x][y]))<bfs[x][y+1]){
					q[qpt++]=pop+1;
					bfs[x][y+1]=bfs[x][y]+(grid[x][y+1]*(1-grid[x][y]));
					//pw.println(1+" "+x+" "+y+" " +(grid[x][y+1]*(1-grid[x][y])));
				}
				if(x<n-1&&bfs[x][y]+(grid[x+1][y]*(1-grid[x][y]))<bfs[x+1][y]){
					q[qpt++]=pop+1000;
					bfs[x+1][y]=bfs[x][y]+(grid[x+1][y]*(1-grid[x][y]));
					//pw.println(2+" "+x+" "+y+" "+(grid[x+1][y]*(1-grid[x][y])));
				}
				
			}
			for(int[] x : bfs){
				//pw.println(Arrays.toString(x));
			}
			pw.println(bfs[n-1][m-1]);
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