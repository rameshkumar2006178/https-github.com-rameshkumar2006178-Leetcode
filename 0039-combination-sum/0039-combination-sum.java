class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result =new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        backtrack(candidates,target,result,temp,0);
        return result;
    }
    void backtrack(int[] cand,int target,List<List<Integer>> res,List<Integer> temp,int start){
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target<=0){
            return;
        }
        for(int i=start;i<cand.length;i++){
            temp.add(cand[i]);
            target=target-cand[i];
            backtrack(cand,target,res,temp,i);
            target=target+cand[i];
            temp.remove(temp.size()-1);
        }
    }
}