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
 
        public void solve(int testNumber, FastReader sc, PrintWriter pw) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> adjl = new ArrayList<>();
            for(int i=0;i<=n;i++){
                adjl.add(new ArrayList<>());
            }
            for(int i = 0;i<n-1;i++){
                int a = sc.nextInt();
                int b=  sc.nextInt();
                adjl.get(a).add(b);
                adjl.get(b).add(a);
            }
            int[] dist = new int[n+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[1]=0;
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            int l=0;
            while(!q.isEmpty()){
                l = q.poll();
                for(int x : adjl.get(l)){
                    if(dist[l]+1<dist[x]){
                        dist[x]=dist[l]+1;
                        q.add(x);
                    }
                }
            }
            //System.out.println(Arrays.toString(dist));
            int[] dist2 = new int[n+1];
            Arrays.fill(dist2,Integer.MAX_VALUE);
            dist2[l]=0;
            int r = 0;
            q.add(l);
            while(!q.isEmpty()){
                r = q.poll();
                for(int x : adjl.get(r)){
                    if(dist2[r]+1<dist2[x]){
                        dist2[x]=dist2[r]+1;
                        q.add(x);
                    }
                }
            }
            int[] dist3 = new int[n+1];
            Arrays.fill(dist3,Integer.MAX_VALUE);
            dist3[l]=0;
            q.add(l);
            //System.out.println("ayy");
            for(int x = r;dist2[x]>0;){
                dist3[x]=0;
                for(int y : adjl.get(x)){
                    if(dist2[y]+1==dist2[x]){
                        q.add(y);
                        x=y;
                        break;
                    }
                }
            }
            //System.out.println(Arrays.toString(dist3));
            //System.out.println("ch");
            int y = 0;
            while(!q.isEmpty()){
                y = q.poll();
                for(int x : adjl.get(y)){
                    if(dist3[y]+1<dist3[x]){
                        dist3[x]=dist3[y]+1;
                        q.add(x);
                    }
                }
            }
            ArrayList<Integer> leaves = new ArrayList<>();
            for(int i=0;i<=n;i++){
            	if(adjl.get(i).size()==1){
            		leaves.add(i);
            	}
            }
            if(leaves.size()==3){
            	pw.println(n-1);
            	pw.println(leaves.get(0)+" "+leaves.get(1)+" "+leaves.get(2));
            	return;
            }
            if(n==3){
            	pw.println(2);
            	pw.println(1+" "+2+" "+3);
            	return;
            }
            if(leaves.size()==2){
            	pw.println(n-1);
            	pw.print(leaves.get(0)+" "+leaves.get(1));
                int ret = 1;
                while(adjl.get(ret).size() == 1) ret++;
                pw.print(" "+ret+"\n");
            	return;
            }
            //System.out.println(Arrays.toString(dist3));
            pw.println(dist3[y]+dist2[r]);
            pw.println(r+" "+l+" "+y);
            
 
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