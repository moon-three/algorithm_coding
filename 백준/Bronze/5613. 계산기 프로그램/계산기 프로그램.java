import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int result = 0;
		int num = Integer.parseInt(br.readLine());

		result += num;
		
		while (true) {
			
			String op = br.readLine();
			
			if(!op.equals("=")) {
				num = Integer.parseInt(br.readLine());				
			} else {
				break;
			}
		
			switch (op) {
			
				case "+": 
					result += num;
					break;
				
				case "-": 
					result -= num;
					break;
				
				case "*": 
					result *= num;
					break;
				
				case "/":
					result /= num;
					break;
				case "=":
					break;
				
			}
		}	
		System.out.println(result);
		br.close();	
	}
}