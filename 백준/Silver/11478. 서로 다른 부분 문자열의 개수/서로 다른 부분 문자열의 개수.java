import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i <= data.length(); i++) {
			for(int j = i + 1; j <= data.length(); j++) {
				String s = data.substring(i, j);
				set.add(s);
			}
		}
		
		System.out.println(set.size());
		sc.close();
	}
}
