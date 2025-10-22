import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long K = sc.nextLong();

        // K 가 2^N - 1인 경우 도달 가능

        if(K == 0) {
            System.out.println("0");
            return;
        }

        if(K % 2 == 0) {
            System.out.println("-1");
            return;
        }

        K = Math.abs(K);
        int cnt = 0;
        while (K > 0) {
            K /= 2;
            cnt++;
        }
        System.out.println(cnt);
        sc.close();
    }
}