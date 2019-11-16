import java.io.*;
import java.util.*;

public class template {
	public static void main(String[] args) throws IOException {
		FastReader scan = new FastReader();
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
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
			int[] x = new int[n];
			for(int in = 0;in < n;in++) {
				x[in]=sc.nextInt();
			}
			Set<Integer> s = new HashSet<Integer>();
			Set<Integer> d = new HashSet<Integer>();
			boolean no = false;
			ArrayList<Integer> st = new ArrayList<Integer>();
			st.add(0);
			for(int i=0;i<n;i++) {
				
				if(x[i]>0) {
					if(d.contains(x[i])||s.contains(x[i])) {
						no=true;
						break;
					}
					s.add(x[i]);
					d.add(x[i]);
				}else {
					if(s.contains(-x[i])==false) {
						no=true;
						break;
					}
					s.remove(-x[i]);
				}
				if(s.isEmpty()) {
					st.add(i+1);
					d=new HashSet<Integer>();
				}
			}
			if(!no&&st.size()>1&&s.size()==0) {
				pw.println(st.size()-1);
				pw.print(st.get(1)-st.get(0));
				for(int i=1;i<st.size()-1;i++) {
					pw.print(" "+(st.get(i+1)-st.get(i)));
				}
			}
			else pw.println(-1);
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