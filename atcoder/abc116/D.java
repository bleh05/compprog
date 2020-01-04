import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
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
            PriorityQueue<tup> pq = new PriorityQueue<>();
            PriorityQueue<tup> pq2 = new PriorityQueue<>();
            HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
            for(int i=0;i<n;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                pq.add(new tup(a,b));
            }
            long bonus = 0;
            long sum = 0;
            long max = 0;
            HashMap<Integer,Integer> got = new HashMap<>();
            Stack<tup> seq = new Stack<tup>();
            for(int j = 0;j<m&&!pq.isEmpty();){
                tup x = pq.poll();
                if(!got.containsKey(x.a)){
                    sum+=x.b;
                    got.put(x.a,1);
                    seq.add(x);
                    bonus++;
                    j++;
                }
                else{
                    pq2.add(x);
                }
            }
            for(int i = (int) bonus; i<m; i++){
                tup x = pq2.poll();
                sum+=x.b;
                got.put(x.a,got.get(x.a)+1);
            }
            max =  Math.max(max, sum + bonus*bonus);
            //pw.println(bonus);
            bonus-=1;
            loop:
            for(;bonus >0;--bonus){
                while(!pq2.isEmpty()){
                    tup x = pq2.poll();
                    if(got.get(x.a)!=null){
                        if(seq.isEmpty())break loop;
                        tup y = seq.pop();
                        if(got.get(y.a)==1&&y.a!=x.a){
                            got.remove(y.a);
                            got.put(x.a,got.get(x.a)+1);
                            sum-=y.b;
                            sum+=x.b;
                            if(y.b>x.b){
                                break loop;
                            }
                            max =  Math.max(max, sum + bonus*bonus);
                            //pw.println(bonus + " "+x.b+" "+y.b);
                            break;
                        }
                    }
                }
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
    static class tup implements Comparable<tup>{
        int a, b;
        tup(int a, int b){
            this.a=a;
            this.b=b;
        }

        @Override
        public int compareTo(tup o) {
            return Integer.compare(o.b,b);
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