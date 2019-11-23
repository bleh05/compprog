import java.io.*;
import java.util.*;

public class template {
	public static void main(String[] args) throws IOException {
		FastReader scan = new FastReader();
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teamwork.out")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		Task solver = new Task();
		//int t = scan.nextInt();
		int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}
	static class Task {
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			int n = sc.nextInt();int m = sc.nextInt();
			int col = n;
			int row = n;
			boolean fillr[] = new boolean[n+1];
			boolean fillc[] = new boolean[n+1];
			long total = (long)n*n;
			for(int i=0;i<m;i++) {
				int a= sc.nextInt();
				int b=sc.nextInt();
				if(!fillr[a]&&!fillc[b]) {
					total-=row--+col---1;
				}
				else if(!fillr[a]) {
					total-=row;
					col--;
				}
				else if(!fillc[b]) {
					total-=col;
					row--;
				}
				fillr[a]=true;
				fillc[b]=true;
				if(i==m-1) {
					pw.print(total);
				}else {
					pw.print(total+" ");
				}
				
			}
		}
	}
	static class pair{
		int t, w;
		pair(int t, int w){
			this.t=t;
			this.w=w;
		}
		public String toString() {
			return t+" "+w;
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