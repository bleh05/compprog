import java.io.*;
import java.util.*;

public class template {
	public static void main(String[] args) throws IOException {
		FastReader scan = new FastReader();
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		Task solver = new Task();
		int t = scan.nextInt();
		//int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}
	static class Task {
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			int n = sc.nextInt();
			int[] x = new int[n];
			for(int in = 0;in < n;in++) {
				x[in]=sc.nextInt();
			}
			int[] y = new int[n];
			for(int in = 0;in < n;in++) {
				y[in]=sc.nextInt();
			}
			int[] arr= new int[n];
			for(int i =0;i<n;i++) {
				arr[i]=y[i]-x[i];
			}
			boolean rr= false;
			boolean no = true;
			HashMap<Integer,ArrayList<Integer>> hm = new HashMap<Integer,ArrayList<Integer>>();
			for(int i=0;i<n;i++) {
				if(arr[i]>0) {
					if(!hm.containsKey(arr[i]))
						hm.put(arr[i], new ArrayList<Integer>());
					hm.get(arr[i]).add(i);
				}
				else if(arr[i]<0) {
					no=false;
					break;
				}
			}
			if(no) {
			//System.out.println(hm);
			if(hm.keySet().size()<=1) {
				rr=true;
				for(ArrayList<Integer> z: hm.values()) {
					if(z.size()<4) {
						for(int i=1;i<z.size();i++) {
							if(z.get(i)!=z.get(i-1)+1)rr=false;
						}
					}
				}
			}
			}
			pw.println(rr&&no?"YES":"NO");
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