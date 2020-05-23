
// Problem : D. Mahmoud and Ehab and another array construction task
// Contest : Codeforces - Codeforces Round #473 (Div. 2)
// URL : https://codeforces.com/contest/959/problem/D
// Memory Limit : 256 MB
// Time Limit : 3000 ms
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
			int[] arr = new int[n];
			for(int i = 0; i < n; i ++) {
				arr[i] = sc.nextInt();
			}
			ArrayList<Integer> primes = new ArrayList<Integer>();
			primes.add(2);
			primes.add(3);
			for(int i = 6; i < 3000010; i += 6) {
				int cand1 = i - 1;
				boolean good =true;
				for(int j = 2; j * j <= cand1; j++) {
					if(cand1 % j == 0) {
						good = false;
						break;
					}
				}
				if(good) {
					primes.add(cand1);
				}
				int cand2 = i + 1;
				good =true;
				for(int j = 2; j * j <= cand2; j++) {
					if(cand2 % j == 0) {
						good = false;
						break;
					}
				}
				if(good) {
					primes.add(cand2);
				}
			}
			boolean[] used = new boolean[3000010];
			int[] newa = new int[n];
			boolean phase1 = true;
			int ptr = 0;
			boolean f = false;
			for(int i = 0; i < n; i++) {
				if(phase1) {
					ArrayList<Integer> tdr = new ArrayList<>();
					int x = arr[i];
					for(int j = 2; j <= Math.sqrt(arr[i]); j++) {
						if(used[j] && arr[i] % j == 0) {
							phase1 = false;
							break;
						}
						if(arr[i] % j == 0) {
							tdr.add(j);
						}
						while(arr[i] % j == 0) {
							
							arr[i] /= j;
						}
					}
					if(arr[i] > 1) {
						if(used[arr[i]]) {
							phase1 = false;
						}
						tdr.add(arr[i]);
						used[arr[i]] = true;
					}
					if(phase1)
						for(int zzz : tdr){ 
							used[zzz] = true;
						}
					newa[i] = x;
				}
				if(!phase1) {
					if(!f) {
						l:
						while(true) {
							newa[i]++;
							int c = newa[i];
							ArrayList<Integer> tdr = new ArrayList<>();
							for(int j = 2; j * j <= c; j++) {
								if(used[j] && c % j == 0) {
									continue l;
								}
								if(c % j == 0) {
									tdr.add(j);
								}
								while(c % j == 0) {
									c /= j;
								}
							}
							
							if(c > 1) {
								if(used[c]) {
									continue l;
								}
								tdr.add(c);
							}
							for(int x : tdr) {
								used[x] = true;
							}
							break l;
						}
						f = true;
					}
					else{
						while(used[primes.get(ptr)]) {
							ptr++;
						}
						newa[i] = primes.get(ptr++);
					}
				}
			}
			for(int x : newa) {
				pw.print(x + " ");
			}
			pw.println();
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