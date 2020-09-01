package template.tree;

import java.util.ArrayList;
import java.util.List;

public class 逆时针打印树边界 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        ans.add(root.val);
        if(root.left != null){
            dfsForLeft(root.left, ans);
        }
        if(root.right != null){
            dfsForRight(root.right, ans);
        }
        return ans;
    }

    public void dfsForLeft(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }else if(root.left != null){
            ans.add(root.val);
            dfsForLeft(root.left, ans);
            dfsForLeaf(root.right, ans);
        }else{
            ans.add(root.val);
            dfsForLeft(root.right, ans);
        }
    }

    public void dfsForLeaf(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }else if(root.left == null && root.right == null){
            ans.add(root.val);
        }else {
            dfsForLeaf(root.left, ans);
            dfsForLeaf(root.right, ans);
        }
    }

    public void dfsForRight(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }else if(root.right != null){
            dfsForLeaf(root.left, ans);
            dfsForRight(root.right, ans);
            ans.add(root.val);
        }else{
            dfsForRight(root.left, ans);
            ans.add(root.val);
        }
    }
}
