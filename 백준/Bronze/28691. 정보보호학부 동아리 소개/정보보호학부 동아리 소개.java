import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		String result = "";
		
		switch (input) {
		case "M":
			result = "MatKor";
			break;
		case "W":
			result = "WiCys";
			break;
		case "C":
			result = "CyKor";
			break;
		case "A":
			result = "AlKor";
			break;
		case "$":
			result = "$clear";
			break;
		}
		
		System.out.println(result);
		sc.close();
	}
}
