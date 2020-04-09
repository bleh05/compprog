
// Problem : W - Intervals
// Contest : Educational DP Contest
// URL : https://atcoder.jp/contests/dp/tasks/dp_w
// Memory Limit : 1024 MB
// Time Limit : 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

import java.io.*;
import java.util.*;

public class Main {
	
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
			int n = sc.nextInt();
			int m = sc.nextInt();
			segt s = new segt(200004);
			tup[] arr = new tup[m];
			for(int i=0;i<m;i++){
				arr[i]=new tup(sc.nextInt(),sc.nextInt(),sc.nextInt());
			}
			Arrays.sort(arr);
			int t = 0;
			for(int i=1;i<=200002;i++){
				long max = s.queryMax(1,0,200003,0,i);
				s.updateMax(1,0,200003,i+1,i+1,max);
				while(t<m && arr[t].b==i){
					s.updateMax(1,0,200003,arr[t].a + 1,arr[t].b + 1,arr[t++].c);
				}
			}
			pw.println(s.queryMax(1,0,200003,0,200003));
		}
	}
	static class segt {
        long[] t;
        long[] lazyMax;
        public segt(int n) {
            t = new long[4*n];
            lazyMax = new long[4*n];
        }
 
        void pushMax(int v) {
            t[v*2] += lazyMax[v];
            lazyMax[v*2] += lazyMax[v];
            t[v*2+1] += lazyMax[v];
            lazyMax[v*2+1] += lazyMax[v];
            lazyMax[v] = 0;
        }
 
        void updateMax(int v, int tl, int tr, int l, int r, long addend) {
            if (l > r)
                return;
            if (l == tl && tr == r) {
                t[v] += addend;
                lazyMax[v] += addend;
            } else {
                pushMax(v);
                int tm = (tl + tr) / 2;
                updateMax(v*2, tl, tm, l, Math.min(r, tm), addend);
                updateMax(v*2+1, tm+1, tr, Math.max(l, tm+1), r, addend);
                t[v] = Math.max(t[v*2], t[v*2+1]);
            }
        }
 
        long queryMax(int v, int tl, int tr, int l, int r) {
            if (l > r)
                return -Integer.MAX_VALUE;
            if (l <= tl && tr <= r)
                return t[v];
            pushMax(v);
            int tm = (tl + tr) / 2;
            return Math.max(queryMax(v*2, tl, tm, l, Math.min(r, tm)),
                    queryMax(v*2+1, tm+1, tr, Math.max(l, tm+1), r));
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
		int a, b, c;
		tup(int a,int b, int c){
			this.a=a;
			this.b=b;
			this.c=c;
		}
		@Override
		public int compareTo(tup o){
			return b==o.b?Integer.compare(a,o.a):Integer.compare(b,o.b);
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