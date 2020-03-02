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
                int[][] arr= new int[3][3];
                for(int  i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        arr[i][j]=sc.nextInt();
                    }
                }
                int t = sc.nextInt();
                boolean[][] arr2= new boolean[3][3];
                for(int i=0;i<t;i++){
                    int s = sc.nextInt();
                    if(arr[0][0]==s){
                        arr2[0][0]=true;
                    }
                    if(arr[0][1]==s){
                        arr2[0][1]=true;
                    }
                    if(arr[0][2]==s){
                        arr2[0][2]=true;
                    }
                    if(arr[1][0]==s){
                        arr2[1][0]=true;
                    }
                    if(arr[1][1]==s){
                        arr2[1][1]=true;
                    }
                    if(arr[1][2]==s){
                        arr2[1][2]=true;
                    }
                    if(arr[2][0]==s){
                        arr2[2][0]=true;
                    }
                    if(arr[2][1]==s){
                        arr2[2][1]=true;
                    }
                    if(arr[2][2]==s){
                        arr2[2][2]=true;
                    }
                }
                if(arr2[0][0]&&arr2[0][1]&&arr2[0][2]){
                    pw.println("Yes");
                    return;
                }
                if(arr2[1][0]&&arr2[1][1]&&arr2[1][2]){
                    pw.println("Yes");
                    return;
                }
                if(arr2[2][0]&&arr2[2][1]&&arr2[2][2]){
                    pw.println("Yes");
                    return;
                }
                if(arr2[0][0]&&arr2[1][0]&&arr2[2][0]){
                    pw.println("Yes");
                    return;
                }
                if(arr2[0][1]&&arr2[1][1]&&arr2[2][1]){
                    pw.println("Yes");
                    return;
                }
                if(arr2[0][2]&&arr2[1][2]&&arr2[2][2]){
                    pw.println("Yes");
                    return;
                }
                if(arr2[0][0]&&arr2[1][1]&&arr2[2][2]){
                    pw.println("Yes");
                    return;
                }
                if(arr2[0][2]&&arr2[1][1]&&arr2[2][0]){
                    pw.println("Yes");
                    return;
                }
                pw.println("No");
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return str;
            }
        }

    }