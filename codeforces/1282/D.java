import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader scan = new FastReader();
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowmbat.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)),true);
        Task solver = new Task();
        //int t = scan.nextInt();
        int t = 1;
        for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
        out.close();
    }
    static class Task {
        public void solve(int testNumber, FastReader sc, PrintWriter pw) {
            StringBuilder aaa = new StringBuilder();
            for(int i=0;i<300;i++){
                aaa.append('a');
            }
            pw.println(aaa.toString());
            int xx = sc.nextInt();
            if(xx==0){
                return;
            }
            int a = 300-xx;
            StringBuilder bbb = new StringBuilder();
            for(int i=0;i<300;i++){
                bbb.append('b');
            }
            pw.println(bbb.toString());
            xx = sc.nextInt();
            if(xx==0){
                return;
            }
            int b = 300-xx;
            StringBuilder sb = new StringBuilder();

            for(int i=0;i<a+b;i++){
                sb.append('a');
            }
            char[] str = sb.toString().toCharArray();
            int cg = b;
            for(int i=0;i<a+b-1;i++){
                str[i]='b';
                pw.println(new String(str));
                int c = sc.nextInt();
                if(c==0){
                    return;
                }
                if(c>cg){
                    str[i]='a';
                }
                else{
                    cg--;
                }
            }
            if(cg>0){
                str[a+b-1]='b';
            }
            pw.println(new String(str));
        }
		/*
		public long exp(long base, int power){
			if(power == 0) return 1;
			if(power == 1) return (base + mod) % mod;
			long ans = exp(base,power/2);
			ans = (ans*ans + mod) % mod;
			if(power%2 == 1) ans = (ans*base + mod) % mod;
			return (ans + mod) % mod;
		}*/

    }
    static class pair implements Comparable<pair>{
        int a, b,c;
        pair(int a, int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }

        @Override
        public int compareTo(pair o) {
            return Integer.compare(b,o.b);
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