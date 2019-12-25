import java.io.*;
import java.util.*;

public class Main {
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
        long mod = 1000000007;
        public void solve(int testNumber, FastReader sc, PrintWriter pw) {
            int n =sc.nextInt();
            int m =sc.nextInt();
            pair[][] grid  = new pair[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    grid[i][j]=new pair(sc.nextInt(),0);
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    grid[i][j].b=sc.nextInt();
                }
            }
            byte[][][] dp = new byte[n][m][33000];
            dp[0][0][grid[0][0].a-grid[0][0].b+16500]++;
            dp[0][0][grid[0][0].b-grid[0][0].a+16500]++;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(i!=0){
                        for(int k=0;k<33000;k++){
                            if(dp[i-1][j][k]>0){
                                dp[i][j][k+grid[i][j].a-grid[i][j].b]=1;
                                dp[i][j][k+grid[i][j].b-grid[i][j].a]=1;
                            }
                        }
                    }
                    if(j!=0){
                        for(int k=0;k<33000;k++){
                            if(dp[i][j-1][k]>0){
                                dp[i][j][k+grid[i][j].a-grid[i][j].b]=1;
                                dp[i][j][k+grid[i][j].b-grid[i][j].a]=1;
                            }
                        }
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for(int i=0;i<33000;i++){
                if(dp[n-1][m-1][i]>0)
                min=Math.min(min,Math.abs(i-16500));
            }
            pw.println(min);
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
    static class pair implements Comparable<pair>{
        int a, b;
        pair(int a, int b){
            this.a=a;
            this.b=b;
        }

        @Override
        public int compareTo(pair o) {
            return Integer.compare(b,o.b);
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