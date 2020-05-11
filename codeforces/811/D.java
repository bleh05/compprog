
// Problem : D. Vladik and Favorite Game
// Contest : Codeforces - Codeforces Round #416 (Div. 2)
// URL : https://codeforces.com/contest/811/problem/D
// Memory Limit : 256 MB
// Time Limit : 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

import java.io.*;
import java.util.*;

public class a implements Runnable{
	
    public static void main(String[] args) {
        new Thread(null, new a(), "process", 1<<26).start();
    }
	public void run() {
		FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out),true);
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
			int x = 0;
			int y = 0;
			int[][] grid = new int[120][120];
			for(int i = 0; i < n; i++){
				String str = sc.nextLine();
				for(int j = 0; j < m; j++){
					if(str.charAt(j) == '*'){
						grid[i + 1][j + 1] = -1;
					}
					else if(str.charAt(j) == 'F'){
						grid[i + 1][j + 1] = 1;
						x = i + 1;
						y = j + 1;
					}
				}
			}
			int[] dx = {0, 0, -1, 1};
			int[] dy = {-1, 1, 0, 0};
			int[][] dist = new int[120][120];
			for(int[] xt : dist)Arrays.fill(xt, inf/2);
			dist[1][1] = 0;
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(1001);
			while(!q.isEmpty()) {
				int cu = q.poll();
				int cux = cu / 1000;
				int cuy = cu % 1000;
				if(cux == 0 || cux > n || cuy == 0 || cuy > m){
					continue;
				}
				for(int i = 0; i < 4; i++){
					if(dist[cux][cuy] + 1 < dist[cux + dx[i]][cuy + dy[i]] && grid[cux + dx[i]][cuy + dy[i]] != -1){
						dist[cux + dx[i]][cuy + dy[i]] = dist[cux][cuy] + 1;
						q.add((cux + dx[i]) * 1000 + cuy + dy[i]);
					}
				}
			}
			char[] arr = {'R', 'L', 'D', 'U'};
			ArrayList<Character> directions = new ArrayList<>();
			HashSet<Character> ds = new HashSet<>();
			while(x != 1 || y != 1){
				for(int i = 0; i < 4; i++){
					if(x > 0 && y > 0 && dist[x + dx[i]][y + dy[i]] == dist[x][y] - 1){
						directions.add(arr[i]);
						x += dx[i];
						y += dy[i];
						ds.add(arr[i]);
					}
				}
			}
			if(ds.size() == 1){
				for(char rr : directions){
					pw.println(rr);
				}
				for(char rr : directions){
					switch(rr){
						case 'L': pw.println('R'); break;
						case 'R': pw.println('L'); break;
						case 'D': pw.println('U'); break;
						case 'U': pw.println('D'); break;
					}
				}
				return;
			}
			int dirH = 0;
			int dirV = 0;
			if(grid[1][2] == 1){
				pw.println('R');
				pw.println('L');
				return;
			}
			if(grid[2][1] == 1){
				pw.println('U');
				pw.println('D');
				return;
			}
			if(grid[x][y + 1] == 0){
				pw.println('R');
				x = sc.nextInt();
				y = sc.nextInt();
					if(x == -1 && y == -1)System.exit(13);
				int ctr = 0;
				if(y == 1) dirH = 1;
				else {
					pw.println('L');
					x = sc.nextInt();
					y = sc.nextInt();
					if(x == -1 && y == -1)System.exit(13);
				}
				while(grid[x + 1][y] == -1){
					if(dirH == 1){
						pw.println('L');
					}
					else pw.println('R');
					x = sc.nextInt();
					y = sc.nextInt();
					if(x == -1 && y == -1)System.exit(13);
					ctr ++;
				}
				pw.println('D');
				x = sc.nextInt();
				y = sc.nextInt();
				if(x == -1 && y == -1)System.exit(13);
				if(x == 1) dirV = 1;
				else{
					pw.println('U');
					x = sc.nextInt();
					y = sc.nextInt();
					if(x == -1 && y == -1)System.exit(13);
				} 
				while(y != 1){
					if(dirH == 1){
						pw.println('R');
					}
					else pw.println('L');
					x = sc.nextInt();
					y = sc.nextInt();
					if(x == -1 && y == -1)System.exit(13);
				}
			}
			else{
				pw.println('D');
				x = sc.nextInt();
				y = sc.nextInt();
					if(x == -1 && y == -1)System.exit(13);
				int ctr = 0;
				if(x == 1) dirV = 1;
				else {
					pw.println('U');
					x = sc.nextInt();
					y = sc.nextInt();
					if(x == -1 && y == -1)System.exit(13);
				}
				while(grid[x][y + 1] == -1){
					if(dirV == 1){
						pw.println('U');
					}
					else pw.println('D');
					x = sc.nextInt();
					y = sc.nextInt();
					if(x == -1 && y == -1)System.exit(13);
				}
				pw.println('R');
				x = sc.nextInt();
				y = sc.nextInt();
					if(x == -1 && y == -1)System.exit(13);
				if(y == 1) dirH = 1;
				else{ 
					pw.println('L');
					x = sc.nextInt();
					y = sc.nextInt();
					if(x == -1 && y == -1)System.exit(13);
				}
				while(x != 1){
					if(dirV == 1){
						pw.println('D');
					}
					else pw.println('U');
					x = sc.nextInt();
					y = sc.nextInt();
					if(x == -1 && y == -1)System.exit(13);
				}
			}
			Collections.reverse(directions);
			for(char s : directions){
				if(s == 'R'){
					if(dirH == 1) pw.println('L');
					else pw.println('R');
				}
				if(s == 'L'){
					if(dirH == 1) pw.println('R');
					else pw.println('L');
				}
				if(s == 'U'){
					if(dirV == 1) pw.println('D');
					else pw.println('U');
				}
				if(s == 'D'){
					if(dirV == 1) pw.println('U');
					else pw.println('D');
				}
				x = sc.nextInt();
				y = sc.nextInt();
				if(x == -1 && y == -1)System.exit(13);
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