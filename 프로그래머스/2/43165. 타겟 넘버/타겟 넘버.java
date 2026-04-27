class Solution {
    static int[] _numbers;
    static int _target;
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        _numbers = numbers;
        _target = target;

        dfs(0, 0);
        
        return cnt;
    }
    
    void dfs(int idx, int sum) {
        if(idx == _numbers.length) {
            if(sum == _target) cnt++;
            return;
        }
        
        dfs(idx+1, sum + _numbers[idx]);
        dfs(idx+1, sum - _numbers[idx]);
    }
}