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
                int[] arr = new int[m];
                for(int i=0;i<m;i++){
                    pw.println(n);
                    arr[i]=sc.nextInt();
                    if(arr[i]==0){
                        System.exit(0);
                    }
                }
                long lo = 1, hi = n;
                for(int i=0;i<31;i++) {
                    long mid = (lo + hi) / 2;
                    pw.println(mid);
                    int x = arr[i % m] * sc.nextInt();
                    if (x == -2 || x == 2) {
                        System.exit(0);
                    }
                    if (x < 0) {
                        lo = mid + 1;
                    } else if (x == 0) {
                        System.exit(0);
                    } else {
                        hi = mid - 1;
                    }
                }
                pw.println("wtf");

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