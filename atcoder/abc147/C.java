import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader scan = new FastReader();
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowmbat.out")));
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
            pair[][] pp = new pair[n][];
            for(int i=0;i<n;i++){
                int j = sc.nextInt();
                pp[i]=new pair[j];
                for(int k=0;k<j;k++){
                    pp[i][k]=new pair(sc.nextInt(),sc.nextInt());
                }
            }
            int max = 0;
            loop:
            for(int i =0;i<(1<<n);i++){
                int ct = 0;
                for(int j=0;j<n;j++){
                    if((i&(1<<(j)))>0) {
                        for (int k = 0; k < pp[j].length; k++) {
                            if(((i&(1<<(pp[j][k].a-1)))>0&&pp[j][k].b==0)||((i&(1<<(pp[j][k].a-1)))==0&&(pp[j][k].b==1))){
                                continue loop;
                            }
                        }
                    }
                }
                int t = i;
                //pw.println(i);
                while(t>0){
                    if(t%2==1){
                        ct++;
                    }
                    t>>=1;
                }
                max = Math.max(ct,max);
            }
            pw.println(max);
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
        int a, b;
        pair(int a, int b){
            this.a=a;
            this.b=b;
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