import java.util.*;

import sun.security.action.GetBooleanAction;

import java.io.*;
import java.math.BigInteger;
public class Main {
	static ArrayList<ArrayList<Integer>> adj= new ArrayList<ArrayList<Integer>>();
	static int sum=0;
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int sn = sc.nextInt();
		int cow = sc.nextInt();
		for(int i=0;i<sn+1;i++) {
			adj.add(new ArrayList<Integer>());
		}
		for(int t =0;t<cow;t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		for(int i=0;i<sn+1;i++) {
			Collections.sort(adj.get(i));
		}
		Boolean[] visited = new Boolean[sn+1];
		 
        for (int i = 0; i < sn+1; i++) 
            visited[i] = false; 
		for (int u = 1; u < sn+1; u++) 
            if (!visited[u]) // Don't recur for u if already visited 
                isCyclicUtil(u, visited, -1) ;
		pw.println(sum);
		pw.close();
	}
	static void isCyclicUtil(int v, Boolean visited[], int parent) 
    { 
        // Mark the current node as visited 
        visited[v] = true; 
        Integer i; 
        
        // Recur for all the vertices adjacent to this vertex 
        for(int j=0;j<adj.get(v).size();j++)
        { 
            i = adj.get(v).get(j); 
  
            // If an adjacent is not visited, then recur for that 
            // adjacent 
            if (!visited[i]) 
            { 
                isCyclicUtil(i, visited, v);
            } 
  
            // If an adjacent is visited and not parent of current 
            // vertex, then there is a cycle. 
            else if (i != parent) {
                sum+=1;
                adj.get(v).remove(j);
                adj.get(i).remove(Collections.binarySearch(adj.get(i), v));
                j--;
            }
        } 
        return; 
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