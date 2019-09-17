import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int n =sc.nextInt();
		int[] o = new int[4*n+1];
		int[] p= new int[4*n+1];
		int[] r= new int[51];
		int[] d= new int[51]; 
		for(int i=0;i<4*n+1;i++) {
			int x=  sc.nextInt();
			int y= sc.nextInt();
			o[i]=x;
			p[i]=y;
			r[x]++;
			d[y]++;
		}
		int sx =-1;
		int ex =-1;
		int sy =-1;
		int ey =-1;
		for(int i=0;i<r.length;i++) {
			if(r[i]>=n) {
				if(sx==-1) {
					sx=i;
				}
				else ex =i;
			}
			if(d[i]>=n) {
				if(sy==-1) {
					sy=i;
				}
				else ey =i;
			}
		}
		boolean[][] x = new boolean[51][51];
		for(int i=sx;i<=ex;i++) {
			x[i][sy]=true;
			x[i][ey]=true;
		}
		for(int i=sy;i<=ey;i++) {
			x[sx][i]=true;
			x[ex][i]=true;
		}
		for(int i=0;i<4*n+1;i++) {
			if(!x[o[i]][p[i]]) {
				pw.println(o[i]+" "+p[i]);
				break;
			}
		}
		pw.close();
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