import java.util.Scanner;
import java.util.Stack;

public class Main {
	 
	static Stack<Character> stack = new Stack<>();
	 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String bomb = sc.nextLine();
		
		char[] sArr = s.toCharArray();
		
		for(int i = 0; i < sArr.length; i++) {
			stack.push(sArr[i]);			
			if(stack.size() >= bomb.length() && sArr[i] == bomb.charAt(bomb.length() - 1)) {
				checkBomb(bomb);
			}
		}
			
		StringBuilder sb = new StringBuilder();
		if(!stack.isEmpty()) {
			for(char value : stack) {
				sb.append(value);
			}
		} else {
			sb.append("FRULA");
		}
		
		System.out.println(sb);
		sc.close();
	}
	
	public static void checkBomb(String bomb) {
		
		for(int i = 0; i < bomb.length(); i++) {
			if(stack.get(stack.size() - bomb.length() + i) != (bomb.charAt(i))) {
				return;
			}
		}
		
		for(int i = 0; i < bomb.length(); i++) {
			stack.pop();
		}
	
	}
	
}