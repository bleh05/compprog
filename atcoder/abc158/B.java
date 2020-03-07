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
        public void solve(int testNumber, FastReader sc, PrintWriter pw){
            long n = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long sum = Math.min(n%(b+c),b);
            sum+=(n/(b+c))*b;
            pw.println(sum);
        }
    }
    static class tup implements Comparable<tup> {
        int a, b,c,d;
        tup() {
        }
        ;
        tup(int a,int b, int c,int d) {
            this.a=a;
            this.b=b;
            this.c=c;
            this.d=d;
        }
        @Override
        public int compareTo(tup o2) {
            return a==o2.a?Integer.compare(c,o2.c):Integer.compare(a,o2.a);
        }
    }

    static class bit {
        int n;
        int[] bit;
        public bit(int n) {
            this.n=n;
            bit=new int[n+1];
        }
        void add(int ind, int c) {
            for(; ind<n;ind|=(ind+1)) {
                bit[ind]+=c;
            }
        }
        int sum(int r) {
            int out =0;
            for(;r>=0;r=(r&(r+1))-1) {
                out+=bit[r];
            }
            return out;
        }
        int sum(int r, int l) {
            return sum(r)-sum(l-1);
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
                } catch (IOException e) { e.printStackTrace();
                }return str;
        }
    }
}