import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long D = in.nextLong();
            int q = in.nextInt();
            ArrayList<Long> primes = new ArrayList<>();
            HashMap<Long, Integer> map = new HashMap<>();
            for (long i = 1; i <= Math.sqrt(D); i++) {
                if (D % i == 0) {
                    map.putIfAbsent(i, map.size());
                    map.putIfAbsent(D / i, map.size());
                }
            }
            for (long i = 2; i <= Math.sqrt(D); i++) {
                if (D % i == 0) {
                    primes.add(i);
                    while (D % i == 0) {
                        D /= i;
                    }
                }
            }
            if (D > 1) {
                primes.add(D);
            }
            int[][] primeArr = new int[map.size()][primes.size()];
            for (long val : map.keySet()) {
                long tempVal = val;
                int i = map.get(val);
                for (int j = 0; j < primes.size(); j++) {
                    while (tempVal % primes.get(j) == 0) {
                        tempVal /= primes.get(j);
                        primeArr[i][j]++;
                    }
                }
            }
            long[] factorial = new long[1000];
            long[] invFactorial = new long[1000];
            factorial[0] = 1;
            invFactorial[0] = 1;
            long MOD = 998244353;
            for (int i = 1; i < 1000; i++) {
                factorial[i] = factorial[i - 1] * i;
                factorial[i] %= MOD;
                invFactorial[i] = MathUtils.modFraction(1, factorial[i], MOD);
            }
            while (q-- > 0) {
                long u = in.nextLong();
                long v = in.nextLong();
                int[] first = primeArr[map.get(u)];
                int[] second = primeArr[map.get(v)];
                long res = 1;
                int a = 0;
                int b = 0;
                for (int i = 0; i < primes.size(); i++) {
                    if (first[i] < second[i]) {
                        a += Math.abs(first[i] - second[i]);
                    } else {
                        b += Math.abs(first[i] - second[i]);
                    }
                    res = (res * invFactorial[Math.abs(first[i] - second[i])]) % MOD;
                }
                res = ((res * factorial[a]) % MOD * factorial[b]) % MOD;
                out.println(res);
            }
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }

    static class MathUtils {
        public static long inverse(long a, long mod) {
            long[] inv = extended_gcd(a, mod);
            if (inv[0] != 1) {
                return 0;
            } else {
                return (inv[1] + 2 * mod) % mod;
            }
        }

        public static long modFraction(long a, long b, long mod) {
            //a is numerator, b is denominator
            a %= mod;
            b %= mod;
            long invB = inverse(b, mod);
            if (invB == 0) {
                int[] arr = new int[3];
                System.out.println(arr[4]);
                return -1;
            } else {
                return (invB * a) % mod;
            }
        }

        public static long[] extended_gcd(long a, long b) {
            //three numbers, first is gcd, second is x, third is y
            if (a == 0) {
                return new long[]{b, 0, 1};
            }
            long[] next = extended_gcd(b % a, a);
            long tempX = next[1];
            next[1] = next[2] - (b / a) * next[1];
            next[2] = tempX;
            return next;
        }

    }
}

