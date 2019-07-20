import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class template {
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		int[] x = new int[n];
		for(int i=0;i<n;i++) {x[i]=sc.nextInt();}
		int r = x[0];
		ArrayList<Integer> arr =new ArrayList<Integer>();
		arr.add(1);
		int sum=r;
		int tot = r;
		for(int i=1;i<n;i++) {
			if(x[i]*2<=r) {
				sum+=x[i];
				arr.add(i+1);
			}
			tot+=x[i];
		}
		if(sum*2>tot) {
			System.out.println(arr.size());
			for(int xa : arr)
				System.out.print(xa+ " ");
		}
		else System.out.println(0);
		pw.close();
	}
}
@SuppressWarnings("all")
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