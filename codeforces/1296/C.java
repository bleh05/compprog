import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader scan = new FastReader();
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Task solver = new Task();
        int t = scan.nextInt();
        //int t = 1;
        for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
        out.close();
    }
    static class Task {
        public void solve(int testNumber, FastReader sc, PrintWriter pw) {
        	int n = sc.nextInt();
        	String str = sc.nextLine();
        	HashMap<Long, ArrayList<Integer>> hm = new HashMap<>();
        	long x = 0;
        	long y = 0;
        	hm.put((long) 0,new ArrayList<Integer>());
        	hm.get(0l).add(0);
        	for(int i=0;i<n;i++){
        		if(str.charAt(i)=='U'){
        			y++;
        		}
        		else if(str.charAt(i)=='D'){
        			y--;
        		}
        		else if(str.charAt(i)=='L'){
        			x--;
        		}
        		else{
        			x++;
        		}
        		if(!hm.containsKey(x*200000+y)){
        			hm.put(x*200000+y,new ArrayList<Integer>());
        		}
        		hm.get(x*200000+y).add(i+1);
        	}
        	//pw.println(hm);
        	int min = Integer.MAX_VALUE;
        	int a = 0;
        	int b = 0;
        	for(ArrayList<Integer> s : hm.values()){
        		for(int i=0;i<s.size()-1;i++){
        			if(s.get(i+1)-s.get(i)<min){
        				min=s.get(i+1)-s.get(i);
        				a=s.get(i)+1;
        				b=s.get(i+1);
        			}
        		}
        	}
        	if(min==Integer.MAX_VALUE){
        		pw.println(-1);
        	}
        	else{
        		pw.println(a+" "+b);
        	}
        }
    }
    static class tup implements Comparable<tup>,Comparator<tup>{
        int a, b,c,d;
        tup(){};
        tup(int a, int b,int c, int d){
            this.a=a;
            this.b=b;
            this.c=c;
            this.d=d;
        }

        @Override
        public int compareTo(tup o) {
            return a!=o.a?Integer.compare(o.a,a):Integer.compare(o.b,b);
        }

        @Override
        public int compare(tup o1, tup o2) {
            return o2.b!=o1.b?Integer.compare(o2.b,o1.b):Integer.compare(o2.a,o1.a);
        }
    }

    static class bit {
        int n;
        int[] bit;
        public bit(int n) {
            this.n=n;
            bit=new int[n+1];
        }
        void add(int ind, int c) {
            for(; ind<n;ind|=(ind+1)) {
                bit[ind]=Math.max(bit[ind],c);
            }
        }
        int getMax(int r) {
            int ret = Integer.MIN_VALUE;
            for (; r >= 0; r = (r & (r + 1)) - 1)
                ret = Math.max(ret, bit[r]);
            return ret;
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