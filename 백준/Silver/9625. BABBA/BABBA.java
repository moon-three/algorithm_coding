import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        // 초기 시작
        int A = 1;
        int B = 0;

        // A는 B로 B는 A,B로 바뀜
        for(int k = 0; k < K; k++) {
            int newA = B;
            int newB = A + B;
            A = newA;
            B = newB;
        }
        System.out.println(A + " " + B);
        sc.close();
    }
}
