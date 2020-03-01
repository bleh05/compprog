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
            boolean[][] matrix;
            boolean[][] vis;
            public void solve(int testNumber, FastReader sc, PrintWriter pw){
                int n = sc.nextInt();
                int m = sc.nextInt();
                matrix = new boolean[n][m];
                vis = new boolean[n][m];
                long sum = 0;
                for(int i=0;i<n;i++){
                    String str = sc.nextLine();
                    for(int j=0;j<m;j++){
                        matrix[i][j]=(str.charAt(j)=='#');
                    }
                }
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        if(!vis[i][j]){
                            int[] x = dfs(i,j,matrix[i][j]);
                            sum+=((long)(x[0]))*x[1];
                        }
                    }
                }
                pw.println(sum);
            }
            public int[] dfs (int x, int y, boolean c){
                int[] dx = {-1,1,0,0};
                int[] dy = {0,0,-1,1};
                if(x<0||y<0||x>=matrix.length||y>=matrix[0].length||vis[x][y]||matrix[x][y]!=c){
                    return new int[]{0,0};
                }
                int a = 0;
                int b = 0;
                vis[x][y]=true;
                if(c){
                    a++;
                }
                else{
                    b++;
                }
                for(int i=0;i<4;i++){
                    int[] tt = dfs(x+dx[i],y+dy[i],!c);
                    a+=tt[0];
                    b+=tt[1];
                }
                return new int[]{a,b};
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