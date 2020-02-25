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
            int sum = 0;
            int[] arr = new  int [n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                sum+=arr[i];
            }
            sum=Integer.MAX_VALUE;
            for(int coord = 0;coord<100;coord++) {
                int m = 0;
                for (int i = 0; i < n; i++) {
                    m += (arr[i] - coord) * (arr[i] - coord);
                }
                sum=Math.min(sum,m);
            }
            pw.println(sum);
        }
    }

    static class bit {
        int n;
        long[] bit;
        public bit(int n) {
            this.n=n;
            bit=new long[n+1];
        }
        void add(int ind, int c) {
            for(; ind<=n;ind|=(ind+1)) {
                bit[ind]+=c;
            }
        }
        long sum(int r) {
            long out =0;
            for(;r>=0;r=(r&(r+1))-1) {
                out+=bit[r];
            }
            return out;
        }
        long sum(int r, int l) {
            return sum(r)-sum(l-1);
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