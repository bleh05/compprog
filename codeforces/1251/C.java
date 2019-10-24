import java.util.*;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigInteger;
public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		for(int i =0;i<n;i++){
			String str = sc.nextToken();
			ArrayList<Integer> even = new ArrayList<Integer>();
			ArrayList<Integer> odd = new ArrayList<Integer>();
			for(int j=0;j<str.length();j++){
				if(Integer.parseInt(str.substring(j,j+1))%2==0){
					even.add(j);
				}
				else{
					odd.add(j);
				}
			}
			//System.out.println(even);
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			String a = str.replaceAll("[13579]", "");
			String b = str.replaceAll("[02468]", "");
			int oddi =0;
			for(char x : a.toCharArray()){
				if(oddi<odd.size()&&x>str.charAt(odd.get(oddi))){
					while(oddi<odd.size()&&x>str.charAt(odd.get(oddi))){
						sb1.append(str.charAt(odd.get(oddi)));
						oddi++;
					}
					sb1.append(x);
				}
				else{
					sb1.append(x);
				}
			}
			for(;oddi<odd.size();oddi++){
				sb1.append(str.charAt(odd.get(oddi)));
			}
			int evei =0;
			for(char x : b.toCharArray()){
				if(evei<even.size()&&x>str.charAt(even.get(evei))){
					while(evei<even.size()&&x>str.charAt(even.get(evei))){
						sb2.append(str.charAt(even.get(evei)));
						evei++;
					}
					sb2.append(x);
				}
				else{
					sb2.append(x);
				}
			}
			for(;evei<even.size();evei++){
				sb2.append(str.charAt(even.get(evei)));
			}
			pw.println(sb1.toString().compareTo(sb2.toString())>0?sb2:sb1);
		}
		pw.close();
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