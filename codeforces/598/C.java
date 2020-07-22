import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy Phan
 */
public class c {
    public static void main(String[] args) {
        FS in = new FS(System.in);
        int n = in.nextInt();
        ArrayList<Vec> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(new Vec(in.nextInt(), in.nextInt(), i+1));
        Collections.sort(list);
        int ind = 0;
        Fract val = new Fract(-100, 1);
        for(int i = 0; i < n; i++) {
            if(val.compareTo(list.get(i).cos(list.get((i+1)%n))) < 0) {
                ind = i;
                val = list.get(i).cos(list.get((i+1)%n));
            }
        }
        System.out.println(list.get(ind).ind + " " + list.get((ind+1)%n).ind);
    }
        
    static class Vec implements Comparable<Vec> {
	long x, y;
        int ind;
        Fract f;
	public Vec(long x, long y, int i) {
            this.x=x;this.y=y;ind=i;
            f = new Fract(x*x*Long.signum(x), mag());
        }
	//angle between 0 and 2PI
        
        public Fract cos(Vec o) {
            long dot = dot(o);
            return new Fract(dot*dot*Long.signum(dot), mag()*o.mag());
        }
        
        public long dot(Vec o) {
            return x*o.x + y*o.y;
        }
        
        public long mag() {
            return dot(this);
        }

        @Override
        public int compareTo(Vec o) {
            if(y >= 0 != o.y >= 0) return Long.compare(o.y, y);
            if(y >= 0) return o.f.compareTo(f);
            return f.compareTo(o.f);
        }
    }
    
    static class Fract implements Comparable<Fract> {
        long a, b;
        int sign;
        
        public Fract(long A, long B) {
            a = Math.abs(A);
            b = Math.abs(B);
            sign = Long.signum(A)*Long.signum(B);
        }
        
        @Override
        public int compareTo(Fract o) {
            if(sign != o.sign) return sign-o.sign;
            long a1 = a;
            long b1 = b;
            long a2 = o.a;
            long b2 = o.b;
            int diff = sign;
            while(a1 != 0 && a2 != 0) {
                long tmp1 = a1/b1;
                long tmp2 = a2/b2;
                if(tmp1 != tmp2) return diff*Long.compare(tmp1, tmp2);
                a1 %= b1;
                a2 %= b2;
                if(a1 == 0 || a2 == 0) break;
                long tmp = a1;
                a1 = b1;
                b1 = tmp;
                tmp = a2;
                a2 = b2;
                b2 = tmp;
                diff *= -1;
            }
            return diff*Long.compare(a1, a2);
        }
    
    }
        
    static class FS {

        BufferedReader in;
        StringTokenizer token;

        public FS(InputStream str) {
            in = new BufferedReader(new InputStreamReader(str));
        }

        public String next() {
            if (token == null || !token.hasMoreElements()) {
                try {
                    token = new StringTokenizer(in.readLine());
                } catch (IOException ex) {
                }
                return next();
            }
            return token.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}