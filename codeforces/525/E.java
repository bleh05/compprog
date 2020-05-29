// Problem : E. Anya and Cubes
// Contest : Codeforces - Codeforces Round #297 (Div. 2)
// URL : https://codeforces.com/problemset/problem/525/E
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
			int fs = sc.nextInt();
			long sums = sc.nextLong();
			long k = binpow(3, (n + 1) / 2, inf);
			ArrayList<Integer> iter = new ArrayList<Integer>();
			ArrayList<Integer> iter2 = new ArrayList<Integer>();
			for(int i = 0; i < k; i++) {
				int bitsum = 0;
				int t = i;
				while(t> 0) {
					bitsum += t%3 == 2 ? 1: 0;
					
					t/=3;
				}
				if(bitsum <= fs) {
					iter.add(i);
					iter2.add(bitsum);
				}
			}
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) 
				arr[i] = sc.nextInt();
			long facts[] = new long[19];
			facts[0] = 1;
			for(int i = 1; i < 19; i ++) {
				facts[i] = i * facts[i-1];
			}
			HashMap<Long, Integer>[] hm = Stream.generate(HashMap::new).limit(fs + 1).toArray(HashMap[]::new);
			l:
			for(int i = 0; i < iter.size(); i++) {
				long sum = 0;
				int ptr = 0;
				int bitcount = 0;
				int x = iter.get(i);
				while(x > 0) {
					int s = x%3 - 1;
					bitcount += Math.max(s, 0);
					if(s == 0) {
						sum += arr[ptr];
					}
					else if(s == 1){
						if(arr[ptr] > 18){
							continue l;
						}
						sum += facts[arr[ptr]];
					}
					x /= 3;
					ptr++;
				}
				hm[iter2.get(i)].put(sum, hm[iter2.get(i)].getOrDefault(sum, 0) + 1);
			}
			long k2 = binpow(3, n / 2, inf);
			long ans = 0;
			l2:
			for(int i = 0; i < iter.size(); i++) {
				long sum = 0;
				int ptr = (n + 1) / 2;
				int bitcount = 0;
				if(iter.get(i) >= k2) break;
				int x = iter.get(i);
				while(x > 0) {
					int s = x%3 - 1;
					bitcount += Math.max(s, 0);
					if(s == 0) {
						sum += arr[ptr];
					}
					else if(s == 1){
						if(arr[ptr] > 18){
							continue l2;
						}
						sum += facts[arr[ptr]];
					}
					x /= 3;
					ptr++;
				}
				for(int j = 0; j + bitcount <= fs; j++){
					ans += hm[j].getOrDefault(sums - sum, 0);
				}
			}
			pw.println(ans);
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