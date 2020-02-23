import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader scan = new FastReader();
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Task solver = new Task();
        int t = scan.nextInt();
        //int t = 1;
        for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
        out.close();
    }
    static class Task {
        public void solve(int testNumber, FastReader sc, PrintWriter pw) {
            int x = sc.nextInt();
            HashSet<Integer> hs = new HashSet<>();
            for(int i=1;i<=2*x;i++){
                hs.add(i);
            }
            int[] arr = new int[2*x];
            for(int i=0;i<2*x;i+=2){
                arr[i]=sc.nextInt();
                hs.remove(arr[i]);
            }
            //pw.println(hs);
            for(int i=1;i<2*x;i+=2){
                if(hs.contains(arr[i-1]+1)){
                    arr[i]=arr[i-1]+1;
                    hs.remove(arr[i]);
                }
                else{
                    for(int j=arr[i-1];j<=2*x;j++){
                        if(hs.contains(j)){
                            arr[i]=j;
                            hs.remove(j);
                            break;
                        }
                        if(j==2*x){
                            pw.println(-1);
                            return;
                        }
                    }
                }
            }
            for(int t : arr){
                pw.print(t+" ");
            }
            pw.println();
        }
    }
    static class tup implements Comparable<tup> {
        int a, b;

        tup() {
        }

        ;

        tup(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(tup o2) {
            return Integer.compare(b, o2.b);
        }
        public String toString(){
            return a+" "+b;
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