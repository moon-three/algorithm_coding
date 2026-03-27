import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int val = 666;
        while(N > 0) {
            if(String.valueOf(val).contains("666")) N--;
            
            if(N == 0) {
                System.out.println(val);
                break;
            }
            val++;
        }
        sc.close();
    }
}