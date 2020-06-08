
// Problem : E. Check Transcription
// Contest : Codeforces - Mail.Ru Cup 2018 Round 3
// URL : https://codeforces.com/contest/1056/problem/E
// Memory Limit : 256 MB
// Time Limit : 3000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class a implements Runnable{
	
    public static void main(String[] args) {
        new Thread(null, new a(), "process", 1<<26).start();
    }
	public void run() {
		FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		//PrintWriter out = new PrintWriter("file.out");
		Task solver = new Task();
		//int t = scan.nextInt();
		int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}

	static class Task {
		class str_hash {
			long MOD, b, c;
			long[] norm, rev, power1, power2;
			
			long mult(long a, long b) {
			    return (a * b) % MOD;
			}
			
			long add(long a, long b) {
			    long c = a + b;
			    if (c >= MOD) {
			        c -= MOD;
			    }
			    return c;
			}
			
			long sub(long a, long b) {
			    long c = a - b;
			    if (c < 0) {
			        c += MOD;
			    }
			    return c;
			}
		 
		    void build(String s, long MOD_, long b_, long c_) {
		        MOD = MOD_; b = b_; c = c_;
		        int n = s.length();
		        power1 = new long[n];
		        power1[0] = 1;
		        power2 = new long[n];
		        power2[0] = 1;
		        for (int i = 1; i < n; i++) {
		            power1[i] = mult(power1[i - 1], b);
		            power2[i] = mult(power2[i - 1], c);
		        }
		        norm = new long[n+1];
		        for (int i = 0; i < n; i++) {
		            norm[i + 1] = add(mult(mult(norm[i], b), c), s.charAt(i));
		        }
		        rev = new long[n+1];
		        for (int i = n - 1; i >= 0; i--) {
		            rev[i] = add(mult(mult(rev[i + 1], b), c), s.charAt(i));
		        }
			}
		 
			long get_norm(int L, int R) {
			    if (L > R) {
			    	int temp = R;
			    	R = L;
			    	L = temp;
			    }
			    R++;
			    return sub(norm[R], mult(mult(norm[L], power1[R - L]), power2[R - L]));
			}
			
			long get_rev(int L, int R) {
			    if (L > R) {
			    	int temp = R;
			    	R = L;
			    	L = temp;
			    }
			    R++;
			    return sub(rev[R], mult(mult(rev[L], power1[R - L]), power2[R - L]));
			}
			
			boolean is_pal(int L, int R) {
			    return get_norm(L, R) == get_rev(L, R);
			}
		}
		static final int inf = Integer.MAX_VALUE;

		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			String match = sc.nextLine();
			String orig = sc.nextLine();
			int a = 0; 
			int b = 0;
			int n = match.length();
			int first0 = -1;
			int first1 = -1;
			long prime1 = 216171409;
			long prime2 = 464499611;
			long mod = 1000000009;
			str_hash hash =new str_hash();
			hash.build(orig, mod, prime1, prime2);
			for(int i = 0; i < n; i++) {
				if(match.charAt(i) == '0') {
					a++;
					if(first0 == -1) {
						first0 = i;
					}
				}
				else{
					b++;
					if(first1 == -1) {
						first1 = i;
					}
				}
			}
			int ans = 0;
			if(b > a) {
				l:
				for(int len = 1; len < orig.length() / b; len++) {
					int lena = orig.length() - len * b;
					if(lena % a > 0) {
						continue;
					}
					lena /= a;
					long hash0, hash1;
					hash0 = hash.get_norm(len * first0, len * first0 + lena - 1);
					hash1 = hash.get_norm(lena * first1, lena * first1 + len - 1);
					if(hash0 == hash1) continue;
					int ptr = 0;
					for(char x : match.toCharArray()) {
						if(x == '0') {
							if(hash.get_norm(ptr, ptr + lena - 1) != hash0) {
								continue l;
							}
							else{
								ptr += lena;
							}
						}
						else{
							if(hash.get_norm(ptr, ptr + len - 1) != hash1) {
								continue l;
							}
							else{
								ptr += len;
							}
						}
					}
					ans++;
				}
			}
			else{
				l:
				for(int len = 1; len < orig.length() / a; len++) {
					int lenb = orig.length() - len * a;
					if(lenb % b > 0) {
						continue;
					}
					lenb /= b;
					long hash0, hash1;
					hash0 = hash.get_norm(lenb * first0, lenb * first0 + len - 1);
					hash1 = hash.get_norm(len * first1, len * first1 + lenb - 1);
					if(hash0 == hash1) continue;
					int ptr = 0;
					for(char x : match.toCharArray()) {
						if(x == '0') {
							if(hash.get_norm(ptr, ptr + len - 1) != hash0) {
								continue l;
							}
							else{
								ptr += len;
							}
						}
						else{
							if(hash.get_norm(ptr, ptr + lenb - 1) != hash1) {
								continue l;
							}
							else{
								ptr += lenb;
							}
						}
					}
					ans++;
				}
				
			}
			pw.println(ans);
		}
	}
	static long binpow(long a, long b, long m) {
		a %= m;
		long res = 1;
		while (b > 0) {
			if ((b & 1) == 1)
				res = res * a % m;
			a = a * a % m;
			b >>= 1;
		}
		return res;
	}
	static void sort(int[] x){
		shuffle(x);
		Arrays.sort(x);
	}
	static void sort(long[] x){
		shuffle(x);
		Arrays.sort(x);
	}
	static class tup implements Comparable<tup>{
		int a, b;
		tup(int a,int b){
			this.a=a;
			this.b=b;
		}
		@Override
		public int compareTo(tup o){
			return Integer.compare(o.b,b);
		}
	}
	static void shuffle(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(i + 1);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	static void shuffle(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(i + 1);
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