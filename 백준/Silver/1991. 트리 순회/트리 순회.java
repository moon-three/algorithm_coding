import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    char value;
    Node left;
    Node right;
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] parents = new Node[26];

        for (int n = 0; n < 26; n++) {
            parents[n] = new Node();
        }

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char value = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            Node parent = parents[value - 'A'];
            parent.value = value;
            if (left != '.') parent.left = parents[left - 'A'];
            if (right != '.') parent.right = parents[right - 'A'];
        }

        preorder(parents[0]);
        sb.append("\n");
        inorder(parents[0]);
        sb.append("\n");
        postorder(parents[0]);
        System.out.println(sb);
        br.close();
    }

    static void preorder(Node node) {
        if (node == null) {
            return;
        }

        sb.append(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        sb.append(node.value);
        inorder(node.right);
    }

    static void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        sb.append(node.value);
    }
}