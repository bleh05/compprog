import java.io.*;
import java.util.*;

public class template {
    public static void main(String[] args) throws IOException {
        FastReader scan = new FastReader();
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Task solver = new Task();
        int t = scan.nextInt();
        //int t = 1;
        for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
        out.close();
    }
    static class Task {
        public void solve(int testNumber, FastReader sc, PrintWriter pw) {
            int n =sc.nextInt();
            int m =sc.nextInt();
            long upper = m;
            long lower = m;
            int lt = 0;
            boolean x = true;
            for(int i=0;i<n;i++){
                int a = sc.nextInt()-lt;
                lt+=a;
                int b = sc.nextInt();
                int c = sc.nextInt();
                if(x&&(b>upper+a||c<lower-a)){
                    pw.println("NO");
                    x=false;
                }
                upper = Math.min(c,upper+a);
                lower = Math.max(b,lower-a);
                //pw.println(upper+" "+lower);
            }
            if(x) {
                pw.println("YES");
            }
        }

    }
    static class tup implements Comparable<tup>{
        int a, b,c;
        tup(){};
        tup(int a, int b, int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }

        @Override
        public int compareTo( tup o2) {
            return o2.b!=b?Integer.compare(o2.b,b):Integer.compare(o2.a,a);
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
                bit[ind]=Math.max(bit[ind],c);
            }
        }
        int getMax(int r) {
            int ret = Integer.MIN_VALUE;
            for (; r >= 0; r = (r & (r + 1)) - 1)
                ret = Math.max(ret, bit[r]);
            return ret;
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