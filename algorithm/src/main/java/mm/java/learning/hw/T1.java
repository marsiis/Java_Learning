package mm.java.learning.hw;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName mm.java.learning.hw.T1
 * @Description 生成哈夫曼树
 * @Author mars
 * @Date 2024/11/20 8:29
 * @Version 1.0
 **/
public class T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<TreeNode> pq = new PriorityQueue<>(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                if (o1.val != o2.val) return o1.val - o2.val;
                else return o1.height - o2.height;
            }
        });

        for (int i = 0; i < n; i++) {
            pq.add(new TreeNode(sc.nextInt()));
        }

        while (pq.size() > 1) {
            TreeNode left = pq.poll(), right = pq.poll();
            pq.add(TreeNode.createParentTreeNode(left, right));
        }

        f(pq.poll());
    }

    public static void f(TreeNode root) {
        if (root == null) return;
        f(root.left);
        System.out.print(root.val + " ");
        f(root.right);
    }
}


class TreeNode {
    public int val;
    public TreeNode left, right;
    public int height;

    public TreeNode(int x) {
        this.val = x;
        this.height = 1;
    }

    public static TreeNode createParentTreeNode(TreeNode left, TreeNode right) {
        int pval = left.val + right.val;
        TreeNode parentTreeNode = new TreeNode(pval);
        parentTreeNode.left = left;
        parentTreeNode.right = right;
        parentTreeNode.height = Math.max(left.height, right.height) + 1;
        return parentTreeNode;
    }
}