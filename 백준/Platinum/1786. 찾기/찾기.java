import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String P = br.readLine();
        kmp(T, P);
        System.out.println(cnt);
        System.out.println(sb);
        br.close();
    }

    static void kmp(String parent, String pattern) {
        int[] lps = lps(pattern);
        int i = 0;
        int j = 0;  // pattern idx

        while (i < parent.length()) {
            if(parent.charAt(i) == pattern.charAt(j)) {
                if(j == pattern.length() - 1) {
                    cnt++;
                    sb.append(i - j + 1).append(" ");
                    j = lps[j];
                    i++;
                } else {
                    i++;
                    j++;
                }
            } else {
                if(j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    static int[] lps(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int j = 0;
        int i = 1;
        while(i < m) {
            if(pattern.charAt(j) == pattern.charAt(i)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if(j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
