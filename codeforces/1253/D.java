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
		static HashMap<Integer,pair> hm = new HashMap<Integer,pair>();
		static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		static boolean vis[];
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			int n = sc.nextInt();
			boolean[] node = new boolean[n+1];
			for(int i=0;i<=n;i++) {
				arr.add(new ArrayList<Integer>());
			}
			Set<Integer> nodes = new HashSet<Integer>();
			ArrayList<Integer> dd = new ArrayList<Integer>();
			int m = sc.nextInt();
			for(int i=0;i<m;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr.get(a).add(b);
				arr.get(b).add(a);
				nodes.add(a);
				nodes.add(b);
				node[a]=true;
				node[b]=true;
			}
			for(int x : nodes) {
				dd.add(x);
			}
			Collections.sort(dd);
			vis=new boolean[n+1];
			int ct=0;
			for(int x : dd) {
				if(!vis[x]) {
					hm.put(ct,new pair(Integer.MAX_VALUE,0));
					dfs(x,ct++);
				}
			}
			ArrayList<pair> p = new ArrayList<pair>();
			for(pair x : hm.values()) {
				p.add(x);
			}
			Collections.sort(p);
			int r =0;
			for(int i=0;i<p.size()-1;i++) {
				if(p.get(i).y>p.get(i+1).x) {
					r++;
					p.get(i+1).y=Math.max(p.get(i+1).y, p.get(i).y);
					p.get(i+1).x=Math.min(p.get(i+1).x, p.get(i).x);
				}
				else{
					for(int j=p.get(i).x;j<=p.get(i).y;j++){
						//System.out.println(j);
						if(!node[j])r++;
					}
				}
			}
			for(int j=p.get(p.size()-1).x;j<=p.get(p.size()-1).y;j++){
				//System.out.println(j);
				if(!node[j])r++;
			}
			pw.println(r);

		}
		static class pair implements Comparable<pair>{
			public int x;
			int y;
			public pair(int x, int y) {
				this.x=x;this.y=y;
			}
			@Override
			public int compareTo(pair o) {
				return Integer.compare(x, o.x);
			}
			public String toString() {
				return x+ " "+ y;
			}

		}
		static void dfs(int a,int b) {
			vis[a]=true;
			for(int x:arr.get(a)) {
				if(!vis[x]) {
					vis[x]=true;
					hm.get(b).x=Math.min(hm.get(b).x,Math.min(a, x));
					hm.get(b).y=Math.max(hm.get(b).y,Math.max(a, x));
					dfs(x,b);
				}
			}
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