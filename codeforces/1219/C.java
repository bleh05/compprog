import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int n =sc.nextInt();
		String s = sc.nextToken();
		if(s.length()%n==0&&!s.replace("9", "").equals("")){
			String sub = s.substring(0,n);
			boolean r = false;
			for(int i=1;i<s.length()/n;i++) {
				int x =(sub.compareTo(s.substring(n*i,n*(i+1))));
				if(x==0) {
					continue;
				}
				else if(x>0) {
					r=true;
					break;
				}
				else {
					r=true;
					sub=new BigInteger(sub).add(BigInteger.ONE).toString();
					break;
				}
			}
			if(!r) {
				sub=new BigInteger(sub).add(BigInteger.ONE).toString();
			}
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<s.length()/n;i++) {
				sb.append(sub);
			}
			pw.println(sb);
		}
		else {
			int r = s.length()/n+1;
			StringBuilder sub = new StringBuilder("1");
			for(int i=1;i<n;i++) {
				sub.append(0);
			}
			StringBuilder x = new StringBuilder();
			for(int i=0;i<r;i++) {
				x.append(sub);
			}
			pw.println(x);
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