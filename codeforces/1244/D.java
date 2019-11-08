import java.util.*;
import java.io.*;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(".out")));
		PrintWriter pw = new PrintWriter(System.out);
		int[][] step = {
				{1,2,3},
				{1,3,2},
				{2,3,1},
				{2,1,3},
				{3,1,2},
				{3,2,1}
		};
		int n =sc.nextInt();
		int[][] arr = new int[3][n];
		for(int i=0;i<3;i++) {
			for(int j = 0;j<n;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		ArrayList<ArrayList<Integer>> adjM = new ArrayList<ArrayList<Integer>>();
		for(int i = 0;i<n;i++) {
			adjM.add(new ArrayList<Integer>());
		}
		for(int i = 0;i<n-1;i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			adjM.get(a).add(b);
			adjM.get(b).add(a);
		}
		boolean cont = true;
		int begin = 0;
		for(int i =0;i<adjM.size();i++) {
			if(adjM.get(i).size()>2) {
				cont = false;
				break;
			}
			else if(adjM.get(i).size()==1) {
				begin = i;
			}
		}
		if(!cont) {
			pw.println(-1);
		}
		else {
			long min = Long.MAX_VALUE;
			int[] out = new int[n];
			for(int t=0;t<6;t++) {
				long sum=0;
				int b4 = -5;
				int pt = begin;
				int[] ans = new int[n];
				for(int i=0;i<n;i++) {	
					sum+=arr[step[t][i%3]-1][pt];
					ans[pt] = step[t][i%3];
					if(adjM.get(pt).get(0)==b4) {
						b4=pt;
						if(i==n-1)break;
						pt=adjM.get(pt).get(1);
					}
					else {
						b4=pt;
						pt=adjM.get(pt).get(0);
					}
				}
				if(sum<min) {
					min=sum;
					out = ans;
				}
			}
			pw.println(min);
			pw.print(out[0]);
			for(int i = 1;i<n;i++) {
				pw.print(" "+out[i]);
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