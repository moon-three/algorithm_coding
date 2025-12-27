class Solution {
    int[] _numbers;
    int _target;
    int N;
    int cnt = 0;
    public int solution(int[] numbers, int target) {
        _numbers = numbers;
        _target = target;
        N = numbers.length;

        dfs(0, 0);
        
        return cnt;
    }

    public void dfs(int depth, int sum) {
        if(depth == N) {
            if(sum == _target) cnt++;
            return;
        }
        dfs(depth+1, sum + _numbers[depth]);
        dfs(depth+1, sum + _numbers[depth] * -1);
    }
}