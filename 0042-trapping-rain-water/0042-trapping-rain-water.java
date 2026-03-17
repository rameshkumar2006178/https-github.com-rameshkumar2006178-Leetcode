class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 3)
            return 0;
        int n=height.length;
        int[] lar=new int[n];
        int[] rar=new int[n];
        lar[0]=height[0];
        rar[n-1]=height[n-1];
        for(int i=1;i<n;i++)
        {
            lar[i]=Math.max(height[i],lar[i-1]);
        }
        for(int i=n-2;i>=0;i--)
        {
            rar[i]=Math.max(height[i],rar[i+1]);
        }
        int res=0;
        for(int i=0;i<n;i++)
        {
            res += Math.min(lar[i],rar[i])-height[i];
        }
        return res;
    }
}