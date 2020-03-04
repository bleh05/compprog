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
            String str = sc.nextLine();
            ArrayList<Integer> o= new ArrayList<>();
            ArrayList<Integer> w= new ArrayList<>();
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='('){
                    o.add(i+1);
                }
                if(str.charAt(i)==')'){
                    w.add(i+1);
                }
            }
            Collections.reverse(w);
            int s = 0;
            PriorityQueue< Integer> ans = new PriorityQueue<>();
            while(true){
                if(s==o.size()||s==w.size()){
                    break;
                }
                else if(o.get(s)>w.get(s)){
                    break;
                }
                else{
                    ans.add(o.get(s));
                    ans.add(w.get(s));
                }
                s++;
            }
            if(s>0) {
                pw.println(1);
                pw.println(s * 2);
                for(int i=0;i<ans.size();)
                    pw.print(ans.poll()+" ");
                pw.println();
            }
            else pw.println(0);

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
                } catch (IOException e) { e.printStackTrace();
                }return str;
        }
    }
}