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
			int n  =sc.nextInt();
			int check[] = new int[26];
			int next = 1;
			for(int i=0;i<n;i++){
				String str = sc.nextLine();
				boolean[] cont = new boolean[26];
				for(char x : str.toCharArray()){
					cont[x-'a']=true;
				}
				Set<Integer> group = new HashSet<Integer>();
				for(int j=0;j<26;j++){
					if(check[j]!=0&&cont[j]){
						group.add(check[j]);
					}
				}
				for(int j=0;j<26;j++){
					if(group.contains(check[j])||cont[j]){
						check[j]=next;
					}
				}
				next++;
			}
			int out = 0;
			Set<Integer> group = new HashSet<Integer>();
			for(int i=0;i<26;i++){
				if(check[i]!=0&&!group.contains(check[i])){
					group.add(check[i]);
				}
			}
			pw.println(group.size());
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