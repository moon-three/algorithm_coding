public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10001];

        for(int i = 1; i <= 10000; i++) {
            int n = d(i);
            if(n > 10000) continue;
            arr[n] += 1;
        }

        for(int i = 1; i <= 10000; i++) {
            if(arr[i] == 0) {
                System.out.println(i);
            }
        }
    }

    static int d(int n) {
        int rst = n;
        while (n > 0) {
            rst += n % 10;
            n /= 10;
        }
        return rst;
    }
}
