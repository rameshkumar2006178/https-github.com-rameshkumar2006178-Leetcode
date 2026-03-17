class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
            boolean[] taken=new boolean[nums.length];
            List<Integer> temp=new ArrayList<>();
            backtrack(res,temp,nums,taken);
            return res;
        }
        public void backtrack(List<List<Integer>> res,List<Integer> temp,int[] num,boolean[] taken)
        {
            if(temp.size()==num.length){
                if(!res.contains(temp)){
                res.add(new ArrayList<>(temp));
                return;
                }
            }
            for(int i=0;i<num.length;i++){
                if(taken[i]){
                    continue;
                }
                temp.add(num[i]);
                taken[i]=true;
                backtrack(res,temp,num,taken);
                temp.remove(temp.size()-1);
                taken[i]=false;
                
            }

        }
}