import java.util.*;

class Solution {
    static int cnt = 0;
    public int solution(int k, int[] num, int[][] links) {
        int answer = 0;
        int length = num.length;
        
        if(k == 1) {
            for(int i = 0; i < length; i++) {
                answer += num[i];
            }
            return answer;
        }

        int[] parent = new int[length];
        Arrays.fill(parent, -1);
        
        for(int i = 0; i < length; i++) {
            int left = links[i][0];
            int right = links[i][1];
            if(left != -1) parent[left] = i;
            if(right != -1) parent[right] = i;
        }

        int root = -1;
        for(int i = 0; i < length; i++) {
            if(parent[i] == -1) {
                root = i;
                break;
            }
        }
        
        int min = 0;
        int max = 0;
        
        for(int i = 0; i < length; i++) {
            if(num[i] > min) min = num[i];
            max += num[i];
        }
 
        while(min < max) {
            int mid = min + (max - min) / 2;
            
            cnt = 0;
            dfs(root, mid, num, links);
            if(cnt + 1 > k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        
        return min;
    }
    
    public static int dfs(int node, int mid, int[] num, int[][] links) {
        if(node == -1) return 0;
        
        int left = dfs(links[node][0], mid, num, links);
        int right = dfs(links[node][1], mid, num, links);
        
        int sum = left + right + num[node];
        if(sum <= mid) return sum;
        
        cnt++;

        if(Math.min(left, right) + num[node] <= mid) return Math.min(left, right) + num[node];
        
        cnt++;
            
        return num[node];
    }
    
}