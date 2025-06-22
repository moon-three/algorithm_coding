import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String score = sc.nextLine();
		double result = 0;
		
		if(!score.equals("F")) {
			String front = score.split("")[0];
			String back = score.split("")[1];
			
			switch(front) {
			case "A": 
				result = 4;
				break;
			case "B":
				result = 3;
				break;
			case "C":
				result = 2;
				break;
			case "D":
				result = 1;
			}
			
			switch(back) {
			case "+":
				result += 0.3;
				break;
			case "-":
				result -= 0.3;
				break;
			}
		}
		
		System.out.println(result);
		sc.close();
	}
}
