import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class template {
    public static void main(String[] args) throws IOException {
        FastReader scan = new FastReader();
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("something.in")));
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
            int m = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            shuffle(arr);
            Arrays.sort(arr);
            int ct = 0;
            long sum = 0;
            Set<Integer> occ = new HashSet<Integer>();
            Queue<Integer> bfs = new LinkedList<>();
            StringBuilder sb= new StringBuilder();
            for(int x : arr){
                bfs.add(x+1);
                bfs.add(x-1);
                occ.add(x);
            }
            while(ct!=m&&!bfs.isEmpty()){
                int x = bfs.poll();
                if(occ.contains(x))continue;
                occ.add(x);
                int ind = -Arrays.binarySearch(arr,x)-1;
                int d = 0;
                if(ind >=n)
                    d=Math.abs(x-arr[n-1]);
                else if(ind ==0)
                    d=Math.abs(x-arr[0]);
                else d = Math.min(Math.abs(x-arr[ind-1]),Math.abs(x-arr[ind]));
                sb.append(x+" ");
                //pw.println(ind+" "+x);
                sum+=d;
                ct++;
                bfs.add(x+1);
                bfs.add(x-1);
            }
            pw.println(sum);
            pw.println(sb);
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