import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        char ch = S.charAt(0) == '0' ? '1' : '0';
        int zeroCnt = 0;
        int oneCnt = 0;
        for(int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            if(cur == ch) continue;
            if(cur == '0') zeroCnt++;
            if(cur == '1') oneCnt++;
            ch = cur;
        }
        System.out.println(Math.min(zeroCnt, oneCnt));
        sc.close();
    }
}
