import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader scan = new FastReader();
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)),true);
        Task solver = new Task();
        int t = scan.nextInt();
        //int t = 1;
        for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
        out.close();
    }
    static class Task {

        public void solve(int testNumber, FastReader sc, PrintWriter pw) {
            int n = sc.nextInt();
            tup[] arr = new tup[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new tup(sc.nextInt(), sc.nextInt());
            }
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            int lastb = 0;
            int lasta = 0;
            for (int i = 0; i < n - 1; i++) {
                if(arr[i].b<lastb){
                    pw.println("NO");
                    return;
                }
                if (arr[i].a<arr[i+1].a){
                    for(int j=lasta;j<arr[i].a;j++){
                        sb.append("R");
                        lasta = arr[i].a;
                    }
                    for(int j=lastb;j<arr[i].b;j++){
                        sb.append("U");
                        lastb = arr[i].b;
                    }
                }
            }
            if(arr[n-1].b<lastb){
                pw.println("NO");
                return;
            }
            for(int j=lasta;j<arr[n-1].a;j++){
                sb.append("R");
            }
            for(int j=lastb;j<arr[n-1].b;j++){
                sb.append("U");
            }
            pw.println("YES\n"+sb);
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