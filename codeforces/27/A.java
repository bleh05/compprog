import java.util.*;
import java.io.*;
public class nexttest {
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		int[] arr = new int[3002];
		for(int i=0;i<n;i++) {
			arr[sc.nextInt()-1]=1;
		}
		for(int i=0;i<3002;i++) {
			if(arr[i]==0) {
				pw.print(i+1);
				break;
			}
		}
		pw.close();
	}
}
class FastScanner {
    BufferedReader br;
    StringTokenizer st;

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