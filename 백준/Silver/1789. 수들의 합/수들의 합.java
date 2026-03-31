import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        sc.close();

        if(S == 1) {
            System.out.println(1);
            return;
        }

        long sum = 0;
        long value = 1;

        while(true) {
            sum += value;
            if(sum > S) {
                System.out.println(value - 1);
                break;
            }
            if(sum == S) {
                System.out.println(value);
                break;
            }
            value++;
        }
    }
}