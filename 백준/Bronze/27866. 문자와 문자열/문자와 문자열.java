import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int i = sc.nextInt();
		
		for(int n=0;n<i;n++) {
			char  c = s.substring(i-1).charAt(0);
			System.out.println(c);
			break;
		}
	
	}
}