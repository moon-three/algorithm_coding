import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Group implements Comparable<Group> {
    String mentor;
    String mentee;

    public Group(String mentor, String mentee) {
        this.mentor = mentor;
        this.mentee = mentee;
    }


    @Override
    public int compareTo(Group o) {
        if(this.mentor.equals(o.mentor)) {
            return o.mentee.compareTo(this.mentee);
        }
        return this.mentor.compareTo(o.mentor);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Group[] groups = new Group[N];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String mentor = st.nextToken();
            String mentee = st.nextToken();
            groups[i] = new Group(mentor, mentee);
        }

        Arrays.sort(groups);

        StringBuilder sb = new StringBuilder();
        for(Group g : groups) {
            sb.append(g.mentor).append(" ").append(g.mentee).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}