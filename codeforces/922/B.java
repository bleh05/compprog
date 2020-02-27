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
                int n =sc.nextInt();
                int ct = 0;
                for(int i=1;i<=n;i++){
                    for(int j=i+1;j<=n;j++){
                        int d = i^j;
                        if(d<i||d<j)continue;
                        if(d>0&&d<=n&&i<d+j&&j<i+d&&d<i+j){
                            ct++;
                        }
                    }
                }
                pw.println(ct);
            }
        }
        static class tup implements Comparable<tup> {
            int a, b, c;

            tup() {
            }
            ;



            tup(int a, int b, int c,int d) {
                this.a = a;
                this.b = b;
                this.c = c;
            }

            @Override
            public int compareTo(tup o2) {
                return Integer.compare(o2.a,a)+Integer.compare(o2.b,b)+Integer.compare(o2.b,b);
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