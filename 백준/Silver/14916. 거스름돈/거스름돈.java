import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        int count = 0;
        while (N > 0) {
            if(N % 5 == 0) {
                count += N / 5;
                break;
            }
            N -= 2;
            count += 1;
        }
        if(N < 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
        sc.close();

    }
}