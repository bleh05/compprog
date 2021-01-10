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
                int n = sc.nextInt();
                int m = sc.nextInt();
                int k = sc.nextInt();
                int p =sc.nextInt();
                int l = sc.nextInt();
                int[][] type1 = new int[m+1][2];
                for(int i=0;i<m;i++){
                    type1[i][0]=sc.nextInt();
                }
                for(int i=0;i<m;i++){
                    type1[i][1]=sc.nextInt();
                }
                type1[m][0]=p;
                type1[m][1]=0;
                tup[] type2 = new tup[k];
                for(int i=0;i<k;i++){
                    type2[i]=new tup(0,sc.nextInt());
                }
                for(int i=0;i<k;i++){
                    type2[i].a=sc.nextInt();
                }
                Arrays.sort(type2);
                int[] prefmax = new int[k+1];
                for(int i=1;i<=k;i++){
                    prefmax[i] = Math.max(prefmax[i-1],type2[i-1].b);
                }
                long min = (long)(n)*p;
                for(int[] x : type1){
                    long curr = 0;
                    long sp = n;
                    int ind = Arrays.binarySearch(type2,new tup(l-x[1],0));
                    if(ind<0){
                        ind=-ind-1;
                    }
                    //pw.println(ind);
                    sp -= prefmax[ind];
                    if(x[1]<=l) {
                        curr = sp * x[0];
                    }
                    else {
                        curr = sp * p;
                    }
                    //pw.println(curr+" "+sp);
                    min=Math.min(curr,min);
                }
                pw.println(min);
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