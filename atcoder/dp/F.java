
// Problem : F - LCS
// Contest : Educational DP Contest
// URL : https://atcoder.jp/contests/dp/tasks/dp_f
// Memory Limit : 1024 MB
// Time Limit : 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

import java.io.*;
import java.util.*;

public class Main{
	
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
			String str = sc.nextLine();
			String str2 = sc.nextLine();
			int n = str.length();
			int m = str2.length();
			int[][] dp = new int[str.length()][str2.length()]; //dp[i][j]= longest subsequence of substr(i) and substr(j)
			for(int i=0;i<str.length();i++){
				for(int j=0;j<str2.length();j++){
					if(str.charAt(i)==str2.charAt(j)){
						if(i==0 || j==0) dp[i][j] = 1;
						else dp[i][j] = dp[i-1][j-1] + 1;
					}
					if(i>0)
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
					if(j>0)
					dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
				}
			}
			StringBuilder sb = new StringBuilder();
			int i = n-1;
			int j = m-1;
			for(;i>=0&&j>=0;){
				if(str.charAt(i)==str2.charAt(j)){
					sb.append(str.charAt(i));
					i--;j--;
				}
				else if(j==0||i>0&&dp[i-1][j]>dp[i][j-1]){
					i--;
				}
				else{
					j--;
				}
			}
			sb=sb.reverse();
			pw.println(sb);
			
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