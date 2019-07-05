import java.util.*;
public class stickkk {
	public static void main(String[] args) {
		int x=0;
		Scanner sc = new Scanner(System.in);
		System.out.println((x=sc.nextInt())%2==0?(int)Math.ceil(x/4)-(x%4==0?1:0):0);
	}
}
