    import java.io.*;
    import java.lang.reflect.Array;
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
            public void solve(int testNumber, FastReader sc, PrintWriter pw) {
                PriorityQueue<tup> pq=  new PriorityQueue<>();
                int n = sc.nextInt();
                int m = sc.nextInt();
                int[] ans = new int[n];
                tup[] arr= new tup[m];
                HashMap<Integer,Integer> hm = new HashMap<>();
                for(int i=0;i<m;i++){
                    arr[i]=new tup(sc.nextInt(),sc.nextInt(),sc.nextInt(),i+1);
                    ans[arr[i].b-1]=m+1;
                    hm.put(i+1,arr[i].b-1);
                }
                Arrays.sort(arr,new tup());
                int ctr = 0;
                for(int i=0;i<n;i++){
                    while(ctr<m&&i+1>=arr[ctr].a){
                        pq.add(arr[ctr++]);
                    }
                    if(pq.size()==0){
                        continue;
                    }
                    if(ans[i]!=0){
                        continue;
                    }
                    else{
                        tup x = pq.peek();
                        x.c--;
                        if(hm.get(x.d)<i){
                            pw.println(-1);
                            return;
                        }
                        if(x.c==0){
                            pq.poll();
                        }
                        ans[i]=x.d;
                    }
                }
                if(!pq.isEmpty()){
                    pw.println(-1);
                    return;
                }
                for(int x : ans){
                    pw.print(x+" ");
                }
                pw.println();
            }
        }
        static class tup implements Comparable<tup>,Comparator<tup> {
            int a, b, c, d;

            tup() {
            }
            ;



            tup(int a, int b, int c,int d) {
                this.a = a;
                this.b = b;
                this.c = c;
                this.d=d;
            }

            @Override
            public int compareTo(tup o2) {
                return b==o2.b?Integer.compare(o2.c,c):Integer.compare(b, o2.b);
            }

            @Override
            public int compare(tup o1, tup o2) {
                return Integer.compare(o1.a,o2.a);
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