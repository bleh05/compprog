import java.io.*;
import java.math.BigInteger;
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
        ArrayList<ArrayList<Integer>> adjl;
        int[] mem;
        boolean oki = true;
        long mod = 998244353;
        int x=0,y=0;
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
		    oki=true;
			int n = sc.nextInt();
            int ed = sc.nextInt();
            mem=new int[n+1];
            adjl = new ArrayList<>();
            for(int i=0;i<=n;i++){
                adjl.add(new ArrayList<Integer>());
            }
            for(int i=0;i<ed;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                adjl.get(a).add(b);
                adjl.get(b).add(a);
            }
            long m = 1;
            for(int i = 1;i<=n;i++){
                if(mem[i]==0) {
                    x=0;y=0;
                    dfs(1,i);
                    if(!oki){
                        pw.println(0);
                        return;
                    }
                    m=(m*((exp(2,x)+exp(2,y))%mod))%mod;
                }
            }
            pw.println(oki?m:0);
		}
		void dfs(int color, int ind){
		    if(color==1){
		        x++;
            }
		    else y++;
		    mem[ind]=color;
		    for(int x : adjl.get(ind)){
                    if(mem[x]==color){
                        oki=false;
                        return;
                    }
                    else if(mem[x]==0)
                    dfs(color^3,x);
                }
        }
		public long exp(long base, int power){
			if(power == 0) return 1;
			if(power == 1) return (base + mod) % mod;
			long ans = exp(base,power/2);
			ans = (ans*ans + mod) % mod;
			if(power%2 == 1) ans = (ans*base + mod) % mod;
			return (ans + mod) % mod;
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