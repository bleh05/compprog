import java.io.*;
import java.util.*;

public class template {
    public static void main(String[] args) throws IOException {
        FastReader scan = new FastReader();
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter()));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Task solver = new Task();
        int t = scan.nextInt();
        //int t = 1;
        for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
        out.close();
    }
    static class Task {
        public void solve(int testNumber, FastReader sc, PrintWriter pw) {
            ArrayList<tup> pairs = new ArrayList<tup>();
            int n = sc.nextInt();
            int total = sc.nextInt();
            int[] arr = new int[n];
            int ct1 = 0;
            int ct2 = -1;
            long sum1 = 0;
            long sum2 = 0;
            long sum = 0;
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                sum+=arr[i];
            }
            int i = 0;
            while(i<n&&sum1<total){
                sum1+=arr[i];
                pairs.add(new tup(arr[i],i++));
                ct1++;
            }
            if(pairs.size()==0){
                pw.println(1);
                return;
            }
            Collections.sort(pairs);
            sum2-=pairs.get(0).a;
            i=0;
                while(i<n&&sum2+arr[i]<=total){
                    sum2+=arr[i++];
                    ct2++;
                }
                //pw.println(ct1+" "+ct2+" "+sum2);
            if(sum<=total||ct1-1==ct2){
                pw.println(0);return;
            }
            else{
                pw.println(pairs.get(0).b+1);
            }

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
    static class tup implements Comparable<tup>{
        int a, b;
        tup(int a, int b){
            this.a=a;
            this.b=b;
        }

        @Override
        public int compareTo(tup o) {
            return Integer.compare(o.a,a);
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