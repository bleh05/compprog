import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader scan = new FastReader();
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)),true);
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
            segt max = new segt(m);
            long[] backed = new long[m];
            for(int i=0;i<m;i++){
               backed[i]=i;
            }
            max.build(backed,1,0,m-1);
            for(int i=0;i<n;i++){
                long q = sc.nextInt();
                backed[(int)(q%m)]+=m;
                max.update(1,0,m-1,(int)(q%m),backed[(int)(q%m)]);
                pw.println(max.get_max(1,0,m-1,0,m-1));
            }
            //pw.println(Arrays.toString(max.t));
        }
    }
    static class segt {
        long[] t;
        public segt(int n) {
            t = new long[4*n];
        }
        void build(long a[], int v, int tl, int tr) {
            if (tl == tr) {
                t[v] = a[tl];
            } else {
                int tm = (tl + tr) / 2;
                build(a, v*2, tl, tm);
                build(a, v*2+1, tm+1, tr);
                t[v] = Math.min(t[v*2], t[v*2+1]);
            }
        }

        long get_max(int v, int tl, int tr, int l, int r) {
            if (l > r)
                return Integer.MAX_VALUE/2;
            if (l == tl && r == tr)
                return t[v];
            int tm = (tl + tr) / 2;
            return Math.min(get_max(v*2, tl, tm, l, Math.min(r, tm)),
                    get_max(v*2+1, tm+1, tr, Math.max(l, tm+1), r));
        }

        void update(int v, int tl, int tr, int pos, long new_val) {
            if (tl == tr) {
                t[v] = new_val;
            } else {
                int tm = (tl + tr) / 2;
                if (pos <= tm)
                    update(v*2, tl, tm, pos, new_val);
                else
                    update(v*2+1, tm+1, tr, pos, new_val);
                t[v] = Math.min(t[v*2], t[v*2+1]);
            }
        }
    }
    static class tup implements Comparable<tup>{
        int a, b;
        tup(int a, int b){
            this.a=a;
            this.b=b;
        }

        @Override
        public int compareTo(tup o) {
            return Integer.compare(Math.abs(b),Math.abs(o.b));
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