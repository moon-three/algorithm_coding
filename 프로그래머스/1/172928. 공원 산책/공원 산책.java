import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int n = park.length;
        int m = park[0].length();
        int[] loc = new int[2];
        
        String[][] map = new String[n][m];
        for(int i = 0; i < n; i++) {
            map[i] = park[i].split("");
            for(int j = 0; j < m; j++) {
                if(map[i][j].equals("S")) {
                    loc[0] = i;
                    loc[1] = j;
                }
            }
        }
        
        for(int i = 0; i < routes.length; i++) {
            String[] route = routes[i].split(" ");
            String op = route[0];
            int size = Integer.parseInt(route[1]);
            boolean flag = false;
            if(op.equals("E")) {
                for(int j = loc[1]; j <= loc[1] + size; j++) {
                    if(j >= m || map[loc[0]][j].equals("X")) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) loc[1] = loc[1] + size;
            } else if(op.equals("W")) {
                for(int j = loc[1]; j >= loc[1] - size; j--) {
                    if(j < 0 || map[loc[0]][j].equals("X")) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) loc[1] = loc[1] - size;
            } else if(op.equals("S")) {
                for(int j = loc[0]; j <= loc[0] + size; j++) {
                    if(j >= n || map[j][loc[1]].equals("X")) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) loc[0] = loc[0] + size;
            } else if(op.equals("N")) {
                for(int j = loc[0]; j >= loc[0] - size; j--) {
                    if(j < 0 || map[j][loc[1]].equals("X")) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) loc[0] = loc[0] - size;
            }
        }
        
        return loc;
    }

}