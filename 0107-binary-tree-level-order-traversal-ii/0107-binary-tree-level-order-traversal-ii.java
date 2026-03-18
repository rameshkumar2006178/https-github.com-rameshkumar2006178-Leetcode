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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> res =new LinkedList<>();
        List<Integer> temp;  
          if(root==null){
            return res;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            temp =new ArrayList<>();
           
            int n=q.size();         
            for(int i=0;i<n;i++){
                TreeNode cur=q.poll();  
                temp.add(cur.val); 
               
            
            if(cur.left != null){
                q.add(cur.left);          
            }
            if(cur.right!=null){
               q.add(cur.right);
            }
            }
             res.add(0,temp);  
        }
        return res;
    }
    }
