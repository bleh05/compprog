import java.util.*;
import java.io.*;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int l = sc.nextInt();
		int div = sc.nextInt();
		i[] arr = new i[l];
		PriorityQueue<i> pq= new PriorityQueue<i>();
		ArrayList<Integer> leftover = new ArrayList<Integer>();
		for(int i=0;i<l;i++) {
			int b = sc.nextInt();
			i a = new i(b,b%div);
			arr[i] = a;
			pq.add(a);
		}
		long sum = 0;
		for(int i=0;i<l;i++) {
			i z = pq.poll();
			int goal = i/(l/div);
			while(goal<z.mod) {
				leftover.add(goal);
				i++;
				goal = i/(l/div);
			}
			sum+=goal-z.mod;
			z.i+=goal-z.mod;
		}
		for(int a:leftover) {
			i z = pq.poll();
			sum+=a-z.mod+div;
			z.i+=a-z.mod+div;
		}
		pw.println(sum);
		for(i i:arr) {
			pw.print(i.i+" ");
		}
		pw.close();
	}
	static class i implements Comparable<i>{
		int i;
		int mod;
		public i(int a,int n) {
			i=a;
			mod=n;	
		}
		@Override
		public int compareTo(i o) {
			// TODO Auto-generated method stub
			return Integer.compare(mod, o.mod);
		}
		public String toString() {
			return ""+i;
		}
	}
}
@SuppressWarnings("all")
class FastScanner {
    BufferedReader br;
    StringTokenizer st;
    public FastScanner(BufferedReader d) {
        br=d;
    }
    public FastScanner(String s) {
        try {
            br = new BufferedReader(new FileReader(s));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
 
    String nextToken() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
 
    int nextInt() {
        return Integer.parseInt(nextToken());
    }
 
    long nextLong() {
        return Long.parseLong(nextToken());
    }
 
    double nextDouble() {
        return Double.parseDouble(nextToken());
    }
}