import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        int hanyang = A + C;
        int yongdap = B + D;
        
        if(hanyang > yongdap) System.out.println("Yongdap");
        else if(yongdap > hanyang) System.out.println("Hanyang Univ.");
        else System.out.println("Either");
        br.close();
    }
}