class Solution {
    String _word;
    char[] chs = {'A', 'E', 'I', 'O', 'U'};
    int result = 0;
    int cnt = 0;
    public int solution(String word) {
        _word = word;
        
        dfs("");
        
        return result;
    }
    
    public void dfs(String cur) {
        if(cur.equals(_word)) {
            result = cnt;
            return;
        }
        
        if(cur.length() == 5) return;
        
        for(int i = 0; i < chs.length; i++) {
            cnt++;
            dfs(cur + chs[i]);
        }
    }
}