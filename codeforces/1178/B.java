import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class template {
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		String str = sc.nextToken();
		StringBuilder a = new StringBuilder();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='v'&&i!=str.length()-1&&str.charAt(i+1)=='v') {
				a.append("w");
			}
			else if(str.charAt(i)=='o') {
				a.append("o");
			}
			
		}
		String s = a.toString();
		long cntG = 0, cntF = 0, result = 0, C=0; 
        // Traversing the given string 
        for (int i = 0; i < s.length(); i++) { 
            switch (s.charAt(i)) { 
            case 'w': 
                cntG++; 
                result+=C; 
                break; 
            case 'o': 
                cntF++; 
                C+=cntG; 
                break; 
            default: 
                continue; 
            } 
        } 
        pw.println(result);
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