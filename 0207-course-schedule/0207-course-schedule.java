class Solution {
    ArrayList<ArrayList<Integer>> adj=new  ArrayList<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         for(int i=0;i<numCourses;i++)
        {
            adj.add(new  ArrayList<>());
        }

        for(int[] edge:prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        int[] ind=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int n :adj.get(i)){
                ind[n]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(ind[i]==0)
            {
                q.add(i);
            }
        }
        ArrayList<Integer> res=new  ArrayList<>();
        int count=0;
        while(!q.isEmpty())
        {
            int ver=q.poll();
            count++;
            res.add(ver);
            for(int nel: adj.get(ver))
            {
                ind[nel]--;
                if(ind[nel]==0)
                {
                    q.add(nel);

                }
            }

        }
        if(count==numCourses){
            return true;
        }
        else {
            return false;
        }
    }
}