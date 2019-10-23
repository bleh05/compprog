import java.util.*;
import java.io.*;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int l = sc.nextInt();
		long max = 0;
		long min = 0;
		long sum=0;
		int[] arr = new int[l-1];
		for(int i =0;i<l-1;i++) {
			int r =sc.nextInt();
			arr[i]=r;
			sum+=r;
			max=Math.max(sum, max);
			min=Math.min(sum, min);
		}
		if(1+max-min!=l) {
			pw.println(-1);
		}
		else {
			int[] chek = new int[l];
			boolean[] check = new boolean[l+1];
			chek[0]=(int)(1-min);
			check[chek[0]]=true;
			boolean flag = true;
			for(int i = 1;i<l;i++) {
				chek[i]=chek[i-1]+arr[i-1];
				if(chek[i]<=l+1) {
					check[chek[i]]=true;
				}
				else {
					flag=false;
					break;
				}
			}
			for(int i = 1;i<l+1;i++) {
				flag&=check[i];
			}
			if(flag) {
				pw.print(chek[0]);
				for(int i = 1;i<chek.length;i++) {
					pw.print(" "+chek[i]);
				}
			}
			else {
				pw.println("-1");
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