class Solution {
    public int[] findOrder(int V, int[][] edges) {
         ArrayList< ArrayList<Integer>> adj=new  ArrayList<>();
         for(int i=0;i<V;i++)
         {
             adj.add(new  ArrayList<>());
         }
         
         for(int[] edge:edges){
             adj.get(edge[1]).add(edge[0]);
         }
         int[] ind=new int[V];
         for(int i=0;i<V;i++){
             for(int n :adj.get(i)){
                 ind[n]++;
             }
         }
         Queue<Integer> q=new LinkedList<>();
         for(int i=0;i<V;i++)
         {
             if(ind[i]==0)
             {
                 q.add(i);
             }
         }
        //   ArrayList<Integer> res=new  ArrayList<>();
          int[] n=new int[V];
          int i=0;
          while(!q.isEmpty())
          {
              int ver=q.poll();
              n[i++]=ver;
            
              for(int nel: adj.get(ver))
              {    
                  ind[nel]--; 
                  if(ind[nel]==0)
                  {
                      q.add(nel);
                  }
              }      
          }
          if(i==V){
            return n;
          }
          else{
            return new int[]{};
          }
    }
}