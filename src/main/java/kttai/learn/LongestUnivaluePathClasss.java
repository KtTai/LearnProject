package kttai.learn;

import org.junit.Test;

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 */
public class LongestUnivaluePathClasss {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    @Test
    public void testMain(){
        int[] iarr = new int[]{};
        TreeNode treeNode = null;
        for (int i : iarr){

        }
//        System.out.println(this.longestUnivaluePath("aaa"));

    }

    public int longestUnivaluePath(TreeNode root) {
        int leftLong = nextNodeLong(root.left,1);
        int rightLong = nextNodeLong(root.right,1);
        if (root.right != null&&root.left!=null && root.right.val == root.left.val && root.left.val== root.val )
        {
            return leftLong + rightLong;
        }else {
            // thisLong = thisLongRight>thisLongLeft?thisLongRight:thisLongLeft;
            return leftLong>rightLong?leftLong:rightLong;
        }

    }

    private int nextNodeLong(TreeNode nextNode,int preLong){
        int thisLongLeft = 0;
        if (nextNode == null) return preLong;
        if(nextNode.left != null && nextNode.val == nextNode.left.val){
            thisLongLeft = nextNodeLong(nextNode.left,preLong+1);
        }else if (nextNode.left != null && nextNode.val != nextNode.left.val){
            thisLongLeft = nextNodeLong(nextNode.left,0);
        }else {
            //  return thisLongLeft;
            thisLongLeft = preLong;
        }
        int thisLongRight = 0;
        if(nextNode.right != null && nextNode.val == nextNode.right.val){
            thisLongRight = nextNodeLong(nextNode.right,preLong+1);
        }else if (nextNode.right != null && nextNode.val != nextNode.right.val){
            thisLongRight = nextNodeLong(nextNode.right,0);
        }else {
            //  return thisLongRight;
            thisLongRight = preLong;
        }
        int thisLong = 0;
        if (nextNode.right != null&&nextNode.left!=null && nextNode.right.val == nextNode.left.val && nextNode.left.val == nextNode.val )
        {
            thisLong = thisLongRight + thisLongLeft;
        }else {
            thisLong = thisLongRight>thisLongLeft?thisLongRight:thisLongLeft;
        }

        return thisLong;
    }
}
