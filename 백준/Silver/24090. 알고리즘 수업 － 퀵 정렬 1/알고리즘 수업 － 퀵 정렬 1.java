import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int CNT = 0;
    public static int N, K;

    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) {
            A[n] = Integer.parseInt(st.nextToken());
        }

        quick_sort(A, 0, N-1);

        if(CNT < K) {
            System.out.println(-1);
        } else {
            System.out.println(result[0] + " " + result[1]);
        }
        br.close();
    }

    public static void quick_sort(int[] A, int p, int r) {
        if(p < r) {
            int q = partition(A, p, r);
            quick_sort(A, p, q - 1);
            quick_sort(A, q + 1, r);
        }
    }

    public static int partition(int[] A, int p, int r) {
        int pivot = A[r];
        int i = p - 1;
        for(int j = p; j < r; j++) {
            if(A[j] <= pivot) {
                i++;
                swap(A, i, j);
            }
        }
        if(i+1 != r) {
            swap(A, i+1, r);
        }
        return i+1;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        CNT++;
        if(CNT == K) {
            result = new int[2];

            result[0] = A[i];
            result[1] = A[j];
        }
    }
}