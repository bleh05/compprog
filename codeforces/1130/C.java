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
                int x1 = sc.nextInt()-1, y1= sc.nextInt()-1, x2=sc.nextInt()-1,y2=sc.nextInt()-1;
                char[][] arr = new char[n][n];
                boolean[][] vis = new boolean[n][n];
                boolean[][] vis2 = new boolean[n][n];
                for(int i=0;i<n;i++){
                    arr[i]=sc.nextLine().toCharArray();
                }
                int[] q = new int[500000];
                int pu = 1;
                int po = 0;
                q[0]=n*x1+y1;
                ArrayList<Integer> ch = new ArrayList<>();
                ArrayList<Integer> ch2 = new ArrayList<>();
                int[] dx = {-1,1,0,0};
                int[] dy = {0,0,-1,1};
                while(po!=pu){
                    int poll = q[po++];
                    int x = poll/n;
                    int y = poll%n;
                    ch.add((x)*n+y);
                    vis[x][y]=true;
                    for(int i=0;i<4;i++){
                        if(x+dx[i]<0||y+dy[i]<0||x+dx[i]>=n||y+dy[i]>=n)continue;
                        if(!vis[x+dx[i]][y+dy[i]]&&arr[x+dx[i]][y+dy[i]]=='0'){
                            vis[x+dx[i]][y+dy[i]]=true;
                            q[pu++]=(x+dx[i])*n+y+dy[i];
                        }
                    }
                }
                q[pu++]=n*x2+y2;
                while(po!=pu){
                    int poll = q[po++];
                    int x = poll/n;
                    int y = poll%n;
                    vis2[x][y]=true;
                    ch2.add((x)*n+y);
                    for(int i=0;i<4;i++){
                        if(x+dx[i]<0||y+dy[i]<0||x+dx[i]>=n||y+dy[i]>=n)continue;
                        if(!vis2[x+dx[i]][y+dy[i]]&&arr[x+dx[i]][y+dy[i]]=='0'){
                            vis2[x+dx[i]][y+dy[i]]=true;
                            q[pu++]=(x+dx[i])*n+y+dy[i];
                        }
                    }
                }
                int mind = Integer.MAX_VALUE;
                //pw.println(ch);
                //pw.println(ch2);
                for(int x : ch){
                    for(int y : ch2){
                        mind = Math.min(mind,(x/n-y/n)*(x/n-y/n)+(x%n-y%n)*(x%n-y%n));
                    }
                }
                pw.println(mind);
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