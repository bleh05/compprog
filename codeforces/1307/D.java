import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        FastReader scan = new FastReader();
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Task solver = new Task();
        //nt t = scan.nextInt();
        int t = 1;
        for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
        out.close();
    }
    static class Task {
        public void solve(int testNumber, FastReader sc, PrintWriter pw) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] arr= new int[k];
            for(int i=0;i<k;i++){
                arr[i]=sc.nextInt();
            }
            int[] bfs1 = new int[n+1];
            int[] bfs2 = new int[n+1];
            ArrayList<ArrayList<Integer>> adjl = new ArrayList<>();
            for(int i=0;i<=n;i++){
                adjl.add(new ArrayList<>());
            }
            for(int i=0;i<m;i++){
                int a = sc.nextInt();
                int c = sc.nextInt();
                adjl.get(a).add(c);
                adjl.get(c).add(a);
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            Arrays.fill(bfs1,Integer.MAX_VALUE);
            bfs1[1]=0;
            while(!q.isEmpty()){
                int x = q.poll();
                for(int i : adjl.get(x)){
                    if(bfs1[i]>bfs1[x]+1){
                        bfs1[i]=bfs1[x]+1;
                        q.add(i);
                    }
                }
            }
            q.add(n);
            Arrays.fill(bfs2,Integer.MAX_VALUE);
            bfs2[n]=0;
            while(!q.isEmpty()){
                int x = q.poll();
                for(int i : adjl.get(x)){
                    if(bfs2[i]>bfs2[x]+1){
                        bfs2[i]=bfs2[x]+1;
                        q.add(i);
                    }
                }
            }
            tup[] qs = new tup[k];
            for(int i =0 ;i<k;i++){
                qs[i] = new tup(arr[i],bfs1[arr[i]],bfs2[arr[i]]);
            }
            Arrays.sort(qs);
            int maxd = Integer.MIN_VALUE;
            int ret =0;
            for(tup i : qs){
                //pw.println(i.a);
                ret = Math.max(ret,i.c+maxd);
                maxd = Math.max(maxd,i.b);
            }
            //pw.println(Arrays.toString(bfs1));
            //pw.println(Arrays.toString(bfs2));
            pw.println(Math.min(bfs1[n],ret+1));
        }
 
    }
    static class tup implements Comparable<tup>{
        int a, b, c;
        tup(){};
        tup(int a, int b,int c ){
            this.a=a;
            this.b=b;
            this.c=c;
        }
 
        @Override
        public int compareTo( tup o2) {
            return Integer.compare(b-c,o2.b-o2.c);
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