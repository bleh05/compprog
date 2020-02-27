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
                tup[] arr = new tup[n];
                int sum =0;
                for(int i=0;i<n;i++){
                    arr[i]=new tup(sc.nextLine());
                    sum+=arr[i].c.length();
                }
                Arrays.sort(arr);
                int[] nn = new int[sum];
                int[] pref = new int[sum];
                int ctr = 0;
                for(tup x : arr){
                    for(char y : x.c.toCharArray()){
                        nn[ctr++]=y=='h'?1:0;
                    }
                }
                pref[sum-1]=nn[sum-1];
                for(int i=sum-2;i>=0;i--){
                    pref[i]=pref[i+1]+nn[i];
                }
                //pw.println(Arrays.toString(pref));
                long ssum =0;
                for(int i=0;i<sum;i++){
                    if(nn[i]==0){
                        ssum+=pref[i];
                    }
                }
                pw.println(ssum);
            }
        }
        static class tup implements Comparable<tup> {
            int a, b;String c;

            tup() {
            }
            ;



            tup(String c) {
                a=0;
                b=0;
                this.c=c;
                for(char s : c.toCharArray()){
                    if(s=='s'){
                        a++;
                    }
                    else{
                        b++;
                    }
                }
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