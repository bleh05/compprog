import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class template {
	public static void main(String[] args) throws IOException {
		FastReader scan = new FastReader();
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fpot.out")));
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
			String str = sc.nextLine();
			String str2 = sc.nextLine();
			char[] s = new char[n];
			int c = 0;
			for(int i=n-1;i>=0;i--){
				int a = str.charAt(i)-'a'+str2.charAt(i)-'a';
				if(a+c>=26){
					s[i]= (char) ('a'+((a+c)%26));
					c=1;
				}
				else{
					s[i]=(char)('a'+a+c);
					c=0;
				}
			}
			//pw.println(new String(s));
			StringBuilder sbr = new StringBuilder();
			for(int i=0;i<n;i++){
				int add = 0;
				if(c==1){
					add+=13;
				}
				int x = (s[i]-'a');
				c=x%2;
				x/=2;
				add+=x;
				add%=26;
				add+='a';
				sbr.append((char)add);
			}
			pw.println(sbr);
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