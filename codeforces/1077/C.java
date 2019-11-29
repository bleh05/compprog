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
			long[] arr = new long[n];
			long sum = 0;
			HashMap<Long,Integer> s= new HashMap<>();
			for(int i=0;i<n;i++){
				arr[i]=sc.nextInt();
				s.put(arr[i],s.get(arr[i])==null?1:s.get(arr[i])+1);
				sum+=arr[i];
			}
			ArrayList<Integer> ar= new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				long ns = sum-arr[i];
				//pw.println(ns);
				if(ns%2==0&&s.get(ns/2)!=null&&((ns/2!=arr[i]&&s.get(ns/2)>0)||(ns/2==arr[i]&&s.get(ns/2)>1))){
					ar.add(i+1);
				}
			}
			pw.println(ar.size());
			if(ar.size()==0)return;
			pw.print(ar.get(0));
			for(int i=1;i<ar.size();i++){
				pw.print(" "+ar.get(i));
			}
			pw.println();
		}
	}
	static class pair{
		long a,b;
		public pair(long a, long b){
			this.a=a;
			this.b=b;
		}

		public long getD(pair o) {
			return (o.a-a)*(o.a-a)+(o.b-b)*(o.b-b);
		}

		@Override
		public String toString() {
			return a+" "+b;
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