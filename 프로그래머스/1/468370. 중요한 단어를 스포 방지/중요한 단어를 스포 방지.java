import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {

        boolean[] isSpoiler = new boolean[message.length()];
        // 가려진구간
        for(int i = 0; i < spoiler_ranges.length; i++) {
            int s = spoiler_ranges[i][0];
            int e = spoiler_ranges[i][1];
            for(int j = s; j <= e; j++) {
                isSpoiler[j] = true;
            }
        }

        Set<String> wordSet = new HashSet<>();
        Set<String> importantSet = new HashSet<>();
        
        int start = 0;
        for(int i = 0; i <= message.length(); i++) {
            if(message.length() == i || message.charAt(i) == ' ') {
                String word = message.substring(start, i);
                boolean isHide = false;
                for(int j = start; j < i; j++) {
                    if(isSpoiler[j]) {
                        isHide = true;
                        break;
                    }
                }
                // 내가 가려진 경우 -> wordSet없으면 important
                // 내가 안가려진 경우 -> important에 있으면 빼고 wordSet에 넣기
                if(isHide && !wordSet.contains(word)) {
                    importantSet.add(word);   
                }
                if(!isHide) {
                    if(importantSet.contains(word)) importantSet.remove(word);
                    wordSet.add(word);
                }
                start = i + 1;
            }
        }

        return importantSet.size();
    }
}