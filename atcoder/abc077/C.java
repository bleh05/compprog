import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        FastReader scan = new FastReader();
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("colorful.out")));
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
            int[][] arr = new int[3][n];for(int i=0;i<3;i++)for(int j =0;j<n;j++)arr[i][j]=sc.nextInt();
            shuffle(arr[0]);shuffle(arr[1]);shuffle(arr[2]);
            Arrays.sort(arr[0]);Arrays.sort(arr[1]);Arrays.sort(arr[2]);
            int[] ans = new int[n];
            int ptr = 0;
            for(int i=0;i<n;i++){
                while(ptr<n&&arr[2][ptr]<=arr[1][i]){
                    ptr++;
                }
                ans[i]=n-ptr;
            }
            long[] pref = new long[n+1];
            for(int i=n-1;i>=0;i--){
                pref[i]=pref[i+1]+ans[i];
            }
            long sum = 0;
            ptr= 0;
            for(int i=0;i<n;i++){
                while(ptr<n&&arr[1][ptr]<=arr[0][i]){
                    ptr++;
                }
                sum+=pref[ptr];
            }
            pw.println(sum);
        }
    }
    static class tup implements Comparable<tup> {
        String a, b,c,d;
        tup() {
        }
        ;
        tup(String a,String b,String c,String d) {
            this.a=a;
            this.b=b;
            this.c=c;
            this.d=d;
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
                } catch (IOException e) { e.printStackTrace();
                }return str;
        }
    }
}