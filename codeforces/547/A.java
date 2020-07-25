import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;
 
public class TaskA_ok {
    private final InputReader reader;
    private final OutputWriter writer;
 
    public TaskA_ok(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }
 
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        OutputWriter writer = new OutputWriter(System.out);
        new TaskA_ok(reader, writer).run();
        writer.writer.flush();
    }
 
    public void run() {
        long p = reader.nextLong();
        long v1 = reader.nextLong();
        long t1 = reader.nextLong();
        long k1 = reader.nextLong();
        long b1 = reader.nextLong();
        long v2 = reader.nextLong();
        long t2 = reader.nextLong();
        long k2 = reader.nextLong();
        long b2 = reader.nextLong();
 
        long f = 0;
        while (v1 != t1) {
            v1 = (v1 * k1 + b1) % p;
            v2 = (v2 * k2 + b2) % p;
            f++;
            if (f > p + 1) {
                writer.printf("-1\n");
                return;
            }
        }
        if (v2 == t2) {
            writer.printf("%d\n", f);
            return;
        }
        long per = 0;
        long pk2 = 1, pb2 = 0;
        while (per == 0 || v1 != t1) {
            v1 = (v1 * k1 + b1) % p;
            pk2 = (pk2 * k2) % p;
            pb2 = (pb2 * k2 + b2) % p;
            per++;
            if (per > p + 1) {
                writer.printf("%d\n", -1);
                return;
            }
        }
        long f2 = 0;
        while (v2 != t2) {
            f2++;
            v2 = (pk2 * v2 + pb2) % p;
            if (f2 > p + 1) {
                writer.printf("-1\n");
                return;
            }
        }
        writer.printf("%d\n", f + per * f2);
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
 
        public double nextDouble() {
            return Double.parseDouble(next());
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
 
    static class OutputWriter {
        public PrintWriter writer;
 
        OutputWriter(OutputStream stream) {
            writer = new PrintWriter(stream);
        }
 
        public void printf(String format, Object... args) {
            writer.print(String.format(Locale.ENGLISH, format, args));
        }
    }
}
 