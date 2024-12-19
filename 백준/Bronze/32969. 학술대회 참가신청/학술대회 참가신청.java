import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String value = sc.nextLine();
		
		String[] strArr = {"social", "history", "language", "literacy", "bigdata", "public", "society"};
		
		for(int i = 0; i < strArr.length; i++) {
			if(value.contains(strArr[i])) {
				if(i < 4) System.out.println("digital humanities");
				else System.out.println("public bigdata");
			}
		}
			
	}
}