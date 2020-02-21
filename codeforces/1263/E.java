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
            String str = sc.nextLine();
            int maxn = 0;
            int cu = 0;
            for(char x : str.toCharArray()){
            	if(x=='R'){
            		cu++;
            		maxn = Math.max(maxn, cu);
            	}
            	if(x=='L'){
            		cu=Math.max(0, cu-1);
            		maxn = Math.max(maxn, cu);
            	}
            }
            int[] x = new int[maxn+2];
            int ptr = 0;
            int ct = 0;
            segt seg = new segt(maxn+2);
            for(int i=0;i<n;i++){
                if(str.charAt(i)=='('){
                    int add = 1-x[ptr];
                    x[ptr]=1;	
                    seg.updateMax(1,0,maxn+1,ptr,maxn+1,add);
                    seg.updateMin(1,0,maxn+1,ptr,maxn+1,add);
                    ct+=add;
                }
                else if(str.charAt(i)==')'){
                    int add = -1-x[ptr];
                    x[ptr]=-1;
                    seg.updateMax(1,0,maxn+1,ptr,maxn+1,add);
                    seg.updateMin(1,0,maxn+1,ptr,maxn+1,add);
                    ct+=add;
                }
                else if(str.charAt(i)=='R'){
                    ptr++;
                }
                else if(str.charAt(i)=='L'){
                    ptr=Math.max(0,ptr-1);
                }
                else {
                    int add = -x[ptr];
                    x[ptr]=0;
                    seg.updateMax(1,0,maxn+1,ptr,maxn+1,add);
                    seg.updateMin(1,0,maxn+1,ptr,maxn+1,add);
                    ct+=add;
                }
                if(seg.queryMin(1,0,maxn+1,0,maxn+1)>=0&&ct==0){
                    pw.print(seg.queryMax(1,0,maxn+1,0,maxn+1));
                }
                else{
                    pw.print(-1);
                }
                pw.print(" ");
            }
            pw.println();
        }

    }

    static class segt {
        int[][] t;
        int[] lazyMax;
        int[] lazyMin;
        public segt(int n) {
            t = new int[2][4*n];
            lazyMax = new int[4*n];
            lazyMin = new int[4*n];
        }

        void pushMax(int v) {
            t[0][v*2] += lazyMax[v];
            lazyMax[v*2] += lazyMax[v];
            t[0][v*2+1] += lazyMax[v];
            lazyMax[v*2+1] += lazyMax[v];
            lazyMax[v] = 0;
        }
        void pushMin(int v) {
            t[1][v*2] += lazyMin[v];
            lazyMin[v*2] += lazyMin[v];
            t[1][v*2+1] += lazyMin[v];
            lazyMin[v*2+1] += lazyMin[v];
            lazyMin[v] = 0;
        }

        void updateMax(int v, int tl, int tr, int l, int r, int addend) {
            if (l > r)
                return;
            if (l == tl && tr == r) {
                t[0][v] += addend;
                lazyMax[v] += addend;
            } else {
                pushMax(v);
                int tm = (tl + tr) / 2;
                updateMax(v*2, tl, tm, l, Math.min(r, tm), addend);
                updateMax(v*2+1, tm+1, tr, Math.max(l, tm+1), r, addend);
                t[0][v] = Math.max(t[0][v*2], t[0][v*2+1]);
            }
        }
        void updateMin(int v, int tl, int tr, int l, int r, int addend) {
            if (l > r)
                return;
            if (l == tl && tr == r) {
                t[1][v] += addend;
                lazyMin[v] += addend;
            } else {
                pushMin(v);
                int tm = (tl + tr) / 2;
                updateMin(v*2, tl, tm, l, Math.min(r, tm), addend);
                updateMin(v*2+1, tm+1, tr, Math.max(l, tm+1), r, addend);
                t[1][v] = Math.min(t[1][v*2], t[1][v*2+1]);
            }
        }

        int queryMax(int v, int tl, int tr, int l, int r) {
            if (l > r)
                return -Integer.MAX_VALUE;
            if (l <= tl && tr <= r)
                return t[0][v];
            pushMax(v);
            int tm = (tl + tr) / 2;
            return Math.max(queryMax(v*2, tl, tm, l, Math.min(r, tm)),
                    queryMax(v*2+1, tm+1, tr, Math.max(l, tm+1), r));
        }
        int queryMin(int v, int tl, int tr, int l, int r) {
            if (l > r)
                return Integer.MAX_VALUE;
            if (l <= tl && tr <= r)
                return t[1][v];
            pushMin(v);
            int tm = (tl + tr) / 2;
            return Math.min(queryMin(v*2, tl, tm, l, Math.min(r, tm)),
                    queryMin(v*2+1, tm+1, tr, Math.max(l, tm+1), r));
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
            return Integer.compare(b, o2.b);
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