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
    		int n  =sc.nextInt();
    		int m = sc.nextInt();
    		int c =sc.nextInt();
    		if(4*n*m-2*n-2*m<c){
    			pw.println("NO");
    			return;
    		}
    		ArrayList<tup> arr = new ArrayList<tup>();
    		if(m>1){
			arr.add(new tup(m-1,"R"));
			arr.add(new tup(m-1,"L"));
    		}
    		for(int i=0;i<n-1;i++){
    			arr.add(new tup(1,"D"));
    			if(m>1){
    			arr.add(new tup(m-1,"R"));
    			arr.add(new tup(m-1,"UDL"));
    			}
    		}
    		if(n>0){
    		arr.add(new tup(n-1,"U"));
    		}
    		int z = 0;
    		StringBuilder sb = new StringBuilder();
    		for(tup x : arr){
    			
    			if(x.a*x.b.length()>c){
    				if(c>=x.b.length()){
    					z++;
    				sb.append(c/x.b.length()+" "+x.b+"\n");
    				c-=c/x.b.length()*x.b.length();
    				}
    				if(c>0){
    					z++;
    				sb.append(1+" "+x.b.substring(0,c)+"\n");
    				c=0;
    				}
    			}
    			else{
    				z++;
    				sb.append(x.a+" "+x.b+"\n");
    				c-=x.a*x.b.length();
    			}
    			if(c<=0)break;
    		}
    		pw.println("YES");
    		pw.println(z);
    		pw.println(sb);
        }
    }
    static class tup{
        int a;String b;
        tup(){};
        tup(int a, String b){
            this.a=a;
            this.b=b;
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