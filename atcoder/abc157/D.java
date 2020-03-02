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
            int[] iscc;
            int[] sizecc;
            ArrayList<ArrayList<Integer>> adjl = new ArrayList<>();
            ArrayList<ArrayList<Integer>> adjlb = new ArrayList<>();
            int sum =0;
            public void solve(int testNumber, FastReader sc, PrintWriter pw){
                int n = sc.nextInt();
                int m = sc.nextInt();
                int k = sc.nextInt();
                iscc = new int[n+1];
                sizecc = new int[n+1];
                for(int i=0;i<=n;i++){
                    adjl.add(new ArrayList<>());
                    adjlb.add(new ArrayList<>());
                }
                for(int i=0;i<m;i++){
                    int t = sc.nextInt();
                    int c = sc.nextInt();
                    adjl.get(t).add(c);
                    adjl.get(c).add(t);
                }
                for(int i=0;i<k;i++){
                    int t = sc.nextInt();
                    int c = sc.nextInt();
                    adjlb.get(t).add(c);
                    adjlb.get(c).add(t);
                }
                int ctr = 1;
                for(int t = 1;t<=n;++t){
                    if(iscc[t]==0){
                        sum=1;
                        iscc[t]=ctr;
                        dfs(t,ctr++);
                        dfs2(t,sum);
                    }
                }
                for(int i=1;i<=n;i++){
                    for(int x : adjlb.get(i)){
                        if(iscc[x]==iscc[i]){
                            sizecc[i]--;
                        }
                    }
                    sizecc[i]-=adjl.get(i).size()+1;
                    pw.print(sizecc[i]+" ");
                }
                pw.println();
            }
            void dfs(int a,int f){
                for(int x : adjl.get(a)){
                    if(iscc[x]!=f){
                        iscc[x]=f;
                        sum++;
                        dfs(x,f);
                    }
                }
            }
            void dfs2(int a,int sum){
                sizecc[a]=sum;
                for(int x : adjl.get(a)){
                    if(sizecc[x]!=sum){
                        dfs2(x,sum);
                    }
                }
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