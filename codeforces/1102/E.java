import java.io.*;
import java.util.*;

public class template {
	public static void main(String[] args) throws IOException {
		FastReader scan = new FastReader();
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("painting.out")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		Task solver = new Task();
		//int t = scan.nextInt();
		int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}
	static class Task {
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			int num = 1;
			HashMap<Integer, pair> tm = new HashMap<Integer, pair>();
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				if(tm.containsKey(x)){
					tm.get(x).y=i;
				}
				else{
					tm.put(x,new pair(i,i));
				}
			}
			ArrayList<pair> pr = new ArrayList<pair>();
			for(pair x : tm.values()){
				pr.add(x);
			}
			Collections.sort(pr);
			int las = pr.get(0).y;
			for(int i=1;i<pr.size();i++){
				if(pr.get(i).x<las){
					las=Math.max(pr.get(i).y,las);
				}
				else{
					las = pr.get(i).y;
					num++;
				}
			}
			//System.out.println(num);
			long x = 1;
			for(int i=0;i<num-1;i++){
				x<<=1;
				x%=998244353;
			}
			pw.println(x);
		}
	}
	static class pair implements Comparable<pair>{
		int x;
		int y;
		public pair(int x, int y){
			this.x=x;this.y=y;
		}

		@Override
		public int compareTo(pair o) {
			return Integer.compare(x,o.x);
		}
		public String toString(){
			return x+" "+y;
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