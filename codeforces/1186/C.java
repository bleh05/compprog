import java.util.*;
import java.io.*;
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    int count = 0;
    String a= sc.readLine();
    String b = sc.readLine();
    int index1= 0;
    int index2 = b.length();
    int bzero = b.replaceAll("1","").length();
    int azero = a.substring(index1,index2).replaceAll("1","").length();
    while(index2<=a.length()){
      count+=bzero%2==azero%2?1:0;
      if(a.charAt(index1++)=='0')azero--;
      if(index2<a.length()&&a.charAt(index2)=='0')azero++;
      index2++;
    }
    pw.println(count);
    pw.close();
  }
}