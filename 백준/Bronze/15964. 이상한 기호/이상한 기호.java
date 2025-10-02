import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        Long A = Long.parseLong(input[0]);
        Long B = Long.parseLong(input[1]);
        
        System.out.println((A+B)*(A-B));
        sc.close();
    }
}