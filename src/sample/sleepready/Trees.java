package sample.sleepready;

import java.util.*;

public class Trees {

    public static class TreeNode{
        public TreeNode left, right;
        public int data;
        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        public TreeNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "data=" + data;
        }

        public String print() {
            StringBuilder sb = new StringBuilder();

            Queue<TreeNode> q = new LinkedList<>();
            q.add(this);
            q.add(null);

            sb.append("Level order tree print - \n");
            while(!q.isEmpty()){
                TreeNode last = q.poll();
                if(last != null) {
                    sb.append(last.data).append(" ");
                    if (last.left != null)
                        q.add(last.left);
                    if (last.right != null)
                        q.add(last.right);
                }else{
                    if(!q.isEmpty()) {
                        sb.append("\n");
                        q.offer(null);
                    }
                }
            }
            return sb.toString();
        }
    }

    public static ArrayList<Integer> inOrderRecursive(TreeNode root, ArrayList<Integer> output){
        if(root == null) return output;

        inOrderRecursive(root.left, output);
        output.add(root.data);
        inOrderRecursive(root.right, output);

        return output;
    }

    public static ArrayList<Integer> postOrderRecursive(TreeNode root, ArrayList<Integer> output){
        if(root == null) return output;

        postOrderRecursive(root.left, output);
        postOrderRecursive(root.right, output);
        output.add(root.data);

        return output;
    }

    public static ArrayList<Integer> preOrderRecursive(TreeNode root, ArrayList<Integer> output){
        if(root == null) return output;

        output.add(root.data);
        preOrderRecursive(root.left, output);
        preOrderRecursive(root.right, output);

        return output;
    }

    public static ArrayList<Integer> inorderIterative(TreeNode root){
        ArrayList<Integer> output = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        TreeNode curr = root;
        while (!s.isEmpty() || curr != null) { // run till stack and curr both aren't empty or null
            if (curr != null) { // go to extreme left
                s.push(curr);
                curr = curr.left;
            }
            else {
                curr = s.pop();
                output.add(curr.data);

                curr = curr.right;
            }
        }

        return output;
    }

    public static ArrayList<Integer> postorderIterative(TreeNode root){
        ArrayList<Integer> output = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode cur = s1.pop();
            s2.push(cur);

            if(cur.left != null)
                s1.push(cur.left);
            if(cur.right != null)
                s1.push(cur.right);
        }

        while(!s2.isEmpty()){ // has the elements in order
            output.add(s2.pop().data);
        }

        return output;
    }

    public static ArrayList<Integer> preorderIterative(TreeNode root){
        ArrayList<Integer> output = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode cur = s.pop();
            output.add(cur.data);
            if(cur.right != null)
                s.push(cur.right);
            if(cur.left != null)
                s.push(cur.left);
        }

        return output;
    }

    public static ArrayList<Integer> dfs(TreeNode root, ArrayList<Integer> output){
        if(root == null) return output;

        output.add(root.data);

        dfs(root.left, output);
        dfs(root.right, output);

        return output;
    }

    public static ArrayList<Integer> levelOrderIterative(TreeNode root){ // BFS
        ArrayList<Integer> output = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode last = q.poll();
            output.add(last.data);

            if(last.left != null){
                q.add(last.left);
            }

            if(last.right != null){
                q.add(last.right);
            }
        }

        return output;
    }

    public static void main(String[] args) {
        //Sleep ready codes
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println("***** TREES *****");
        System.out.println(root.print());
        System.out.println("Level order Iterative / BFS " + levelOrderIterative(root)); // easiest

        System.out.println("PreOrder Iterative - " + preorderIterative(root)); // easier than others, learn this to use
        System.out.println("InOrder Iterative - " + inorderIterative(root));
        System.out.println("PostOrder Iterative - " + postorderIterative(root)); // using 2 stacks, 1 stack is very hard

        System.out.println("PreOrder Recursive - " + preOrderRecursive(root, new ArrayList<>()));
        System.out.println("PostOrder Recursive - " + postOrderRecursive(root, new ArrayList<>()));
        System.out.println("InOrder Recursive - " + inOrderRecursive(root, new ArrayList<>()));

        System.out.println("***** GRAPHS *****");
        System.out.println("DFS - " + dfs(root, new ArrayList<>()));

        //Problems
        System.out.println("***** PROBLEMS *****");
        System.out.println("Find Max Recursive - " + Problems.findMaxInTree(root, Integer.MIN_VALUE));
        System.out.println("Find Max Iterative - " + Problems.findMaxInTreeIterative(root));
        System.out.println("Find Max in Each Level Iterative - " + Problems.largestValues(root));
        Problems.largestValuesDFS(root, 0);
        System.out.println("Find Max in Each Level Iterative DFS - " + Problems.res);
        System.out.println("Find Element Recursive - " + Problems.findElementRecursive(root, 7));

        Problems.insertElementRecursive(root, 8); // assuming root != null
        System.out.println("Insert Element Recursive - " + root);

        System.out.println("Size Recursive - " + Problems.treeSizeRecursive(root));

    }

}
