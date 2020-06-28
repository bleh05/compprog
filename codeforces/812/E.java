
// Problem : E. Sagheer and Apple Tree
// Contest : Codeforces - Codeforces Round #417 (Div. 2)
// URL : https://codeforces.com/contest/812/problem/E
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
			int[] weight = new int[n];
			for(int i = 0; i < n; i++) {
				weight[i] = sc.nextInt();
			}
			int[] leaves = new int[n];
			int[] pars = new int[n];
			for(int i = 0; i < n - 1; i++) {
				int p = sc.nextInt() - 1;
				pars[i] = p;
				leaves[p] = 1;
			}
			int[] color = new int[n];
			int[] vis = new int[n];
			ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
			for(int i = 0; i < n; i++) {
				if(leaves[i] == 0) {
					dq.add(i);
					vis[i] = 1;
				}
			}
			
			while(!dq.isEmpty()) {
				int k = dq.poll();
				if(k == 0) continue;
				if(vis[pars[k - 1]] == 0) {
					vis[pars[k - 1]] = 1;
					color[pars[k - 1]] = color[k] ^ 1;
					dq.add(pars[k - 1]);
				}
			}
			int cxor = 0;
			int z = n;
			int o = 0;
			for(int i = 0; i < n; i++) {
				if(color[i] == 0) {
					cxor ^= weight[i];
					z--;
					o++;
				}
			}
			if(cxor == 0) {
				long sum = 0;
				sum += z * (z - 1l) / 2;
				sum += o * (o - 1l) / 2;
				HashMap<Integer, Integer> hm = new HashMap<>();
				for(int i = 0; i < n; i++){ 
					if(color[i] == 1) {
						hm.put(weight[i], hm.getOrDefault(weight[i], 0) + 1);
					}
				}
				for(int i = 0; i < n; i++) {
					if(color[i] == 0) {
						if(hm.get(weight[i]) != null) 
							sum += hm.get(weight[i]);
					}
				}
				pw.println(sum);
			}
			else{
				long sum = 0;
				HashMap<Integer, Integer> hm = new HashMap<>();
				for(int i = 0; i < n; i++){ 
					if(color[i] == 1) {
						hm.put(cxor ^ weight[i], hm.getOrDefault(cxor ^ weight[i], 0) + 1);
					}
				}
				for(int i = 0; i < n; i++) {
					if(color[i] == 0) {
						if(hm.get(weight[i]) != null)
						sum += hm.get(weight[i]);
					}
				}
				pw.println(sum);
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