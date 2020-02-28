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
                boolean[][] arr = new boolean[n][n];
                for(int i=0;i<n;i++){
                    String str = sc.nextLine();
                    int ct =0;
                    for(char x : str.toCharArray()){
                        int z = Integer.parseInt(x+"",16);
                        for(int j=3;j>=0;j--){
                            arr[i][ct++]=(z&(1<<j))>0;
                        }
                    }
                }
                int[][] pref = new int[n][n];
                int minp = 5500;
                for(int i=0;i<n;++i){
                    pref[i][0]=1;
                    for(int j=1;j<n;++j){
                        if(arr[i][j]==arr[i][j-1]){
                            pref[i][j]=pref[i][j-1];
                        }
                        else{
                            if(minp == 5500) {
                                minp = pref[i][j - 1];
                            }
                            else{
                                minp = gcd(minp,pref[i][j - 1]);
                            }
                        }
                        pref[i][j]++;
                    }
                    if(minp == 5500) {
                        minp = pref[i][n - 1];
                    }
                    else{
                        minp = gcd(minp,pref[i][n - 1]);
                    }
                }
                for(int i=0;i<n;++i){
                    int ctr =1;
                    for(int j=1;j<n;++j){
                        if(arr[j][i]==arr[j-1][i]){
                            ctr++;
                        }
                        else{
                            if(minp == 5500) {
                                minp = pref[i][j - 1];
                            }
                            else{
                                minp = gcd(minp,pref[i][j - 1]);
                            }
                        }
                    }
                    if(minp == 5500) {
                        minp = pref[i][n - 1];
                    }
                    else{
                        minp = gcd(minp,pref[i][n - 1]);
                    }
                }
                /*for(boolean[] x : arr){
                    pw.println(Arrays.toString(x));
                }
                for(int[] x : pref){
                    pw.println(Arrays.toString(x));
                }
                pw.println(minp);*/
                if(minp==1){
                    pw.println(1);
                    return;
                }
                if(n%minp!=0){
                    pw.println(1);
                    return;
                }
                for(int i=0;i<n;i+=minp){
                    for(int z=0;z<minp;++z) {
                        for (int j = n - 1; j >= 0; j -= minp) {
                            if (pref[i+z][j] % minp != 0 || arr[i+z][j]!=arr[i][j]) {
                                pw.println(1);
                                return;
                            }
                        }
                    }
                }
                pw.println(minp);

            }public int gcd(int a, int b) {
                if (b==0) return a;
                return gcd(b,a%b);
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