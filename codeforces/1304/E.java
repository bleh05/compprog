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
        public void solve(int testNumber, FastReader sc, PrintWriter pw) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> adjl = new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<=n;i++){
                adjl.add(new ArrayList<Integer>());
            }
            for(int i=0;i<n-1;i++){
                int a = sc.nextInt();
                int b=  sc.nextInt();
                adjl.get(a).add(b);
                adjl.get(b).add(a);
            }
            int[] bfs = new int[n+1];
            Arrays.fill(bfs,Integer.MAX_VALUE);
            Queue<Integer> q=  new LinkedList<>();
            q.add(1);
            bfs[1]=0;
            while(!q.isEmpty()){
                int t = q.poll();
                for(int x : adjl.get(t)){
                    if(bfs[x]>bfs[t]+1){
                        bfs[x]=bfs[t]+1;
                        q.add(x);
                    }
                }
            }
            lcaq l = new lcaq(n+1,1,adjl);
            int m = sc.nextInt();
            for(int i=0;i<m;i++){
                int ed = sc.nextInt();
                int ed2 = sc.nextInt();
                int f = sc.nextInt();
                int t = sc.nextInt();
                int tot = sc.nextInt();
                int lca = l.lca(f,t);
                int nd = bfs[f]-bfs[lca]*2+bfs[t];
                //pw.println(nd);
                int lca2 = l.lca(f,ed);
                int lca3 = l.lca(t,ed2);
                int d1 = bfs[f]-bfs[lca2]*2+bfs[ed];
                int d2 = bfs[t]-bfs[lca3]*2+bfs[ed2];
                int lca4 = l.lca(f,ed2);
                int lca5 = l.lca(t,ed);
                int d3 = bfs[f]-bfs[lca4]*2+bfs[ed];
                int d4 = bfs[t]-bfs[lca5]*2+bfs[ed2];
                //pw.println(d1);
                //pw.println(d2);
                //pw.println(tot+" "+nd+" "+d1+" "+d2);
                if((tot-nd)%2==0&&nd<=tot){
                    pw.println("YES");
                    continue;
                }
                if((tot-d1-d2-1)>=0&&(tot-d1-d2-1)%2==0){
                    pw.println("yES");
                    continue;
                }
                if((tot-d3-d4-1)>=0&&(tot-d3-d4-1)%2==0){
                    pw.println("yES");
                    continue;
                }
                pw.println("NO");
            }
        }

    }static class lcaq{
        int n, l;
        int timer;
        int[] in;
        int[] out;
        ArrayList<ArrayList<Integer>> adjl;
        ArrayList<ArrayList<Integer>> up;
        lcaq(int n,int root,ArrayList<ArrayList<Integer>> adjl){
            this.n=n;
            in= new int[n];
            out = new int[n];
            this.adjl=adjl;
            timer = 0;
            l=(int)Math.ceil(Math.log(n)/Math.log(2));
            up=new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<=n;i++){
                up.add(new ArrayList<Integer>());
            }
            dfs(root,root);
        }
        void dfs(int v, int p){
            in[v]=timer+=1;
            up.get(v).add(p);
            for(int i=1;i<=l;i++){
                up.get(v).add(up.get(up.get(v).get(i-1)).get(i-1));
            }
            for(int x : adjl.get(v)){
                if(x!=p)
                    dfs(x,v);
            }
            out[v]=timer+=1;
        }
        boolean is_ancestor(int u, int v)
        {
            return in[u] <= in[v] && out[u] >= out[v];
        }

        int lca(int u, int v)
        {
            if (is_ancestor(u, v))
                return u;
            if (is_ancestor(v, u))
                return v;
            for (int i = l; i >= 0; --i) {
                if (!is_ancestor(up.get(u).get(i), v))
                    u = up.get(u).get(i);
            }
            return up.get(u).get(0);
        }
    }
    static class tup implements Comparable<tup>{
        int a, b,c;
        tup(){};
        tup(int a, int b, int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }

        @Override
        public int compareTo( tup o2) {
            return o2.b!=b?Integer.compare(o2.b,b):Integer.compare(o2.a,a);
        }
    }

    static class bit {
        int n;
        int[] bit;
        public bit(int n) {
            this.n=n;
            bit=new int[n+1];
        }
        void add(int ind, int c) {
            for(; ind<n;ind|=(ind+1)) {
                bit[ind]=Math.max(bit[ind],c);
            }
        }
        int getMax(int r) {
            int ret = Integer.MIN_VALUE;
            for (; r >= 0; r = (r & (r + 1)) - 1)
                ret = Math.max(ret, bit[r]);
            return ret;
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