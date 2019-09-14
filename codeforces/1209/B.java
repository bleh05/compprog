import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		boolean[][] arr = new boolean[n][1000];
		String str= sc.nextToken();
		for(int i=0;i<n;i++) {
			arr[i][0]=str.charAt(i)=='1';
		}
		int[][] a = new int[n][2];
		for(int i=0;i<n;i++) {
			a[i][0]=sc.nextInt();
			a[i][1]=sc.nextInt();
		}
		for(int j=0;j<n;j++) {
			boolean curr = arr[j][0];
			for(int i = 0;i<1000;i++) {
				if(i==a[j][1]) {
					curr^=true;
				}
				else if(i>a[j][1]&&(i-a[j][1])%a[j][0]==0) {
					curr^=true;
				}
				arr[j][i]=curr;
			}
		}
		int max = 0;
		for(int i=0;i<1000;i++) {
			int t = 0;
			for(int j=0;j<n;j++) {
				t+=arr[j][i]?1:0;
			}
			max = Math.max(t, max);
		}
		pw.println(max);
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