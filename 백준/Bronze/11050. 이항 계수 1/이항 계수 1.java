import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int K = Integer.parseInt(data[1]);


        int value1 = 1;
        for(int i = 0; i < K; i++) {
            value1 *= N--;
        }

        int value2 = 1;
        for(int i = K; i > 0; i--) {
            value2 *= i;
        }

        int combination = value1 / value2;
        System.out.println(combination);
        sc.close();
    }
}