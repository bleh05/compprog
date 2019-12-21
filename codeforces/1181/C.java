import java.io.*;
import java.util.*;

public class template {
	public static void main(String[] args) throws IOException {
		FastReader scan = new FastReader();
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowmbat.out")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		Task solver = new Task();
		//int t = scan.nextInt();
		int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}
	static class Task {
		int[][]colors;
		int[][] maxl;
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			int r= sc.nextInt();
			int c = sc.nextInt();
			colors=new int[r][c];
			for(int i=0;i<r;i++){
				String str = sc.nextLine();
				for(int j=0;j<c;j++){
					colors[i][j]=str.charAt(j)-'a';
				}
			}
			maxl= new int[r][c];
			for(int i=0;i<c;i++){
				for(int j=r-1;j>=0;j--){
					if(j==r-1){
						maxl[j][i]=1;
					}
					else{
						if(colors[j][i]==colors[j+1][i]){
							maxl[j][i]=maxl[j+1][i]+1;
						}
						else{
							maxl[j][i]=1;
						}
					}
				}
			}
			long out =0;
			/*for(int[] x : maxl){
				for(int y :x){
					pw.print(y);
				}
				pw.println();
			}*/
				for(int k=0;k<r;k++){
					int currs =0;
					for(int i=0;i<c;i++) {
						if (i == 0) {
							if (scan(i, k, maxl[k][i] * 3)){
								//System.out.println(i+" "+k);
								currs = 1;
							}
						} else {
							if (scan(i, k, maxl[k][i] * 3)) {
								//System.out.println(i+" "+k);
								if (colors[k][i] == colors[k][i - 1] && colors[k + maxl[k][i]][i] == colors[k + maxl[k][i]][i - 1] && colors[k + 2 * maxl[k][i]][i] == colors[k + 2 * maxl[k][i]][i - 1]&&maxl[k][i]==maxl[k][i-1]) {
									currs += 1;
								} else {
									currs = 1;
								}
							} else {
								currs = 0;
							}
						}
						//System.out.println(currs);
						out += currs;
					}
				}
			pw.println(out);
		}
		public boolean scan(int x, int y, int len){
			if(y+len>colors.length)return false;
			return (maxl[y][x]==maxl[y+(len/3)][x]&&maxl[y][x]<=maxl[y+(2*len/3)][x]&&colors[y][x]!=colors[y+(len/3)][x]&&colors[y+(len/3)][x]!=colors[y+(2*len/3)][x]);
		}
		/*public static long exp(long base, int power){
			if(power == 0) return 1;
			if(power == 1) return (base + mod) % mod;
			long ans = exp(base,power/2);
			ans = (ans*ans + mod) % mod;
			if(power%2 == 1) ans = (ans*base + mod) % mod;
			return (ans + mod) % mod;
		}*/

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
	static void shuffle(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			int temp = a[i];
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