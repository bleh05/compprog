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
            int rad = sc.nextInt();
            int dmg = sc.nextInt();
            tup[ ] mo = new tup[n];
            for(int i=0;i<n;i++){
                mo[i]=new tup(sc.nextInt(),sc.nextInt());
            }
            Arrays.sort(mo);
            long curdmg = 0;
            Queue<tup> range = new LinkedList<>();
            long bombs = 0;
            for(tup x : mo){
                while(range.size()>0&&x.a>range.peek().a){
                    curdmg -= range.poll().b;
                }
                long hft = x.b-curdmg;
                long tb = (hft+dmg-1)/dmg;
                if(tb>0) {
                    curdmg += tb * dmg;
                    bombs += tb;
                    range.add(new tup(x.a+2*rad,tb*dmg));
                }
                //pw.println(hft + " " + curdmg+" "+tb);
            }
            pw.println(bombs);
        }
    }
    static class tup implements Comparable<tup>{
        long a, b;
        tup(long a, long b){
            this.a=a;
            this.b=b;
        }

        @Override
        public int compareTo(tup o) {
            return a!=o.a?Long.compare(a,o.a):Long.compare(b,o.b);
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