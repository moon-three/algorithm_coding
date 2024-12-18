import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = "";
        
       for(int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if('a' <= ch && ch <= 'z') {
                ch -= 32;
            } 
            else if('A' <= ch && ch <= 'Z') {
                ch += 32;
            }
           b += ch;
        }
        System.out.println(b);
    }
}