import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int l = sc.nextInt();
		int t = sc.nextInt();
		int[][] grid = new int[l][t];
		boolean[][] rocks = new boolean[l][t];
		for(int i=0;i<l;i++) {
			String str = sc.nextToken();
			for(int j=0;j<t;j++) {
				rocks[i][j]=str.charAt(j)=='.';
			}
		}
		int x=0;
		while(x<l&&rocks[x][0]) {
			grid[x++][0]=1;
		}
		x=0;
		while(x<t&&rocks[0][x]) {
			grid[0][x++]=1;
		}
		for(int i=1;i<l;i++) {
			for(int j=1;j<t;j++) {
				if(!rocks[i][j])grid[i][j]=0;
				grid[i][j]=(get(grid,i,j-1,rocks)+get(grid,i-1,j,rocks))%(int)(1e9+7);
			}
		}
		pw.println(grid[l-1][t-1]);
		pw.close();
	}
	static int get(int[][] arr, int x,int y, boolean[][] rocc) {
		if(x<0||y<0||x>=arr.length||y>=arr[0].length||!rocc[x][y])return 0;
		else return arr[x][y];
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