import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader scan = new FastReader();
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
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
            int mv = sc.nextInt();
            tup[] a = new tup[mv];
            int[] dp = new int[20001];
            for(int i=0;i<mv;i++){
                a[i]=new tup(sc.nextInt(),sc.nextInt());
            }
            PriorityQueue<Integer> q = new PriorityQueue<Integer>();
            q.add(0);
            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0]=0;
            Set<Integer> inc = new HashSet<>();
            inc.add(0);
            while(!q.isEmpty()){
                int x = q.poll();
                for(int i=0;i<mv;i++){
                    if(x+a[i].a<=20000&&dp[x+a[i].a]>dp[x]+a[i].b){
                        dp[x+a[i].a]=dp[x]+a[i].b;
                        if(!inc.contains(x+a[i].a)) {
                            q.add(x + a[i].a);
                            inc.add(x + a[i].a);
                        }
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for(int i=n;i<=20000;i++){
                min = Math.min(dp[i],min);
            }
            pw.println(min);

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
            return a!=o.a?Integer.compare(a,o.a):Integer.compare(b,o.b);
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