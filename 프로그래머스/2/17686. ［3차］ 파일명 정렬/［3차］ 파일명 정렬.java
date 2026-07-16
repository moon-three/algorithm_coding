import java.util.*;

class Solution {
    class File implements Comparable<File>{
        String origin;
        String head;
        int number;
        int idx;
        
        public File(String origin, String head, int number, int idx) {
            this.origin = origin;
            this.head = head;
            this.number = number;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(File other) {
            if(this.head.toLowerCase().equals(other.head.toLowerCase())) {
                if(this.number == other.number) return this.idx - other.idx;
                return Integer.compare(this.number, other.number);
            }
            return this.head.toLowerCase().compareTo(other.head.toLowerCase());
        }
    }
        
    public String[] solution(String[] files) {
        File[] fileArr = new File[files.length];
        
        for (int i = 0; i < files.length; i++) {
            int length = files[i].length();
            int idx = 0;
            String head = "";
            String number = "";
            while (idx < length) {
                if('0' <= files[i].charAt(idx) && files[i].charAt(idx) <= '9') break;
                head += files[i].charAt(idx++);
            }
            while(idx < length) {
                if(!('0' <= files[i].charAt(idx) && files[i].charAt(idx) <= '9')) break;
                number += files[i].charAt(idx++);
            }
            File file = new File(files[i], head, Integer.parseInt(number), i);
            fileArr[i] = file;
        }
        
        Arrays.sort(fileArr);
        
        String[] answer = new String[files.length];
        for(int i = 0; i < files.length; i++) {
            answer[i] = fileArr[i].origin;
        }
        
        return answer;
    }
}