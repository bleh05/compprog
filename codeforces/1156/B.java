import java.io.*;
import java.util.*;

public class template {
	public static void main(String[] args) throws IOException {
		FastReader scan = new FastReader();
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fpot.out")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		Task solver = new Task();
		int t = scan.nextInt();
		//int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}
	static class Task {
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			String str = sc.nextLine();
			ArrayList<Character> one = new ArrayList<Character>();
			ArrayList<Character> two = new ArrayList<Character>();
			for(char x : str.toCharArray()){
				if(x%2==0){
					one.add(x);
				}
				else {
					two.add(x);
				}
			}
			Collections.sort(one);
			Collections.sort(two);
			StringBuilder stb = new StringBuilder();
			if(one.size()==0){
				for (char x : two) {
					stb.append(x);
				}
			}
			else if(two.size()==0) {
				for (char x : one) {
					stb.append(x);
				}
			}
			else if((one.get(one.size()-1)-two.get(0)==-1||one.get(one.size()-1)-two.get(0)==1)&&(one.get(0)-two.get(two.size()-1)==-1||one.get(0)-two.get(two.size()-1)==1)){
				pw.println("No answer");
				return;
			}
			else if(one.get(one.size()-1)-two.get(0)==-1||one.get(one.size()-1)-two.get(0)==1) {
				for (char x : two) {
					stb.append(x);
				}
				for (char x : one) {
					stb.append(x);
				}
			}
			else{
				for (char x : one) {
					stb.append(x);
				}
				for (char x : two) {
					stb.append(x);
				}
			}
			pw.println(stb);
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