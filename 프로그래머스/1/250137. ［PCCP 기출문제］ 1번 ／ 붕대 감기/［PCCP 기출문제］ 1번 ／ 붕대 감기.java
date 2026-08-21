class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int idx = 0;
        int time = 0;
        int successTime = 0;
        int curHp = health;
        
        while(true) {
            if(idx == attacks.length) break;

            time++; 
            if(time == attacks[idx][0]) {
                curHp -= attacks[idx][1];
                successTime = 0;
                idx++;
            } else {
                successTime++;
                int x = bandage[1];
                if(successTime == bandage[0]) {
                    x += bandage[2];
                    successTime = 0;
                }
                curHp = Math.min(curHp + x, health);
            }
            
            if(curHp <= 0) return -1;
        }
        
        return curHp;
    }
}