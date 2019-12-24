import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class template {
    public static void main(String[] args) throws IOException {
        FastReader scan = new FastReader();
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowmbat.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Task solver = new Task();
        int t = scan.nextInt();
        //int t = 1;
        for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
        out.close();
    }
    static class Task {
        public void solve(int testNumber, FastReader sc, PrintWriter pw) {
            int test = sc.nextInt();
            int time = sc.nextInt();
            int eas = sc.nextInt();
            int hard = sc.nextInt();
            pair[] tests = new pair[test];
            int numa=0;
            int numb=0;
            for(int i=0;i<test;i++){
                tests[i]= new pair(sc.nextInt(),0,i);
            }
            for(int i=0;i<test;i++){
                tests[i].b=sc.nextInt();
            }
            Arrays.sort(tests);
            long[] sum = new long[test+1];
            for(int i=1;i<=test;i++){
                if(tests[i-1].a==1){
                    sum[i]+=hard;
                    numb++;
                }
                else{
                    sum[i]+=eas;
                    numa++;
                }
                sum[i]+=sum[i-1];
            }
            long maxn = 0;
            //pw.println(Arrays.toString(sum));
            //pw.println(Arrays.toString(prefeas));
            for(int i=0;i<test;i++){
                int goal = Math.min(tests[i].b,time);
                long forced = sum[i];
                //pw.print(goal+" ");
                if(forced<goal) {
                    long smp = goal-forced-1;
                    long rrr = Math.min(numa, smp/ eas);
                    long tot = i + rrr + Math.min(numb, (smp - rrr * eas) / hard);
                    maxn = Math.max(tot, maxn);
                }
                if(tests[i].a==0)numa--;
                else numb--;
            }
            if(sum[test]<=time){
                maxn = test;
            }
            //pw.println();
            pw.println(maxn);
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