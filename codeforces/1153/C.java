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
            public void solve(int testNumber, FastReader sc, PrintWriter pw) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                if(n%2==1){
                    pw.println(":(");
                    return;
                }
                String str = sc.nextLine();
                int ct = 0;
                int pct = n/2;
                int nct = n/2;
                for(char x: str.toCharArray()){
                    arr[ct++]=x=='('?1:x==')'?-1:0;
                    if(x=='('){
                        pct--;
                    }
                    if(x==')'){
                        nct--;
                    }
                }
                if(pct<0||nct<0) {
                    pw.println(":(");
                    return;
                }
                if(arr[0]!=1){
                    if(arr[0]==-1){
                        pw.println(":(");
                        return;
                    }
                    arr[0]=1;
                    pct--;
                }
                int[] pref = new int[n];
                for(int i=0;i<n;i++){
                    if(i==n-1){
                        pref[i]=pref[i-1]-1;
                        if(arr[i]==1){
                            pw.println(":(");
                            return;
                        }
                        else if(arr[i]==0){
                            nct--;
                        }
                        arr[i]=-1;
                    }
                    else if(i==0){
                        pref[i]=1;
                    }
                    else {
                        if (arr[i] != 0) {
                        }
                        else{
                            if(pct>0){
                                pct--;
                                arr[i]=1;
                            }
                            else{
                                nct--;
                                arr[i]=-1;
                            }
                        }
                        pref[i]=arr[i]+pref[i-1];
                    }
                    //pw.println(Arrays.toString(pref));
                    if(i<n-1&&pref[i]==0){
                        pw.println(":(");
                        return;
                    }
                }
                StringBuilder sb = new StringBuilder();
                for(int x : arr){
                    if(x==-1)
                        sb.append(")");
                    if(x==1)
                        sb.append("(");
                }
                pw.println(sb);
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
                return Double.compare((double)o2.a/o2.b,(double)a/b);
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