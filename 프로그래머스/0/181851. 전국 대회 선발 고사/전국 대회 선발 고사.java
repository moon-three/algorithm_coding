import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student>{
    int rank;
    int idx;
    
    public Student(int rank, int idx) {
        this.rank = rank;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(Student o) {
        return this.rank - o.rank;
    }
}

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        List<Student> list = new ArrayList<>();
        
        for(int i = 0; i < attendance.length; i++) {
            if(attendance[i]) {
                list.add(new Student(rank[i], i));
            }
        }
        
        Collections.sort(list);
        answer += list.get(0).idx * 10000;
        answer += list.get(1).idx * 100;
        answer += list.get(2).idx;
        
        return answer;
    }
}