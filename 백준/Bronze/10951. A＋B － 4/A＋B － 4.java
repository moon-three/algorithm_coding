import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
		
			String input = sc.nextLine();
			
			if(input == "") {
				break;
			}
			
			int A = Integer.parseInt(input.split(" ")[0]);
			int B = Integer.parseInt(input.split(" ")[1]);
			
			System.out.println(A + B);
					
		}
		
		sc.close();
	}
}