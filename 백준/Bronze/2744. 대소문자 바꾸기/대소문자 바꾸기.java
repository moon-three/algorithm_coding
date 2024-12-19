import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		String value = sc.nextLine();
		String answer = "";
		
		for(int i = 0; i < value.length(); i++) {
			char ch = value.charAt(i);
			if('a' <= ch && ch <= 'z') {
				ch -= 32;
			} else if('A' <= ch && ch <= 'Z') {
				ch += 32;
			}
			answer += ch + "";
		}	
		System.out.println(answer);
	}
}