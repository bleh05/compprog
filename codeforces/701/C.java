import java.io.*;
import java.util.*;

public class template {
	public static void main(String[] args) throws IOException {
		FastReader scan = new FastReader();
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teamwork.out")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		Task solver = new Task();
		//int t = scan.nextInt();
		int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}
	static class Task {
		static char[] arr;
		static HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		static Set<Character> ad = new HashSet<Character>();
		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			int n = sc.nextInt();
			arr=new char[n];
			String str = sc.nextLine();
			for(int i=0;i<n;i++) {
				arr[i]=str.charAt(i);
				ad.add(arr[i]);
			}
			pw.println(search(n));
		}
		public static boolean get(int mid) {
			if(mid>arr.length)return true;
			for(char x : ad) {
				hm.put(x,0);
			}
			for(int i=0;i<mid;i++) {
				hm.put(arr[i],hm.get(arr[i])+1);
			}
			boolean ret= true;
			for(int x : hm.values()) {
				if(x==0) {
					ret=false;
					break;}
			}
			//System.out.println(hm);
			if(ret)return true;
			for(int i=0;i<arr.length-mid;i++) {
				hm.put(arr[i],hm.get(arr[i])-1);
				hm.put(arr[i+mid],hm.get(arr[i+mid])+1);
				ret=true;
				for(int x : hm.values()) {
					if(x==0) {
						ret=false;
						break;
					}
				}
				//System.out.println(hm);
				if(ret)return true;
			}
			return false;
		}
		public static long search(int m){
			for(int i=1;i<=6;i++) {
				//System.out.println(get(i));
			}
			int lo = 1, hi = m*2;
			int x = (int)(Math.log(hi)/Math.log(2));
		    for(int i=0;i<=x;i++) {
		        int mid = (lo+hi)/2;
		        //System.out.println(mid);
		        if (get(mid)) {
		            hi = mid;
		        } else {
		            lo = mid+1;
		        }
		    }
		    if (get(Integer.max(lo, hi))) {
		        return Integer.max(lo, hi);
		    } else {
		        return Integer.min(lo, hi);
		    }
		}
	}
	static class pair{
		int t, w;
		pair(int t, int w){
			this.t=t;
			this.w=w;
		}
		public String toString() {
			return t+" "+w;
		}
	}
	static void shuffle(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	static void shuffle(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			long temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}