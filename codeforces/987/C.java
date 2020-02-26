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
            tup[] ar = new tup[n];
            for(int i=0;i<n;i++){
                ar[i]=new tup(sc.nextInt(),0);
            }
            int[][] dp = new int[n][3];
            for(int i=0;i<n;i++){
                for(int j=0;j<3;j++){
                    dp[i][j]=Integer.MAX_VALUE/3;
                }
            }
            for(int i=0;i<n;i++) {
                ar[i].b = sc.nextInt();
                dp[i][0]=ar[i].b;
            }
            int min = Integer.MAX_VALUE;
            for (int k = 1; k < 3; ++k) {
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < i; ++j) {
                        if (ar[j].a >= ar[i].a)
                            continue;
                        dp[i][k] = Math.min(dp[i][k], dp[i][0] + dp[j][k - 1]);
                    }
                    if (k == 2)
                        min = Math.min(min, dp[i][2]);
                }
            }
                if(min>300000002){
                    pw.println(-1);
                    return;
                }
            pw.println(min);
        }
    }

    static class tup implements Comparable<tup> {
        int a, b;

        tup() {
        }

        ;

        tup(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(tup o2) {
            return a==o2.a?Integer.compare(o2.b,b):Integer.compare(o2.a, a);
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