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
                int m = sc.nextInt();
                Integer[] arr=  new Integer[n];
                long sum =0;
                for(int i =0;i<n;i++){
                    arr[i]=sc.nextInt();
                }
                String str = sc.nextLine();
                int ctr = 0;
                int lch = '0';
                for(int i =0;i<n;i++){
                    if(str.charAt(i)!=lch){
                        lch = str.charAt(i);
                        Arrays.sort(arr,i-ctr,i);
                        ctr=1;
                    }
                    else ctr++;
                }
                if(ctr!=1) {
                    Arrays.sort(arr, n - ctr, n);
                }
                int[] backsu = new int[n];
                backsu[n-1]=1;
                for (int i=n-2;i>=0;i--){
                    if(str.charAt(i)==str.charAt((i+1))){
                        backsu[i]=backsu[i+1]+1;
                    }
                    else{
                        backsu[i]=1;
                    }
                }
                for(int i=0;i<n;i++){
                    if(backsu[i]<=m){
                        sum+=arr[i];
                    }
                }
                //pw.println(Arrays.toString(arr));
                pw.println(sum);
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
                return Double.compare((double)o2.a/o2.b,(double)a/b);
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