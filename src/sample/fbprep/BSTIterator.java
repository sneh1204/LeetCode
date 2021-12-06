package sample.fbprep;

import sample.sleepready.Trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {
    Deque<Trees.TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(Trees.TreeNode root) {
        dfs(root);
    }

    public void dfs(Trees.TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        if(stack.isEmpty()){
            return -1;
        }

        Trees.TreeNode root = stack.pop();
        dfs(root.right);
        return root.data;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
