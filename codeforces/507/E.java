
// Problem : E. Breaking Good
// Contest : Codeforces - Codeforces Round #287 (Div. 2)
// URL : https://codeforces.com/contest/507/problem/E
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
			List<tup>[] adjl = Stream.generate(ArrayList::new).limit(n).toArray(List[]::new);
			int[] ans = new int[m];
			int[][] origs = new int[m][3];
			for(int i = 0; i < m; i++) { 
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				int c = 200000 - sc.nextInt();
				origs[i] = new int[]{a + 1, b + 1, 200000 - c};
				adjl[a].add(new tup(b, c, i));
				adjl[b].add(new tup(a, c, i));
			}
			Queue<Integer> q = new LinkedList<Integer>();q.add(0);
			tup[] bfs = new tup[n];
			Arrays.fill(bfs, new tup(Long.MAX_VALUE, -1));
			
			bfs[0] = new tup(0, -1);
			
			while(!q.isEmpty()) {
				int t = q.poll();
				for(tup x : adjl[t]) {
					if(bfs[t].a + x.b < bfs[(int)x.a].a) {
						bfs[(int)x.a] = new tup(bfs[t].a + x.b, t);
						q.add((int)x.a);
					}
				}
			}
			int[] yep = new int[m];
			int last = n - 1;
			tup curr = bfs[n - 1];
			while(curr.a != 0) {
				for(tup z : adjl[(int)curr.b]) {
					if(z.a == last) {
						yep[z.c] = 1;
						break;
					}
				}
				last = (int)curr.b;
				curr = bfs[(int)curr.b];
			}
			ArrayList<int[]> addd = new ArrayList<>();
			for(int i = 0; i < m; i++) {
				if(yep[i] != origs[i][2]) {
					origs[i][2] ^= 1;
					addd.add(origs[i]);
				}
			}
			pw.println(addd.size());
			for(int[] x : addd) {
				pw.printf("%d %d %d%n", x[0],x[1],x[2]);
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
		long a, b;int c;
		tup(long a,long b){
			this.a=a;
			this.b=b;
		}
		tup(long a,long b,int c){
			this.a=a;
			this.b=b;
			this.c=c;
		}
		@Override
		public int compareTo(tup o){
			return Long.compare(o.b,b);
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