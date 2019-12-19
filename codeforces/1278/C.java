import java.io.*;
import java.util.*;

public class template {
	public static void main(String[] args) throws IOException {
		FastReader scan = new FastReader();
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowmbat.out")));
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
			int[] arr = new int[2*n];
			int ct =0;
			for(int i=0;i<2*n;i++){
				arr[i]=sc.nextInt()==2?1:-1;
				ct+=arr[i];
			}
			int[] pre1 = new int[n];
			int[] pre2 = new int[n];
			pre1[0]=arr[n-1];
			for(int i=1;i<n;i++){
				pre1[i]=pre1[i-1]+arr[n-1-i];
			}
			pre2[0]=arr[n];
			for(int i=1;i<n;i++){
				pre2[i]=pre2[i-1]+arr[i+n];
			}
			//pw.println(Arrays.toString(pre1));
			//pw.println(Arrays.toString(pre2));
			HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
			for(int i=0;i<n;i++){
				if(hm.get(pre1[i])==null){
					hm.put(pre1[i],i+1);
				}
			}
			HashMap<Integer, Integer> hm2 = new HashMap<Integer,Integer>();
			hm.put(0,0);
			hm2.put(0,0);
			for(int i=0;i<n;i++){
				if(hm2.get(pre2[i])==null){
					hm2.put(pre2[i],i+1);
				}
			}
			int min = Integer.MAX_VALUE;
			if(ct==0){
				pw.println(0);
				return;
			}
			else if(ct<0){
				for(int i=0;i>=ct;i--){
					int a = ct-i;
					int b = i;
					//System.out.println(a+" "+b);
					if(hm.get(a)!=null&&hm2.get(b)!=null)
					min=Math.min(hm.get(a)+hm2.get(b),min);
				}
			}
			else{
				for(int i=0;i<=ct;i++){
					int a = ct-i;
					int b = i;
					if(hm.get(a)!=null&&hm2.get(b)!=null)
						min=Math.min(hm.get(a)+hm2.get(b),min);
				}
			}
			//pw.println(hm);
			//pw.println(hm2);
			pw.println(min);
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
	static class pair{
		int s, we;
		pair(int s, int we){
			this.s=s;
			this.we=we;
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