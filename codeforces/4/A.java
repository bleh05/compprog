import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class Watermelon {

	public static void main (String args[]) throws IOException {
	        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	        int out = Integer.parseInt(sc.readLine());
	        for(int i=1;i<out;i++){
	        	if((out-i)%2==0&&i%2==0){
	        		System.out.println("YES");
	        		return;
	        	}
	        }
	        System.out.println("NO");
	}

}
