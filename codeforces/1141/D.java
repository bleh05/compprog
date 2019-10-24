import java.util.*;
import java.io.*;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int l = sc.nextInt();
		String a = sc.nextToken();
		String b = sc.nextToken();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> arr2 = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> n = new ArrayList<Integer>();
		ArrayList<Integer> n2 = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		for(int i=0;i<27;i++) {
			arr.add(new ArrayList<Integer>());
			arr2.add(new ArrayList<Integer>());
		}
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)!='?') {
				arr.get(a.charAt(i)-'a').add(i);
			}
			else {
				arr.get(26).add(i);
			}
		}
		for(int i=0;i<b.length();i++) {
			if(b.charAt(i)!='?') {
				arr2.get(b.charAt(i)-'a').add(i);
			}
			else {
				arr2.get(26).add(i);
			}
		}
		for(int i=0;i<26;i++) {
			int j;
			for(j=0;j<arr.get(i).size()&&j<arr2.get(i).size();j++) {
				c.add(arr.get(i).get(j));
				d.add(arr2.get(i).get(j));
			}
			while(j<arr.get(i).size()) {
				n.add(arr.get(i).get(j));
				j++;
			}
			while(j<arr2.get(i).size()) {
				n2.add(arr2.get(i).get(j));
				j++;
			}
		}
		int i=0;
		int k=0;
		for(k=0;k<n2.size()&&i<arr.get(26).size();k++) {
			c.add(arr.get(26).get(k));
			d.add(n2.get(i));
			i++;
		}
		int i2=0;
		int k2=0;
		for(k2=0;k2<n.size()&&i2<arr2.get(26).size();k2++) {
			c.add(n.get(k2));
			d.add(arr2.get(26).get(i2));
			i2++;
		}
		for(;k<arr.get(26).size()&&k2<arr2.get(26).size();k++,k2++) {
			c.add(arr.get(26).get(k));
			d.add(arr2.get(26).get(k2));
		}
		pw.println(c.size());
		for(i=0;i<c.size();i++) {
			pw.println(c.get(i)+1+" "+(d.get(i)+1));
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