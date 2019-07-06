import java.util.*;
import java.io.*;
public class coverit {
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		while(n-->0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph g = new graph(x);
			while(y-->0) {
				g.addEdge(sc.nextInt()-1, sc.nextInt()-1);
			}
			g.bfs(1);
			int c=0;
			for(int i=0;i<x;i++) {
				c+=g.d[i]%2;
			}
			if(c<x-c) {
				pw.println(c);
				for(int i=0;i<g.d.length;i++) {
					if(g.d[i]%2==1)pw.print(i+1+" ");
				}
				pw.println();
			}
			else {
				pw.println(x-c);
				for(int i=0;i<g.d.length;i++) {
					if(g.d[i]%2==0)pw.print(i+1+" ");
				}
				pw.println();
			}
		}
		pw.close();
	}
}
class graph{
	int vertexct;
	ArrayList<Integer> adjlist[];
    int[] d;
	public graph(int vertexct) {
		this.vertexct=vertexct;
		adjlist= new ArrayList[vertexct];
		for(int i=0;i<vertexct;i++) {
			adjlist[i]=new ArrayList<Integer>();
		}
	}
	public void addEdge(int start, int to) {
		adjlist[start].add(to);
		adjlist[to].add(start);
	}
	public void bfs(int n) {
		Queue<Integer> need = new LinkedList<Integer>();
        boolean visited[] = new boolean[vertexct]; 
        need.add(0);
        d = new int[vertexct];
        Arrays.fill(d, -1);
        d[0]=0;
        int temp=0;
        while(!need.isEmpty()) {
        	temp=need.poll();
        	for(int x : adjlist[temp]) {
        		if(d[x]==-1) {
        			need.add(x);
        			d[x]=d[temp]^1;
        		}
        	}
        }
        	
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