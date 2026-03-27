import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 666; i <= 10000666; i++) {
            if(String.valueOf(i).contains("666")) {
                N--;
            }
            if(N == 0) {
                System.out.println(i);
                break;
            }
        }
        sc.close();
    }
}