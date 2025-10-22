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

        // 음수면 양수로
        long target = Math.abs(K) + 1;
        int cnt = 0;
        while (target % 2 == 0) {
            target /= 2;
            cnt++;
        }

        if(target == 1) {
            System.out.println(cnt);
        } else {
            System.out.println("-1");
        }
        sc.close();
    }
}