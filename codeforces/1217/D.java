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
        ArrayList<ArrayList<tup>> adjl = new ArrayList<>();
        int[] ans;
        boolean[] vis;
        boolean[] record;
        public void solve(int testNumber, FastReader sc, PrintWriter pw) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            for(int i=0;i<=n;i++){
                adjl.add(new ArrayList<>());
            }
            ans =  new int[m];
            vis = new boolean[n+1];
            record = new boolean[n+1];
            for(int i=0;i<m;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                adjl.get(a).add(new tup(b,i));
            }
            for(ArrayList<tup> x : adjl){
                for(tup y : x){
                    dfs(y);
                }
            }
            StringBuilder sb = new StringBuilder();
            int max = 0;
            for(int i :ans){
                max= Math.max(i,max);
                sb.append(1+i+" ");
            }
            pw.println(max+1);
            pw.println(sb);

        }
        void dfs(tup t){
            if(record[t.a]){
                ans[t.b]=1;
            }
            if(vis[t.a]){
                return;
            }
            vis[t.a]=true;
            record[t.a]=true;
            for(tup x : adjl.get(t.a)){
                dfs(x);
            }
            record[t.a]=false;
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
            return Integer.compare(Math.abs(b),Math.abs(o.b));
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