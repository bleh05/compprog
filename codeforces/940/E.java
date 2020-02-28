    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            FastReader scan = new FastReader();
            //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
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
                int m = sc.nextInt();
                int[] arr= new int[n];
                long[] prefs = new long[n+1];
                for(int i=0;i<n;i++){
                    arr[i]=sc.nextInt();
                    prefs[i+1]=prefs[i]+arr[i];
                }
                spt rmq = new spt(n,arr);
                long[] dp = new long[n+1];
                for(int i=1;i<=Math.min(n,m);i++){
                    dp[i]=prefs[i];
                }
                for(int i=m;i<=n;i++){
                    dp[i]=Math.min(dp[i-1]+arr[i-1],dp[i-m]+prefs[i]-prefs[i-m]-rmq.query(i-m,i-1));
                }
                pw.println(dp[n]);
            }
        }
        static class spt{
            int n;
            int[][] st;
            spt(int n,int[] x){
                this.n=n;
                st =new int[n][20];
                for(int i=0;i<n;i++) {
                    st[i][0] = x[i];
                }
                for (int j = 1; (1 << j) <= n; j++) {
                    for (int i = 0; (i + (1 << j) - 1) < n; i++) {
                        if (st[i][j - 1] < st[i + (1 << (j - 1))][j - 1]) //change for max query
                            st[i][j] = st[i][j - 1];
                        else
                            st[i][j] = st[i + (1 << (j - 1))][j - 1];
                    }
                }
            }
            int query(int L, int R)
            {
                int j = (int)(Math.log(R - L + 1)/Math.log(2));
                if (st[L][j] <= st[R - (1 << j) + 1][j]) //change for maxquery
                    return st[L][j];

                else
                    return st[R - (1 << j) + 1][j];
            }

        }
        static class tup implements Comparable<tup> {
            int a, b;

            tup() {
            }
            ;



            tup(int a, int b) {
                this.a=a;
                this.b=b;
            }

            @Override
            public int compareTo(tup o2) {
                return Double.compare((double)o2.a/o2.b,(double)a/b);
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
        static void shuffle(int[] a,int l, int rb) {
            Random get = new Random();
            for (int i = l; i < rb; i++) {
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