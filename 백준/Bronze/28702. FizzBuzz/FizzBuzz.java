import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sArr = new String[3];
        int idx = -1;
        int result = 0;
        for(int i = 0; i < 3; i++) {
            sArr[i] = br.readLine();
            if(!List.of("Fizz", "Buzz", "FizzBuzz").contains(sArr[i])) {
                idx = i;
                result =  Integer.parseInt(sArr[i]);
            }
        }

        result = result + (3-idx);
        if(result % 3 == 0 && result % 5 == 0) System.out.println("FizzBuzz");
        else if(result % 3 == 0) System.out.println("Fizz");
        else if(result % 5 == 0) System.out.println("Buzz");
        else System.out.println(result);
        br.close();
    }
}