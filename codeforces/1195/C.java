import java.io.*;
import java.util.*;

public class template {
	public static void main(String[] args) throws IOException {
		FastReader scan = new FastReader();
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		Task solver = new Task();
		//int t = scan.nextInt();
		int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}
	static class Task {
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			int n =sc.nextInt();
			int[] arr1 = new int[n];
			int[] arr2 = new int[n];
			for(int i=0;i<n;i++) {
				arr1[i]=sc.nextInt();
			}
			for(int i=0;i<n;i++) {
				arr2[i]=sc.nextInt();
			}
			long[][] dp = new long[n][2];
			dp[0][0]=arr1[0];
			dp[0][1]=arr2[0];
			if(n>1) {
			dp[1][0]=arr2[0]+arr1[1];
			dp[1][1]=arr1[0]+arr2[1];
			}
			for(int i=2;i<n;i++) {
				dp[i][0]=Math.max(dp[i-1][1], Math.max(dp[i-2][0],dp[i-2][1]))+arr1[i];
				dp[i][1]=Math.max(dp[i-1][0], Math.max(dp[i-2][0],dp[i-2][1]))+arr2[i];
			}
			//System.out.println(Arrays.deepToString(dp));
			pw.println(Math.max(dp[n-1][0],dp[n-1][1]));
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