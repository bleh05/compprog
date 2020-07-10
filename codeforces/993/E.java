
// Problem : E. Nikita and Order Statistics
// Contest : Codeforces - Codeforces Round #488 by NEAR (Div. 1)
// URL : https://codeforces.com/contest/993/problem/E
// Memory Limit : 256 MB
// Time Limit : 2000 ms
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
		static final int inf = Integer.MAX_VALUE;

		public void solve(int testNumber, FastReader sc, PrintWriter pw) {
			//CHECK FOR QUICKSORT TLE
			//***********************//
			//CHECK FOR INT OVERFLOW
			//***********************//
			int n = sc.nextInt();
			int x = sc.nextInt();
			int[] count = new int[n + 1];
			count[0] = 1;
			int current = 0;
            for (int i = 0; i < n; i++) {
                if (x > sc.nextInt()) {
                    current++;
                }
                count[current]++;
            }
            int[] countR = new int[count.length];
            for (int i = 0; i < count.length; i++) {
                countR[i] = count[count.length - 1 - i];
            }
            FFTMultiplication fft = new FFTMultiplication();
            long[] res = fft.convolute(count, countR);
            
            long sum = 0;
            for (long a : count) sum += (a * (a - 1)) / 2;
            pw.print(sum);
            for (int i = 1; i <= n; i++) {
                pw.print(" " + res[n + i]);
            }
            pw.println();
		}
	}
	static class FFTMultiplication {
        public static long[] convolute(int[] a, int[] b) {
            int m = Integer.highestOneBit(Math.max(Math.max(a.length, b.length) - 1, 1)) << 2;
            double[][] fa = fft(a, m, false);
            double[][] fb = a == b ? fa : fft(b, m, false);
            for (int i = 0; i < m; i++) {
                double nfa0 = fa[0][i] * fb[0][i] - fa[1][i] * fb[1][i];
                double nfa1 = fa[0][i] * fb[1][i] + fa[1][i] * fb[0][i];
                fa[0][i] = nfa0;
                fa[1][i] = nfa1;
            }
            fft(fa[0], fa[1], true);
            long[] ret = new long[m];
            for (int i = 0; i < m; i++) {
                ret[i] = Math.round(fa[0][i]);
            }

            return ret;
        }

        public static double[][] fft(int[] srcRe, int n, boolean inverse) {

            int m = srcRe.length;
            double[] dstRe = new double[n];
            double[] dstIm = new double[n];
            for (int i = 0; i < m; i++) {
                dstRe[i] = srcRe[i];
            }

            int h = Integer.numberOfTrailingZeros(n);
            for (int i = 0; i < n; i++) {
                int rev = Integer.reverse(i) >>> 32 - h;
                if (i < rev) {
                    double d = dstRe[i];
                    dstRe[i] = dstRe[rev];
                    dstRe[rev] = d;
                }
            }

            fftCore(n, inverse, dstRe, dstIm);
            if (inverse) {
                for (int i = 0; i < n; i++) {
                    dstRe[i] /= n;
                    dstIm[i] /= n;
                }
            }

            return new double[][]{dstRe, dstIm};
        }

        private static void fftCore(int n, boolean inverse, double[] dstRe, double[] dstIm) {
            for (int s = 2; s <= n; s <<= 1) {
                int nt = s >>> 1;
                double theta = inverse ? -2 * Math.PI / s : 2 * Math.PI / s;
                double wRe = Math.cos(theta);
                double wIm = Math.sin(theta);
                for (int j = 0; j < n; j += s) {
                    double wr = 1, wi = 0;
                    for (int t = j; t < j + nt; t++) {
                   int jp = t + nt;
                        double re = dstRe[jp] * wr - dstIm[jp] * wi;
                        double im = dstRe[jp] * wi + dstIm[jp] * wr;
	                    dstRe[jp] = dstRe[t] - re;
	                    dstIm[jp] = dstIm[t] - im;
	                    dstRe[t] += re;
	                    dstIm[t] += im;
	                    double nwre = wr * wRe - wi * wIm;
	                    double nwim = wr * wIm + wi * wRe;
	                    wr = nwre;
	                    wi = nwim;
	                }
	            }
	        }
	    }

	    public static void fft(double[] re, double[] im, boolean inverse) {
	
	        int n = re.length;
	        int h = Integer.numberOfTrailingZeros(n);
	        for (int i = 0; i < n; i++) {
	            int rev = Integer.reverse(i) >>> 32 - h;
	            if (i < rev) {
	                double d = re[i];
	                re[i] = re[rev];
	                re[rev] = d;
	                d = im[i];
	                im[i] = im[rev];
	                im[rev] = d;
	            }
	        }
	        fftCore(n, inverse, re, im);
	        if (inverse) {
	            for (int i = 0; i < n; i++) {
	                re[i] /= n;
	                im[i] /= n;
	            }
	        }
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