import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    int n = sc.nextInt();
    for(int i=0;i<n;i++){
      int x = 0;
      int l = sc.nextInt();
      int r = sc.nextInt();
      String str = sc.nextToken();
      String c1 = gen1(l);
      String c2 = gen2(l);
      String c3 = gen3(l);
      int tm1 = check(str.substring(0,r),c1);
      int tm2 = check(str.substring(0,r),c2);
      int tm3 = check(str.substring(0,r),c3);
      x=min(tm1,tm2,tm3,Integer.MAX_VALUE);
      for(int f=0,j=r;j<l;j++,f++){
        char re = str.charAt(f);
        char one=c1.charAt(f);
        char two=c2.charAt(f);
        char thr=c3.charAt(f);
        tm1-=(re!=one?1:0);
        tm2-=(re!=two?1:0);
        tm3-=(re!=thr?1:0);
        re = str.charAt(j);
        one=c1.charAt(j);
        two=c2.charAt(j);
         thr=c3.charAt(j);
        tm1+=(re!=one?1:0);
        tm2+=(re!=two?1:0);
        tm3+=(re!=thr?1:0);
        x=min(tm1,tm2,tm3,x);
      }
      pw.println(x);
    }
		pw.close();
	}
  static int min(int a,int b, int c,int d){
    if(d<a&&d<b&&d<c)
    return d;
    else if(a<b&&a<c){
      return a;
    }
    else if(b<c)return b;
    return c;
  }
 static int check(String str, String str1){
    int ct=0;
    for(int i =0;i<str.length();i++){
      if(str.charAt(i)!=str1.charAt(i))ct++;
    }
    return ct;
  }
  static String gen1(int len){
    StringBuilder s = new StringBuilder();
    for(int i=0;i<len;i++){
      if(i%3==0){
        s.append("R");
      }
      if(i%3==1){
        s.append("G");
      }
      if(i%3==2){
        s.append("B");
      }
    }
    return s.toString();
  }
static  String gen2(int len){
StringBuilder s = new StringBuilder();
    for(int i=0;i<len;i++){
      if(i%3==0){
        s.append("G");
      }
      if(i%3==1){
        s.append("B");
      }
      if(i%3==2){
        s.append("R");
      }
    }
    return s.toString();
  }
static  String gen3(int len){
    StringBuilder s = new StringBuilder();
    for(int i=0;i<len;i++){
      if(i%3==0){
        s.append("B");
      }
      if(i%3==1){
        s.append("R");
      }
      if(i%3==2){
        s.append("G");
      }
    }
    return s.toString();
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