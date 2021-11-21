import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Node {
    int happy;
    List<Node> next;

    public Node(int happy) {
        this.happy = happy;
        this.next = new ArrayList<>();
    }
}

class Info {
    int headNo;
    int headYes;

    public Info(int headNo, int headYes) {
        this.headNo = headNo;
        this.headYes = headYes;
    }
}

public class TreeMain {

    private static final StreamTokenizer st
            = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static TreeNode read() {
        int val = nextInt();
        int l = nextInt();
        int r = nextInt();
        TreeNode node = new TreeNode(val);
        if (l != 0) {
            node.left = read();
        }
        if (r != 0) {
            node.right = read();
        }
        return node;
    }

    public static void main(String[] args) {
        int n = nextInt();
        List<Node> nodes = new ArrayList<>(n+1);
        nodes.add(new Node(-1));
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(nextInt()));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            int under = nextInt();
            set.add(under);
            int header = nextInt();
            nodes.get(header).next.add(nodes.get(under));
        }
        nextInt();
        nextInt();
        int a = 0;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                a = i;
            }
        }
        Node root = nodes.get(a);
        Info info = process(root);
        System.out.println(Math.max(info.headNo, info.headYes));
    }

    public static Info process(Node x) {
        // 1.base case (基层员工)
        if (x.next == null) {
            return new Info(0, x.happy);
        }
        // 2.向子树要信息
        int headNo = 0;
        int headYes = x.happy;
        for (Node node : x.next) {
            Info info = process(node);
            headNo += Math.max(info.headNo, info.headYes);
            headYes += info.headNo;
        }
        return new Info(headNo, headYes);
    }
}