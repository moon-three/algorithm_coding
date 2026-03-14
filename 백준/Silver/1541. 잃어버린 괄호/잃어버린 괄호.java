import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();

        String[] sArr = data.split("-");
        // [55] [50+40]

        int answer = 0;
        for(int i = 0; i < sArr.length; i++) {
            String[] temp = sArr[i].split("\\+");
            int sum = 0;
            for(String s : temp) {
                sum += Integer.parseInt(s);
            }
            if(i==0) answer += sum;
            else answer -= sum;
        }

        System.out.println(answer);
        sc.close();
    }
}
