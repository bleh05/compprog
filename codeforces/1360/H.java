
// Problem : H. Binary Median
// Contest : Codeforces - Codeforces Round #644 (Div. 3)
// URL : https://codeforces.com/contest/1360/problem/H
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
		int t = scan.nextInt();
		//int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}

	static class Task {
		static final int inf = Integer.MAX_VALUE;
		int n; int m;
		long[] arr;
		HashSet<Long> hs;
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			n = sc.nextInt();
			m = sc.nextInt();
			hs = new HashSet<Long>();
			arr = new long[n];
			for(int i = 0; i < n; i++) {
				long t = Long.parseLong(sc.nextLine(), 2);
				hs.add(t);
				arr[i] = t;
			}
			sort(arr);
			long c = search();
			while(hs.contains(c++));
			c--;
			String str = "";
			for(int i = 0; i < m; i++) {
				str = (c%2) + str;
				c>>=1;
			}
			//pw.println(Arrays.toString(arr));
			//pw.println(3 - searc2h(3));
			pw.println(str);
		}
		
		public long search(){
			long lo = 0, hi = 1l<<62;
			long ind = ((1l<<m)-n-1)/2;
		    for(int i=0;i<70;i++) {
		        long mid = (lo+hi)/2;
		        int x = searc2h(mid);
		        if(mid - x == ind) {
		        	return mid;
		        }
		        if (mid - x < ind) {
		            lo = mid;
		        } else {
		            hi = mid;
		        }
		    }
		    return lo;
		}
		public int searc2h(long a){
			int lo = 0, hi = n;
			
		    for(int i = 0; i < 33; i ++) {
		        int mid = (lo+hi)/2;
		        if(arr[mid] == a) {
		        	return mid;
		        }
		        
		        if (arr[mid] <= a) {
		            lo = mid;
		        } else {
		            hi = mid;
		        }
		    }
		    if(a < arr[0]) {
		    	return 0;
		    }
		    return lo + 1;
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