package com.tjlcast.Interview_Code.tx;


import java.lang.annotation.Documented;

/**
 * Created by tangjialiang on 2018/8/4.
 */
public class ThreeJudgeSymmetry {

    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean work(TreeNode root) {
        if (root == null) return true ;

        return isSame(root.left, root.right) ;
    }

    private boolean isSame(TreeNode leftRoot, TreeNode rightRoot) {
        if (rightRoot==null && leftRoot==null) return true ;
        if (!(rightRoot!=null && leftRoot!=null)) return false ;

        if (rightRoot.val != leftRoot.val) return false ;

        if (isSame(leftRoot.left, rightRoot.right) && isSame(leftRoot.right, rightRoot.left)) return true ;
        return false ;
    }
}
