import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] table = new int[N+1][10];

        for(int c = 1; c <= 9; c++) {
            table[1][c] = 1;
        }

        for(int n = 2; n <= N; n++) {
            for(int m = 0; m <= 9; m++) {
                if(m == 0) {
                    table[n][m] = table[n - 1][m + 1];
                } else if (m == 9) {
                    table[n][m] = table[n - 1][m - 1];
                } else {
                    table[n][m] = (table[n - 1][m - 1] + table[n - 1][m + 1]) % 1000000000;
                }
            }
        }

        int result = 0;
        for(int m = 0; m <= 9; m++) {
            result = (result + table[N][m]) % 1000000000;
        }

        System.out.println(result);
        sc.close();
    }
}