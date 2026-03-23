/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int Sum(TreeNode root,int sum)
    {
        if(root==null){
            return 0;
        }
        sum =root.val+sum*10;
         if(root.right==null && root.left==null){
            return sum;
        }
        return Sum(root.left,sum) + Sum(root.right,sum);
        
    }
    public int sumNumbers(TreeNode root) {
        int sum=0;
        return Sum(root,sum);
    }
}