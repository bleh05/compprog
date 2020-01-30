    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            FastReader scan = new FastReader();
            //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
            Task solver = new Task();
            //int t = scan.nextInt();

            int t = 1;
            for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
            out.close();
        }
        static class Task {
            public void solve(int testNumber, FastReader sc, PrintWriter pw) {
                long n = sc.nextLong();
                long m = sc.nextLong();
                long lo = 1, hi = 1000000000000000001l;
                for(int i=0;i<63;i++) {
                    long mid = (lo+hi)/2;
                    if (get(mid,m)) {
                        hi = mid;
                    } else {
                        lo = mid+1;
                    }
                }

                if (get(Long.max(lo, hi),m)) {
                    pw.println(Math.max(0,n-Long.max(lo, hi)+1));
                } else {
                    pw.println(Math.max(0,n-Long.min(lo, hi)+1));
                }

            }
            private boolean get(long c, long m){
                long x = c;
                while(c>0){
                    x-=c%10;
                    c/=10;
                }
                return x>=m;
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
                return a!=o.a?Long.compare(a,o.a):Long.compare(o.b,b);
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