package sample.sleepready;

public class Problems {

    public static Integer findMaxInTree(Trees.BinaryTreeNode root, Integer max){
        if(root == null) return max;

        max = Math.max(max, root.data);

        return Math.max(findMaxInTree(root.left, max), findMaxInTree(root.right, max));
    }
}
