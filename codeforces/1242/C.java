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
			int[][] arr = new int[n][];
			long sums[] = new long[n];
			HashMap<Integer, Integer> map1 = new HashMap<>();
			HashMap<Integer, Integer> map2 = new HashMap<>();
			ArrayList<Integer> arrs = new ArrayList<Integer>();
			arrs.add(0);
			int incc = 1;
			long sum = 0;
			for(int i = 0; i < n; i++) {
				int k = sc.nextInt();
				arr[i] = new int[k];
				for(int j = 0; j < k; j++) {
					sum += (arr[i][j] = sc.nextInt());
					sums[i] += arr[i][j];
					map1.put(arr[i][j], incc++);
					map2.put(arr[i][j], i);
					arrs.add(arr[i][j]);
				}
			}
			if(sum % n != 0) {
				pw.println("No");
				return; 
			}
			cycle[] masktocyc = new cycle[1<<n];
			long goal = sum / n;
			ArrayList<cycle> cycs = new ArrayList<cycle>();
			int[] graph = new int[incc];
			l:
			for(int i = 1; i < incc; i++) {
				cycle c = new cycle();
				int curr = i;
				int val = arrs.get(i);
				int ind = map2.get(val);
				if(graph[i] != 0) continue;
				do {
					long ch = (goal - sums[ind] + val);
					if(ch > inf || ch < -inf || !map1.containsKey((int)ch)) {
						continue l;
					}
					val = (int)(ch);
					graph[curr] = map1.get(val);
					//pw.println(curr + " - " + map1.get(ch));
					curr = map1.get(val);
					c.add(ind, val);
					ind = map2.get(val);
				}
				while(graph[curr] == 0);
				for(tup x : c.arr) {
					if(sums[x.a] - arrs.get(curr) + x.b == goal) break;
					c.mask -= (1<<x.a);
					x.a = -inf;
					x.b = -inf;
				}
				int[] freq = new int[15];
				for(tup x : c.arr) {
					if(x.a >= 0) {
						freq[x.a]++;
						if(freq[x.a] > 1) continue l;
					}
				}
				//for(tup x : c.arr) System.out.printf("%d %d%n", x.a, x.b);
				//System.out.println(c.mask);
				cycs.add(c);
				masktocyc[c.mask] = c;
			}
			
			ArrayList<cycle>[] dp = new ArrayList[1<<n];
			for(int m = 0; m < (1<<n); m++) {
				dp[m] = new ArrayList<cycle>();
				if(masktocyc[m] != null) {
					dp[m].add(masktocyc[m]);
					continue;
				}
				for(int s = m; s > 0; s = (s - 1) & m) {
					if(dp[s].size() > 0 && dp[m ^ s].size() > 0) {
						dp[m].addAll(dp[s]);
						dp[m].addAll(dp[m ^ s]);
						break;
					}
				}
			}
			if(dp[(1<<n) - 1].size() > 0) {
				pw.println("Yes");
				int[] ans1 = new int[n];
				int[] ans2 = new int[n];
				for(cycle x : dp[(1<<n) - 1]) {
					for(tup y : x.arr) {
						if(y.b != -inf) {
							ans1[map2.get(y.b)] = y.a+1;
							ans2[map2.get(y.b)] = y.b;
						}
					}
				}
				for(int i = 0; i < n; i++) {
					pw.printf("%d %d%n", ans2[i], ans1[i]);
				}
			}
			else pw.println("No");
		}
		static class cycle {
			ArrayList<tup> arr = new ArrayList<>();
			int mask = 0;
			public cycle(){}
			void add(int ind, int val) {
				arr.add(new tup(ind, val));
				mask += (1<<ind);
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