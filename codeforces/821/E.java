import java.util.*;
import java.io.*;


public class Main {
	static int mod = 1000000007;
  public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long k = sc.nextLong();
		long[][] segs = new long[n][3];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 3; j++) segs[i][j] = sc.nextLong();
		}
		mat ans = new mat();
		ans.arr[0][0] = 1;
		for(int i = 0; i < n; i++) {
			mat trans = new mat();
			for (int j = 0; j <= segs[i][2]; j++) {
				if (j > 0) trans.arr[j][j - 1] = 1;
				trans.arr[j][j] = 1;
				if (segs[i][2] - j > 0) trans.arr[j][j + 1] = 1;
			}
			ans = mat.mult(ans, mat.exp(trans, Math.min(segs[i][1], k) - segs[i][0]));
		}
		System.out.println(ans.arr[0][0]);
  }	
	static class mat {
		long[][] arr;
		public mat() {
			arr = new long[16][16];
		}
		static mat mult(mat a, mat b) {
			mat ans = new mat();
			for(int i = 0; i < 16; i++) {
				for(int j = 0; j < 16; j++) {
					for(int k = 0; k < 16; k++) {
						ans.arr[i][j] += a.arr[i][k] * b.arr[k][j];
						ans.arr[i][j] %= mod;
					}
				}
			}
			return ans;
		}
		static mat exp(mat a, long pow) {
			mat ans = new mat();
			for(int i = 0; i < 16; i++) {
					ans.arr[i][i] = 1;
			}
			while(pow > 0) {
				if((pow & 1) == 1) ans = mult(ans, a);
				a = mult(a, a);
				pow >>= 1;
			}
			return ans;
		}
	}
}