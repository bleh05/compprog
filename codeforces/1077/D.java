import java.io.*;
import java.util.*;

public class template {
	public static void main(String[] args) throws IOException {
		FastReader scan = new FastReader();
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("radio.out")));
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
			int t = sc.nextInt();
			HashMap<Integer,Integer> freq = new HashMap<Integer,Integer>();
			for(int i=0;i<n;i++){
				int tt = sc.nextInt();
				freq.put(tt,freq.containsKey(tt)?freq.get(tt)+1:1);
			}
			ArrayList<pair> x = new ArrayList<pair>();
			for(int xa: freq.keySet()){
				x.add(new pair(xa,freq.get(xa)));
			}

			Collections.sort(x);
			int out= 0;
			ArrayList<Integer> aaa = new ArrayList<Integer>();
			int ans = 0;
			int lo = 1, hi = n;
			for(int j=0;j<33;j++) {
				int mid = (lo+hi)/2;
				if (get(mid,x,t)>0) {
					lo = mid;
				} else {
					hi = mid-1;
				}
			}
			if (get(Math.max(lo, hi),x,t)>0) {
				ans =  Math.max(lo, hi);
			} else {
				ans =  Math.min(lo, hi);
			}
			int totelem = t*ans;
			int ind = 0;
			while(totelem>0){
				if(ind>=x.size())break;
				if(x.get(ind).b>=ans) {
					totelem-=ans;
					aaa.add(x.get(ind).a);
					x.get(ind).b-=ans;
				}
				else{
					ind++;
				}
			}
			//pw.println(ans);
			if(aaa.size()==0)return;
			pw.print(aaa.get(0));
			for(int i=1;i<aaa.size();i++){
				pw.print(" "+aaa.get(i));
			}
			pw.println();
		}
		public static int get(int a, ArrayList<pair> b,int t) {
			long totelem=t*a;
			int ind = 0;
			while(totelem>0){
				//System.out.println(a+" "+ind+" "+totelem);
				if(ind>=b.size()||b.get(ind).b<a)return -1;
				totelem-=b.get(ind).b-b.get(ind).b%a;
				ind++;
			}
			return ind;
		}
	}
	static class pair implements Comparable < pair>{
		int a,b;
		public pair(int a, int b){
			this.a=a;
			this.b=b;
		}

		@Override
		public int compareTo(pair o) {
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