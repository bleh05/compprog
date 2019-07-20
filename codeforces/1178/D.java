import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class template {
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int x = sc.nextInt();
		int y=0;
		for(int i=x;i<=1.5*x;i++) {
			if(isPrime(i)) {
				y=i;
				break;
			}
			
		}
		pw.println(y);
		for(int i=1;i<=x;i++) {
			pw.println(i+" "+(i%x+1));
			y--;
		}
		boolean[] arr = new boolean[x+1];
		for(int i=1;i<=y;i++) {
			if(arr[i]||arr[i+2]) {
				y++;
				continue;
			}
			pw.println(i+" "+(i+2));
			arr[i]=true;
			arr[i+2]=true;
		}
		pw.close();
	}
	static boolean isPrime(int n) 
    { 
        // Corner case 
        if (n <= 1) 
            return false; 
  
        // Check from 2 to n-1 
        for (int i = 2; i < n; i++) 
            if (n % i == 0) 
                return false; 
  
        return true; 
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