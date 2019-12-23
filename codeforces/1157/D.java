import java.io.*;
import java.math.BigInteger;
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
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
		    long sum = sc.nextInt();
		    int l = sc.nextInt();
		    sum-=(long)(l)*(l+1)/2;
		    if(sum<0){
		        pw.println("NO");
		        return;
            }
		    int[] arr = new int[l];
            int rd = (int)sum%l;
            int to = (int)sum/l;
		    for(int i=1;i<=l;i++){
		        arr[i-1]=i+to;
            }
		    for(int i=l-rd;i<l;i++){
		        arr[i]++;
            }
		    for(int i=1;i<l-1;i++){
		        if(arr[i]>arr[i-1]*2){
		            arr[i+1]+=arr[i]-arr[i-1]*2;
		            arr[i]=arr[i-1]*2;
                }
		        if(arr[i]==arr[i+1]){
		            arr[i]--;
		            arr[i+1]++;
                }
            }
            if(arr.length>1&&arr[l-1]>arr[l-2]*2){
                pw.println("NO");
                return;
            }
            pw.println("YES");
		    for(int x : arr){
		        pw.print(x+" ");
            }
		}
		/*
		public long exp(long base, int power){
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