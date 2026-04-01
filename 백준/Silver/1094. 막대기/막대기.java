import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int stick = 64;
        int cnt = 0;

        while(stick > 0) {
            if(stick <= X) {
                X -= stick;
                cnt++;
            }
            stick /= 2;
        }

        System.out.println(cnt);
        sc.close();
    }
}