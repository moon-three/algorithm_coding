import java.util.LinkedList;
import java.util.Queue;

class Process {
    int loc, priority;

    public Process(int loc, int priority) {
        this.loc = loc;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
        }

        int cnt = 0;

        while(!queue.isEmpty()) {
            Process cur = queue.poll();
            boolean isFirst = true;

            for(Process next : queue) {
                if(next.priority > cur.priority) {
                    queue.add(cur);
                    isFirst = false;
                    break;
                }
            }

            if(isFirst) {
                cnt++;
                if(cur.loc == location) {
                    return cnt;
                }
            }
        }
        return -1;
    }
}