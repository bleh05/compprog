    import java.io.*;
    import java.lang.reflect.Array;
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
                int n = sc.nextInt();
                int[] arr= new int[n];
                String str = sc.nextLine();
                bit b = new bit(n);
                for(int i=0;i<n;++i){
                    arr[i]=str.charAt(i)-'a';
                    b.add(i,arr[i]);
                }
                int q = sc.nextInt();
                for(int i=0;i<q;i++){
                    if(sc.nextInt()==1){
                        int ind = sc.nextInt()-1;
                        int v = sc.next().charAt(0)-'a';
                        b.sub(ind,arr[ind]);
                        arr[ind]=v;
                        b.add(ind,arr[ind]);
                    }
                    else{
                        int a = 0;
                        int[] x = b.sum(sc.nextInt()-1,sc.nextInt()-1);
                        for(int y : x)a+=y>0?1:0;
                        //pw.println(Arrays.toString(x));
                        pw.println(a);
                    }
                }

            }
        }

        static class bit {
            int n;
            int[][] bit;
            public bit(int n) {
                this.n=n;
                bit=new int[n+1][26];
            }
            void add(int ind, int c) {
                for(; ind<n;ind|=(ind+1)) {
                    bit[ind][c]+=1;
                }
            }
            void sub(int ind, int c) {
                for(; ind<n;ind|=(ind+1)) {
                    bit[ind][c]-=1;
                }
            }
            int[] sum(int r) {
                int[] arr = new int[26];
                int out =0;
                for(;r>=0;r=(r&(r+1))-1) {
                    for(int i=0;i<26;i++){
                        arr[i]+=bit[r][i];
                    }
                }
                return arr;
            }
            int[] sum(int l,int r) {
                int[] arr1 = sum(r);
                int[] arr2 = sum(l-1);
                for(int i=0;i<26;i++){
                    arr1[i]-=arr2[i];
                }
                return arr1;
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
                return 0;
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