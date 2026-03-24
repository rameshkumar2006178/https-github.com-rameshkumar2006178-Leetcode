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
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean flag=false;     
        List<List<Integer>> l=new ArrayList<>();  
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return l ;
        }  
        q.add(root);
        while (!q.isEmpty()){
           
            ArrayList<Integer> m=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
             TreeNode cur=q.poll();
             m.add(cur.val);
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                } 
            }
             if(flag) 
             {
                Collections.reverse(m);

             }
            l.add(m); 
            flag=!flag;
        }
        return l; 
    }

}