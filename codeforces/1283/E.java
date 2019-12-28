import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader scan = new FastReader();
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter()));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Task solver = new Task();
        //int t = scan.nextInt();
        int t = 1;
        for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
        out.close();
    }
    static class Task {
        int mod = 998244353;
        public void solve(int testNumber, FastReader sc, PrintWriter pw) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] freq = new int[n+1];
            int[] freq2 = new int[n+1];
            int[] set = new int[200020];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                freq[arr[i]]++;
                freq2[arr[i]]++;
            }
            Arrays.sort(arr);
            for(int i=n-1;i>=0;i--){
                if(set[arr[i]]>0){
                    set[arr[i]]++;
                    continue;
                }
                if(i<n-1&&set[arr[i]+1]>0){
                    set[arr[i]+1]++;
                    continue;
                }
                else{
                    set[arr[i]-1]++;
                    freq[arr[i]-1]++;
                    freq[arr[i]]--;
                }
            }
            int min = 0;
            for(int a : set){
                min+=a>0?1:0;
            }
            set=new int[200020];
            for(int i=n-1;i>=0;i--){
                if(set[arr[i]]>0&&set[arr[i]+1]>0){
                    set[arr[i]-1]++;
                }
                else if(set[arr[i]+1]>0){
                    set[arr[i]]++;
                }
                else{

                    set[arr[i]+1]++;
                }
            }
            int max = 0;
            for(int a : set){
                max+=a>0?1:0;
            }
            pw.println(min+" "+max);
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
    static class bit {
        int n;
        int[] bit;
        public bit(int n) {
            this.n=n;
            bit=new int[n+1];
        }
        void add(int  ind, int c) {
            for(; ind<n;ind|=(ind+1)) {
                bit[ind]+=c;
            }
        }
        int sum(int r) {
            int out =0;
            for(;r>=0;r=(r&(r+1))-1) {
                out+=bit[r];
            }
            return out;
        }
        int sum(int r, int l) {
            return sum(r)-sum(l-1);
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