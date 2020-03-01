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
            public void solve(int testNumber, FastReader sc, PrintWriter pw){
                int n = sc.nextInt();
                int rd = sc.nextInt();
                ArrayList<ArrayList<Integer>> adjl = new ArrayList<>();
                ArrayList<ArrayList<Integer>> adjlr = new ArrayList<>();
                for(int i=0;i<=n;i++){
                    adjl.add(new ArrayList<>());
                    adjlr.add(new ArrayList<>());
                }
                for(int i=0;i<rd;i++){
                    int a = sc.nextInt();
                    int b=  sc.nextInt();
                    adjl.get(a).add(b);
                    adjlr.get(b).add(a);
                }
                int rr = sc.nextInt();
                int[] paths = new int[rr];
                for(int i=0;i<rr;i++){
                    paths[i]=sc.nextInt();
                }
                Queue<Integer> q = new LinkedList<>();
                int[] bfs =  new int[n+1];
                Arrays.fill(bfs,Integer.MAX_VALUE);
                bfs[paths[rr-1]]=0;
                q.add(paths[rr-1]);
                while(!q.isEmpty()){
                    int t = q.poll();
                    for(int x : adjlr.get(t)){
                        if(bfs[x]>bfs[t]+1){
                            bfs[x]=bfs[t]+1;
                            q.add(x);
                        }
                    }
                }
                int a =0;
                int b =0;
                //pw.println(Arrays.toString(bfs));
                for(int i=0;i<rr-1;i++)
                {
                    if(bfs[paths[i]]-1!=bfs[paths[i+1]]){
                        a++;
                        b++;
                    }
                    else{
                        int ct = 0;
                        for(int x : adjl.get(paths[i]))
                            if(bfs[x]+1==bfs[paths[i]]){
                                ct++;
                        }
                        if(ct>1){
                            b++;
                        }
                    }
                }
                pw.println(a+ " "+b);
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