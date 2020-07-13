import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner in;
	private static PrintWriter out;
	
	private static int n, root;
	private static ArrayList<Integer>[] tree;
	private static int[][] par, sub;
	private static long[][] dp;
	
	private static long getDP(int u, int v) {
		if (u == v) return 0;
		if (dp[u][v] != -1) return dp[u][v];

		long res = sub[u][v] * sub[v][u] + Math.max(getDP(par[v][u], v), getDP(u, par[u][v]));
		return dp[u][v] = res;
	}

	private static void dfs(int u) {
		sub[root][u] = 1;
		for(int v: tree[u]) {
			if (v == par[root][u])
				continue;
			par[root][v] = u;
			dfs(v);
			sub[root][u] += sub[root][v];
		}
	}

	private static void input() {
		n = in.nextInt();

		tree = new ArrayList[n];
		for(int u = 0; u < n; ++u)
			tree[u] = new ArrayList<>();
		for(int i = 0; i < n-1; ++i) {
			int u = in.nextInt(), v = in.nextInt();
			u -= 1; v -= 1;
			tree[u].add(v); tree[v].add(u);
		}
	}

	private static void solve() {
		// Preprocessing
		par = new int[n][n];
		sub = new int[n][n];
		for(int u = 0; u < n; ++u) {
			par[u][u] = -1;
			root = u;
			dfs(u);
		}

		// Calculating DP
		dp = new long[n][n];
		for(int u = 0; u < n; ++u)
			for(int v = 0; v < n; ++v)
				dp[u][v] = -1;

		long ans = 0;
		for(int u = 0; u < n; ++u)
			for(int v = 0; v < n; ++v)
				ans = Math.max(ans, getDP(u, v));

		out.println(ans);
	}

	public static void main(String[] args) {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);

		input();
		solve();

		out.close();
	}
}