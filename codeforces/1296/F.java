import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader scan = new FastReader();
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
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
            ArrayList<Integer>[] adjl = new ArrayList[n+1];
            for(int i =0 ;i<=n;i++){
                adjl[i]=new ArrayList<>();
            }
            int[] ind = new int[25020000];
            for(int i=1;i<n;i++){
                int a = sc.nextInt();int b = sc.nextInt();adjl[a].add(b);adjl[b].add(a);
                ind[a*5001+b]=i-1;
            }
            lcaq l = new lcaq(n+1,1,adjl);
            int[] bfs = new int[n+1];
            Queue<Integer > q = new LinkedList<>();
            q.add(1);
            Arrays.fill(bfs,Integer.MAX_VALUE);
            bfs[1]=0;
            while(!q.isEmpty()){
                int x = q.poll();
                for(int a : adjl[x]){
                    if(bfs[a]== Integer.MAX_VALUE){
                        bfs[a]=bfs[x]+1;
                        q.add(a);
                    }
                }
            }
            int s = sc.nextInt();
            int[]qs[]=new int[s][3];
            int[] mins = new int[n-1];
            Arrays.fill(mins,1);
            for(int i=0;i<s;i++){
                int a = sc.nextInt();
                int b =sc.nextInt();
                int c = sc.nextInt();
                int x = l.lca(a,b);
                qs[i][0]=a;
                qs[i][1]=b;
                qs[i][2]=c;
                q.add(a);
                while (!q.isEmpty()){
                    int t = q.poll();
                    if(t==x){
                        break;
                    }
                    for(int asd : adjl[t]){
                        if(bfs[asd]+1==bfs[t]){
                            int in = Math.max(ind[t*5001+asd],ind[asd*5001+t]);
                            mins[in]=Math.max(mins[in],c);
                            q.add(asd);
                            break;
                        }
                    }
                }
                q.add(b);
                while (!q.isEmpty()){
                    int t = q.poll();
                    if(t==x){
                        break;
                    }
                    for(int asd : adjl[t]){
                        if(bfs[asd]+1==bfs[t]){
                            int in = Math.max(ind[t*5001+asd],ind[asd*5001+t]);
                            mins[in]=Math.max(mins[in],c);
                            q.add(asd);
                            break;
                        }
                    }
                }
            }
            for(int[] x : qs){
                q.add(x[0]);
                int ct = 0;
                int z = l.lca(x[0],x[1]);
                while (!q.isEmpty()){
                    if(ct>0)break;
                    int t = q.poll();
                    if(t==z){
                        break;
                    }
                    for(int asd : adjl[t]){
                        if(bfs[asd]+1==bfs[t]){
                            int in = Math.max(ind[t*5001+asd],ind[asd*5001+t]);
                            if(mins[in]==x[2]){
                                ct++;
                            }
                            q.add(asd);
                            break;
                        }
                    }
                }
                q=new LinkedList<>();
                q.add(x[1]);
                while (!q.isEmpty()){
                    if(ct>0)break;
                    int t = q.poll();
                    if(t==z){
                        break;
                    }
                    for(int asd : adjl[t]){
                        if(bfs[asd]+1==bfs[t]){
                            int in = Math.max(ind[t*5001+asd],ind[asd*5001+t]);
                            if(mins[in]==x[2]){
                                ct++;
                            }
                            q.add(asd);
                            break;
                        }
                    }
                }
                q=new LinkedList<>();
                if(ct==0){
                    pw.println(-1);
                    return;
                }
            }
            for(int i=0;i<n-1;i++){
                pw.print(mins[i]+" ");
            }
        }
    }
    static class lcaq{
        int n, l;
        int timer;
        int[] in;
        int[] out;
        ArrayList<Integer>[] adjl;
        ArrayList<ArrayList<Integer>> up;
        lcaq(int n,int root,ArrayList<Integer>[] adjl){
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
            for(int x : adjl[v]){
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
    static class tup implements Comparable<tup>,Comparator<tup>{
        int a, b,c,d;
        tup(){};
        tup(int a, int b,int c, int d){
            this.a=a;
            this.b=b;
            this.c=c;
            this.d=d;
        }

        @Override
        public int compareTo(tup o) {
            return a!=o.a?Integer.compare(o.a,a):Integer.compare(o.b,b);
        }

        @Override
        public int compare(tup o1, tup o2) {
            return o2.b!=o1.b?Integer.compare(o2.b,o1.b):Integer.compare(o2.a,o1.a);
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