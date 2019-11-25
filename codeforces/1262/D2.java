import java.io.*;
import java.util.*;

public class template {
	public static void main(String[] args) throws IOException {
		FastReader scan = new FastReader();
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teamwork.out")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		Task solver = new Task();
		//int t = scan.nextInt();
		int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}
	static class Task {
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			pair[] pq = new pair[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
				pq[i]=new pair(arr[i],i);
			}
			Arrays.sort(pq);
			int q = sc.nextInt();
			trair[] que =  new trair[q];
			for(int i = 0;i<q;i++) {
				que[i]=new trair(sc.nextInt(),sc.nextInt(),i);
			}
			Arrays.sort(que);
			int[] ans = new int[q];
			bit b = new bit(n);
			int nu = 0;
			for(int i=0;i<q;i++) {
				//System.out.println(i);
				while(que[i].a>nu) {
					b.add(pq[nu].y, 1);
					nu++;
				}
				int lo = 0, hi = n;
			    for(int j=0;j<33;j++) {
			        int mid = (lo+hi)/2;
			        if (b.sum(mid)<que[i].b) {
			            lo = mid;
			        } else {
			            hi = mid-1;
			        }
			    }
			    //System.out.println(que[i]+" "+lo+" "+hi);
			    //for(int f=0;f<n;f++) {
			    	//System.out.println(b.sum(f)+" "+i+" "+f);
			    //}
			    //System.out.println();
			    if (b.sum(Integer.max(lo, hi))<que[i].b) {
			        ans[que[i].c]=Integer.max(lo, hi);
			    } else {
			        ans[que[i].c]=Integer.min(lo, hi);
			    }
			}
			for(int x : ans) {
				pw.println(arr[x+1]);
			}
		}
	}
	static class bit { 
		int n;
		int[] bit;
		public bit(int n) {
			this.n=n;
			bit=new int[n+1];
		}
		void add(int ind, int c) {
			for(; ind<=n;ind|=(ind+1)) {
				bit[ind]+=c;
			}
		}
		int sum(int r) {
			int out =0;
			for(;r>=0;r=(r&(r+1))-1) {
				out+=bit[r];
			}
			return out;
		}
		int sum(int r, int l) {
			return sum(r)-sum(l-1);
		}
	}
	static class pair implements Comparable<pair>{
		int x;
		int y;
		public pair(int x, int y) {
			this.x=x;this.y=y;
		}
		@Override
		public int compareTo(pair o) {
			return x==o.x?Integer.compare(y,o.y):Integer.compare(o.x, x);
		}
		public String toString() {
			return x+" "+y;
		}
		
	}
	static class trair implements Comparable<trair> {
		int a,b,c;

		public trair(int x, int y,int z) {
			this.a=x;this.b=y;c=z;
		}
		@Override
		public int compareTo(trair o) {
			// TODO Auto-generated method stub
			return Integer.compare(a, o.a);
		} 
		public String toString() {
			return a+" "+b+" "+c;
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