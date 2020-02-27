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
                int n = sc.nextInt();
                if(n<=2){
                    pw.println(0);
                    return;
                }
                int[] arr=  new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=sc.nextInt();
                }
                int[] pt = new int[5];
                //pw.println(Arrays.toString(arr));
                if((arr[n-1]-arr[0])%(n-1)==0){
                    pt[0]=(arr[n-1]-arr[0])/(n-1);
                }
                else if((arr[n-1]-arr[0]+1)%(n-1)==0){
                    pt[1]=(arr[n-1]-arr[0]+1)/(n-1);
                }
                else if((arr[n-1]-arr[0]-1)%(n-1)==0){
                    pt[2]=(arr[n-1]-arr[0]-1)/(n-1);
                }
                else if((arr[n-1]-arr[0]-2)%(n-1)==0){
                    pt[3]=(arr[n-1]-arr[0]-2)/(n-1);
                }
                else if((arr[n-1]-arr[0]+2)%(n-1)==0){
                    pt[4]=(arr[n-1]-arr[0]+2)/(n-1);
                }
                else{
                    pw.println(-1);
                    return;
                }
                int x = Integer.MAX_VALUE;
                for(int p:pt) {
                    int lst = arr[0];
                    int chgs = 0;
                    for (int i = 1; i < n; i++) {
                        if (lst + p == arr[i] + 1) {
                            lst = arr[i] + 1;
                            chgs++;
                        } else if (lst + p == arr[i] - 1) {
                            lst = arr[i] - 1;
                            chgs++;
                        } else if (lst + p == arr[i]) {
                            lst = arr[i];
                        } else {
                            chgs = Integer.MAX_VALUE;
                            break;
                        }
                    }
                    int lst2 = arr[0] + 1;
                    int chgs2 = 1;
                    for (int i = 1; i < n; i++) {
                        if (lst2 + p == arr[i] + 1) {
                            lst2 = arr[i] + 1;
                            chgs2++;
                        } else if (lst2 + p == arr[i] - 1) {
                            lst2 = arr[i] - 1;
                            chgs2++;
                        } else if (lst2 + p == arr[i]) {
                            lst2 = arr[i];
                        } else {
                            chgs2 = Integer.MAX_VALUE;
                            break;
                        }
                    }
                    int lst3 = arr[0] - 1;
                    int chgs3 = 1;
                    for (int i = 1; i < n; i++) {
                        if (lst3 + p == arr[i] + 1) {
                            lst3 = arr[i] + 1;
                            chgs3++;
                        } else if (lst3 + p == arr[i] - 1) {
                            lst3 = arr[i] - 1;
                            chgs3++;
                        } else if (lst3 + p == arr[i]) {
                            lst3 = arr[i];
                        } else {
                            chgs3 = Integer.MAX_VALUE;
                            break;
                        }
                    }
                    int m = Math.min(Math.min(chgs,chgs2),chgs3);
                    x = Math.min(m,x);
                }
                //pw.println(p);
                if(x==Integer.MAX_VALUE){
                    pw.println(-1);
                    return;
                }
                pw.println(x);

            }
        }

        static class tup implements Comparable<tup> {
            int a, b;

            tup() {
            }

            ;



            tup(int a, int b) {
                this.a = a;
                this.b = b;
            }

            @Override
            public int compareTo(tup o2) {
                return a==o2.a?Integer.compare(o2.b,b):Integer.compare(o2.a, a);
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