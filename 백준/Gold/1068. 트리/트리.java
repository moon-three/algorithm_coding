import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer>[] tree = new ArrayList[N];
        boolean[] isDeleted = new boolean[N];
        
        for(int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) continue;
            tree[parent].add(i);
        }

        int deleteNode = Integer.parseInt(br.readLine());
        delete(tree, isDeleted, deleteNode);

        int result = 0;
        for(int i = 0; i < N; i++) {
            if(isDeleted[i]) continue;
            boolean isLeaf = true;
            for(int n : tree[i]) {
                if(!isDeleted[n]) {
                    isLeaf = false;
                    break;
                }
            }
            if(isLeaf) result++;
        }

        System.out.println(result);
        br.close();
    }

    public static void delete(List<Integer>[] tree, boolean[] isDeleted, int idx) {
        isDeleted[idx] = true;
        if(tree[idx] == null) return;
        for(int n : tree[idx]) {
            delete(tree, isDeleted, n);
        }
    }
}
